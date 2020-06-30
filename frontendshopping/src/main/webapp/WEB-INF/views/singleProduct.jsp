<div class="container">
	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Inicio</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/products">Productos</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ol>
		</div>
	</div>

	<!-- Vista de Productos -->
	<div class="row">
		<!-- Imagen de los productos -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive" />
			</div>
		</div>
		<!-- Descripcion del Producto -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />

			<h4>
				Precio: <strong> &#36; ${product.unitPrice}</strong>
			</h4>
			<hr />

			<!-- Deshabilitar direccionamiento  si quantity < 1 -->
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h6>
						<span style="color: red">Producto no disponible!</span>
					</h6>
				</c:when>
				<c:otherwise>
					<h6>Cant. Disponible: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>
			
			<!--  Deshabilitar boton de agregar  -->
			<c:choose>	
				<c:when test="${product.quantity < 1}">
					<a href="javascript:void(0)" class="btn btn-success disabled">
						<strike> <span class="glyphicon glyphicon-shopping-cart"></span>Agregar
							a la lista de Compras
						</strike>
					</a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"> <span
						class="glyphicon glyphicon-shopping-cart"></span> Agregar a la
						lista de Compras
					</a>
				</c:otherwise>

			</c:choose>

			 <a href="${contextRoot}/show/all/products" class="btn btn-primary">
				<span class="glyphicon glyphicon-shopping-cart" /> Volver
			</a>
		</div>
	</div>


</div>