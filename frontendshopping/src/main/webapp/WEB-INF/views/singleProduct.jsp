<div class="container">
	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Inicio</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Productos</a></li>
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
				Precio: <strong> &#36; ${product.unitPrice} /-</strong>
			</h4>
			<hr />

			<h6>Cant. Disponible: ${product.quantity}</h6>

			<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"> 
				<span class="glyphicon glyphicon-shopping-cart"/> Agregar a la lista de Compras
			</a>
			<a href="${contextRoot}/show/all/products" class="btn btn-success"> 
				<span class="glyphicon glyphicon-shopping-cart"/> Volver
			</a>
		</div>
	</div>


</div>