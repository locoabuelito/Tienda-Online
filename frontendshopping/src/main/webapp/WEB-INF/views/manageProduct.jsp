<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- Vista para usuario admin -->
<div class="container">
	<!-- Panel de insercion  -->
	<c:if test="${not empty message}">

		<div class="col-xs-12">
			<div class="alert alert-success" role="alert">
				<button typue="button" class="close" data-dismiss="alert">
					&times; ${message}</button>
			</div>
		</div>
	</c:if>
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Panel de Productos</h4>
				</div>

				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group row">
							<label class="control-label col-sm-2 col-form-label" for="brand">Marca</label>
							<div class="col-sm-10">
								<sf:input type="text" path="brand" class="form-control"
									placeholder="Marca del Producto" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-sm-2 col-form-label" for="name">Modelo</label>
							<div class="col-sm-10">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Nombre del Producto" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-sm-2 col-form-label"
								for="description">Descripcion</label>
							<div class="col-sm-10">
								<sf:textarea type="text" path="description" class="form-control"
									placeholder="Descripcion del Producto" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-sm-2 col-form-label"
								for="unitPrice">Precio Unitario &#36&#36</label>
							<div class="col-sm-10">
								<sf:input type="number" path="unitPrice" class="form-control"
									placeholder="$$" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-sm-2 col-form-label"
								for="quantity">Cantidad</label>
							<div class="col-sm-10">
								<sf:input type="number" path="quantity" class="form-control"
									placeholder="Cantidad del Producto" />
								<sf:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-sm-2 col-form-label">Seleccionar
								imagen</label>
							<div class="col-sm-10">
								<sf:input type="file" path="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-2 col-form-label">Categoria</label>
							<div class="col-sm-10">
								<sf:select class="form-control" path="categoryId"
									items="${categories}" itemLabel="name" itemValue="id" />

								<div class="text-right">
									<br />
									<sf:hidden path="id" />
									<sf:hidden path="code" />
									<sf:hidden path="supplierId" />
									<sf:hidden path="active" />
									<sf:hidden path="purchases" />
									<sf:hidden path="views" />
								</div>
							</div>

						</div>

						<div class="form-group row">
							<div class="col-md-offset-4 col-md-4">
								<input type="submit" name="submit" value="Guardar"
									class="btn btn-primary" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Activacion/Desactivacion de productos -->


	<div class="col-xs-12">
		<h3>Lista de Productos</h3>
	</div>

	<div class="row">
		<div class="col-xs-12">

			<table id="adminProductsTables"
				class="table table-condensed table-bordered">

				<thead>
					<tr>
						<th>Id</th>
						<th>Vista</th>
						<th>Modelo</th>
						<th>Marca</th>
						<th>Cantidad</th>
						<th>Precio</th>
						<th>Activo</th>
						<th>Editar</th>
					</tr>
				</thead>

			</table>

		</div>
	</div>
</div>
