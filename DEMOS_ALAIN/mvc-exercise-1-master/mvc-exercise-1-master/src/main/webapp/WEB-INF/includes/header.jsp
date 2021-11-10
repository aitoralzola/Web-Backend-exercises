<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:set var="browserLanguageLong" scope="page" value="${ fn:split(header['Accept-Language'], ',')[0] }" />
<c:set var="browserLanguage" scope="page" value="${ fn:split(browserLanguageLong, ';')[0] }" />
<c:set var="fmtLanguage" scope="page" value="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}" />

<!DOCTYPE html>
<c:choose>
  <c:when test="${not empty fmtLanguage}">
    <html lang="${fmtLanguage}">
  </c:when>
  <c:otherwise>
    <html lang="${browserLanguage}">
  </c:otherwise>
</c:choose>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="css/style.css" />
  <fmt:bundle basename="resources.Labels">
    <title>MVC Exercise 1 -
      <fmt:message key="${requestScope.pageTitle}" />
    </title>
  </fmt:bundle>
</head>

<body>
  <header>
    <fmt:bundle basename="resources.Labels">
      <h1>MVC Exercise 1 -
        <fmt:message key="${requestScope.pageTitle}" />
      </h1>
      <nav>
        <div id="left-nav">
          <a href="/index.jsp"
            class="${requestScope.pageTitle=='home' || requestScope.pageTitle=='User' ? 'current' : ''}">
            <fmt:message key="home" /></a>
          <a href="/user?action=list" class="${requestScope.pageTitle=='userList' ? 'current' : ''}">
            <fmt:message key="userList" /></a>
          <a href="/user?action=create" class="${requestScope.pageTitle=='createUser' ? 'current' : ''}">
            <fmt:message key="createUser" /></a>
        </div>
        <div id="right-nav">
          <a href="/lang?language=eu&country=ES"
            class="${fn:startsWith(sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'],'eu') ? 'current' : '' }">
            <fmt:message key="language.eu" />
          </a>
          <a href="/lang?language=es&country=ES"
            class="${fn:startsWith(sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'],'es') ? 'current' : '' }">
            <fmt:message key="language.es" />
          </a>
          <a href="/lang?language=en&country=UK"
            class="${fn:startsWith(sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'],'en') ? 'current' : '' }">
            <fmt:message key="language.en" />
          </a>
        </div>
      </nav>
    </fmt:bundle>
    <fmt:bundle basename="resources.Notifications">
      <div id="notifications">
        <c:if test="${not empty sessionScope.error}">
          <p class="error">
            <fmt:message key="${sessionScope.error}" />
          </p>
          <c:remove var="error" scope="session" />
        </c:if>
        <c:if test="${not empty sessionScope.message}">
          <p class="message">
            <fmt:message key="${sessionScope.message}" />
          </p>
          <c:remove var="message" scope="session" />
        </c:if>
      </div>
    </fmt:bundle>
  </header>