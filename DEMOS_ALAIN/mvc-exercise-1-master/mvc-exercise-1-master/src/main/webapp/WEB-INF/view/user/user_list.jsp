<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="pageTitle" scope="request" value="userList" />
<jsp:include page="/WEB-INF/includes/header.jsp" />
<main class="centered-content">
  <div class="card">
    <fmt:bundle basename="resources.Labels">
      <h2 class="card-title"><fmt:message key="userList" /></h2>
      <div class="card-body">
        <table>
            <caption>
              <fmt:message key="userList" />
            </caption>
            <thead>
              <tr>
                <th>
                  <fmt:message key="userId" />
                </th>
                <th>
                  <fmt:message key="username" />
                </th>
                <!-- password shouldn't be shown -->
                <th>
                  <fmt:message key="firstName" />
                </th>
                <th>
                  <fmt:message key="secondName" />
                </th>
                <th>
                  <fmt:message key="email" />
                </th>
                <th>
                  <fmt:message key="edit" />
                </th>
                <th>
                  <fmt:message key="delete" />
                </th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${requestScope.userList}" var="user">
                <tr>
                  <td><a href="user?action=view&userId=${user.userId}">${user.userId}</a></td>
                  <td>${user.username}</td>
                  <!-- password shouldn't be shown -->
                  <td>${user.firstName}</td>
                  <td>${user.secondName}</td>
                  <td>${user.email}</td>
                  <td><a href="user?action=edit&userId=${user.userId}">
                      <fmt:message key="edit" /></a></td>
                  <td><a href="user?action=delete&userId=${user.userId}">
                      <fmt:message key="delete" /></a></td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
      </div>

    </fmt:bundle>
  </table>
</main>
<jsp:include page="/WEB-INF/includes/footer.jsp" />