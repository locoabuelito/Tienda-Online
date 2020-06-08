
<div class="container">

	<div class="row">


		<!-- Would be to display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- to display the actual products -->
		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Inicio</a></li>
							<li class="breadcrumb-item">Productos disponibles</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Inicio</a></li>
							<li class="breadcrumb-item">Categoria</li>
							<li class="breadcrumb-item">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>

			<!-- Datatables jquery -->
			<div class="row">

				<div class="col-lg-12">
					<table id="productListTable" class="table table-borderless">
						<thead class="table-dark">
							<tr>
								<th></th>
								<th>Modelo</th>
								<th>Marca</th>
								<th>Precio</th>
								<th>Cant. Disponible</th>
								<th></th>
							</tr>

						</thead>

<!-- 						<tfoot> -->
<!-- 							<tr> -->
<!-- 								<th></th> -->
<!-- 								<th>Nombre</th> -->
<!-- 								<th>Marca</th> -->
<!-- 								<th>Precio</th> -->
<!-- 								<th>Cant. Disponible</th> -->
<!-- 								<th></th> -->
<!-- 							</tr> -->
<!-- 						</tfoot> -->
					</table>
				</div>

			</div>

		</div>