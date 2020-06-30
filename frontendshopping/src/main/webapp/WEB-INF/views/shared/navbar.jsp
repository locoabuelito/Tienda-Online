<%-- <%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>  --%>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home">Tienda Online</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li id="inicio" class="nav-item"><a class="nav-link" href="${contextRoot}/home">Inicio</a></li>
				<li id="listProducts" class="nav-item"><a class="nav-link" href="${contextRoot}/show/all/products">Productos</a></li>
				<li id="manageProduct" class="nav-item"><a class="nav-link" href="${contextRoot}/manage/products">Control de Productos</a></li>
			</ul>
		</div>
	</div>
</nav>

