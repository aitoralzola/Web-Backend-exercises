<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="currentPage" value="" scope="request" />

<jsp:include page="/WEB-INF/includes/header.jsp" />
<section id="tab-content">
  <article class="db-article">
    <fmt:bundle basename="resources.Labels">
      <h2>
        <fmt:message key="loginForm" />
      </h2>
      <form action="/login" method="post">
        <c:choose>
          <c:when test="${empty sessionScope.username}">
            <div>
              <input  type="text"
                      id="username" 
                      name="username" 
                      placeholder="<fmt:message key='username' />" 
                      required />
              <input  type="password"
                      id="password" 
                      name="password" 
                      placeholder="<fmt:message key='password' />"
                      required />
              <button type="submit" name="action" value="login">
                <fmt:message key="login" />
              </button>
            </div>
          </c:when>
          <c:otherwise>
            <div>
              <p>
                <fmt:message key="hello" />
                <c:out value="${sessionScope.username}" />
              </p>
              <button type="submit" name="action" value="logout">
                <fmt:message key="logout" />
              </button>
            </div>
          </c:otherwise>
        </c:choose>
      </form>
    </fmt:bundle>
  </article>
</section>
<jsp:include page="/WEB-INF/includes/footer.jsp" />