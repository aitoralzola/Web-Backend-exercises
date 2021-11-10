<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:set var="language" scope="page" value="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}" />
<c:if test="${empty language}">
  <c:set var="browserLanguageLong" scope="page" value="${ fn:split(header['Accept-Language'], ',')[0] }" />
  <c:set var="language" scope="page" value="${ fn:split(browserLanguageLong, ';')[0] }" />
</c:if>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <title>JavaEE Exercise</title>
</head>

<body class="single-column">
  <header>
    <fmt:bundle basename="resources.Labels">
      <h1><a href="index.jsp">
          <fmt:message key="dbPlots" /></a></h1>
      <div class="language">
        <a href="lang?language=eu&country=ES" class="${fn:startsWith(language,'eu') ? 'current-lang' : '' }">
          <fmt:message key="language.eu" />
        </a>
        <a href="lang?language=es&country=ES" class="${fn:startsWith(language,'es') ? 'current-lang' : '' }">
          <fmt:message key="language.es" />
        </a>
        <a href="lang?language=en&country=UK" class="${fn:startsWith(language,'en') ? 'current-lang' : '' }">
          <fmt:message key="language.en" />
        </a>
      </div>
    </fmt:bundle>
    <div class="notifications">

      <fmt:bundle basename="resources.Notifications">
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
      </fmt:bundle>
    </div>
    <nav>
      <a href="db?page=db" class="nav-item ${requestScope.currentPage=='db' ? 'current-nav':''}">Dragon Ball</a>
      <a href="db?page=dbz" class="nav-item ${requestScope.currentPage=='dbz' ? 'current-nav':''}">Dragon Ball Z</a>
      <a href="db?page=dbgt" class="nav-item ${requestScope.currentPage=='dbgt' ? 'current-nav':''}">Dragon Ball GT</a>
    </nav>
  </header>