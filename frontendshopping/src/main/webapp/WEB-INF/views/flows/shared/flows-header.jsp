
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="es">

<head>

     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	
	 <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	<%-- 	<meta name="_csrf" content="${_csrf.token}"> --%>
	<%-- 	<meta name="_csrf_header" content="${_csrf.headerName}"> --%>
	<title>Tienda Online - ${title}</title>
	
	<script>
		window.menu = '${title}';
	
		window.contextRoot = '${contextRoot}'
	</script>
	
	<!-- Bootstrap Core CSS --> 
	<link href="${css}/bootstrap.min.css" rel="stylesheet">
	
	<!-- Bootstrap Theme  -->
	<link href="${css}/bootstrap-theme.css" rel="stylesheet">
	
	<!-- Datatables plugin CSS -->
	<link href="${css}/jquery.dataTables.css" rel="stylesheet">
	
	<!-- Custom CSS -->
	<link href="${css}/shop-homepage.css" rel="stylesheet">
	
	

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@ include file="flows-navbar.jsp" %>

		<!-- Page Content -->

		<div class="content">