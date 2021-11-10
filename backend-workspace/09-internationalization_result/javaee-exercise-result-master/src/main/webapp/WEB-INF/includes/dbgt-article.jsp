<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<article class="db-article">
  <h2>Dragon Ball GT</h2>
  <img src="img/dbgt.png" alt="Dragon Ball GT logo"/>
  
  <fmt:bundle basename="resources.Content">
      <fmt:message key="dbgtContent"/>
  </fmt:bundle>
</article>