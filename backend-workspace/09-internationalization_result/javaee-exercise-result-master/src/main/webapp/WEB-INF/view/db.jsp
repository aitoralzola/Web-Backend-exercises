<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="currentPage" value="db" scope="request" />

<jsp:include page="/WEB-INF/includes/header.jsp"/>
<section id="tab-content">
	<jsp:include page="/WEB-INF/includes/db-article.jsp"/>
</section>
<jsp:include page="/WEB-INF/includes/footer.jsp"/>