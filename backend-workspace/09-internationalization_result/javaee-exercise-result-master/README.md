# JavaEE Exercise
This repository has the result of the JavaEE Exercise

## Explainations
```index.jsp``` calls LoginController. If ```username``` and ```password``` are equal, we redirect them to ```index.jsp``` again but with the user in the session. There the user can logout.

If a user clicks in a DB link, the pages will be dispatched (not redirected).

If nothing is set as page or something weird, db.jsp will be dispatched.

### Optional.ofNullable(...).orElse(...)
The following code:
```java
String country = Optional.ofNullable(request.getParameter("country")).orElse("UK");
```
Is the same as:
```java
String country = request.getParameter("country");
if(country == null) country = "UK";
```

Many frameworks have the possibility of adding a default value to the parameter if it is null, but basic HttpServletRequest does not.

### WEB-INF
Most of the jsp files are inside ```WEB-INF``` folder. We don't the final users to have access to them if they didn't sign in. As browsers do not have access to that folder but server does, it is the perfect place to put those files.

```index.jsp``` is public and anybody can access it, so it is outside ```WEB-INF``` folder.

### Multiple Resource files.
We have separated the multilingual resources in 3 different parts:
1. **Content**: where the plots are stored in 3 languages.
1. **Labels**: where different labels are stored in 3 different languages.
1. **Notifications**: where success/error messages are stored in 3 different languages.

See that in order to access those string, different fmt tags have to be used:
```jsp
<!--db-article.jsp-->
<fmt:bundle basename="resources.Content"><!--content-->
    <fmt:message key="dbContent"/>
</fmt:bundle>
```
```jsp
<!--index.jsp-->
<fmt:bundle basename="resources.Labels"><!--labels-->
  <h2>
    <fmt:message key="loginForm" />
  </h2>
  <form action="/login" method="post">
    ...
    <input  type="text"
            id="username" 
            name="username" 
            placeholder="<fmt:message key='username' />" 
            required />
    ...
```
```jsp
<!--header.jsp-->
<div class="notifications"> 
    <fmt:bundle basename="resources.Notifications"><!--Notifications-->
    <c:if test="${not empty sessionScope.error}">
        <p class="error"><fmt:message key="${sessionScope.error}"/></p>
        <c:remove var="error" scope="session"/>
    </c:if>
    <c:if test="${not empty sessionScope.message}">
        <p class="message"><fmt:message key="${sessionScope.message}"/></p>
        <c:remove var="message" scope="session"/>
    </c:if>
    </fmt:bundle>
</div>
```

In this last example, we can see that ```sessionScope.message``` does not store the message string, but its key. That way, the message can be extracted from the resource class and therefore the message can be multilingual.

```java
<!-- LoginController.java -->
session.setAttribute("error", "error.login"); <!-- key of the multilingual string -->
```

### Current language
As it can be seen in the example, current language is highlighted in the navigation bar.

In order to get current language, we will try to get JSTL/FMT language. If it is not set, we will get the language from the browser.
```jsp
<!-- header.jsp -->
<c:set var="language" scope="page" value="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}" />
<c:if test="${empty language}">
  <c:set var="browserLanguageLong" scope="page" value="${ fn:split(header['Accept-Language'], ',')[0] }" />
  <c:set var="language" scope="page" value="${ fn:split(browserLanguageLong, ';')[0] }" />
</c:if>
```

That way, we can add the "current" class to the correct language:
```jsp
<div id="language">
    <a	href="lang?language=eu&country=ES"
        class="${fn:startsWith(language,'eu') ? 'current' : '' }">
        <fmt:message key="language.eu"/>
    </a>
    <a	href="lang?language=es&country=ES"
        class="${fn:startsWith(language,'es') ? 'current' : '' }">
        <fmt:message key="language.es"/>
    </a>
    <a	href="lang?language=en&country=UK"
        class="${fn:startsWith(language,'en') ? 'current' : '' }">
        <fmt:message key="language.en"/>
    </a>
</div>
```