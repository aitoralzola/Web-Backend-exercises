<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="pageTitle" scope="request" value="${empty requestScope.user ? 'createUser' : 'editUser'}" />
<jsp:include page="/WEB-INF/includes/header.jsp" />
<main class="centered-content">
  <fmt:bundle basename="resources.Labels">
  <form class="card" action="user" method="post">
    <h2 class="card-title"><fmt:message key="${requestScope.pageTitle}" /></h2>
    <div class="card-body">
      <input type="hidden" name="userId" value="${empty requestScope.user ? '' : requestScope.user.userId}" />
      <label>
        <fmt:message key="username" />:
        <input type="text" name="username" value="${empty requestScope.user ? '' : requestScope.user.username}"
          placeholder="<fmt:message key='username' />"/>
      </label>
      <label>
        <fmt:message key="password" />:
        <input type="password" name="password" placeholder="<fmt:message key='password' />"/>
      </label>
      <label>
        <fmt:message key="firstName" />:
        <input type="text" name="firstName" value="${empty requestScope.user ? '' : requestScope.user.firstName}"
          placeholder="<fmt:message key='firstName' />"/>
      </label>
      <label>
        <fmt:message key="secondName" />:
        <input type="text" name="secondName" value="${empty requestScope.user ? '' : requestScope.user.secondName}"
          placeholder="<fmt:message key='secondName' />"/>
      </label>
      <label>
        <fmt:message key="email" />:
        <input type="email" name="email" value="${empty requestScope.user ? '' : requestScope.user.email }"
          placeholder="<fmt:message key='email' />"/>
      </label>
      <button type="submit" name="action" value="${empty requestScope.user ? 'create' : 'edit' }">
        <fmt:message key="save" /></button>
    </div>
  </fmt:bundle>
  </form>
</main>
<jsp:include page="/WEB-INF/includes/footer.jsp" />