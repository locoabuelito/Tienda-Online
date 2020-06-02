<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%-- 	<meta name="_csrf" content="${_csrf.token}"> --%>
	<%-- 	<meta name="_csrf_header" content="${_csrf.headerName}"> --%>
	<title>Tienda Online - ${title}</title>
	
	<script>
		window.menu = '${title}';
	
		window.contextRoot = '${contextRoot}'
	</script>
	
	<!-- Bootstrap Core CSS  
	<link href="${css}/bootstrap.min.css" rel="stylesheet">-->
	
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
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<div class="content">

			<!-- Loading the home content -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user clicks contact -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load only when user clicks contact -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true }">
				<%@include file="listProducts.jsp"%>
			</c:if>


			<!-- Load only when user clicks show product -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

			<!-- Load only when user clicks manage product -->
			<c:if test="${userClickManageProduct == true}">
				<%@include file="manageProduct.jsp"%>
			</c:if>

			<!-- Load only when user clicks manage product -->
			<c:if test="${userClickShowCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>

		</div>


		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery core JavaScript -->
		<script src="${js}/jquery-3.3.1.min.js"></script>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		<!-- DataTable Plugin -->
 		<script src="${js}/jquery.dataTables.min.js"></script> 

		<!-- 		<!-- DataTable Bootstrap Script -->
		<%-- 		<script src="${js}/bootbox.min.js"></script> --%>

		<!-- Self coded javascript -->
		<script src="${js}/shop-homepage.js"></script>




	</div>

</body>