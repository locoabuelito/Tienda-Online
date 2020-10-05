$(function() {

	// solving the active menu problem
	switch (menu) {

	case 'Inicio':
		$('#inicio').addClass('active');
		break;
	case 'Productos':
		$('#listProducts').addClass('active');
		break;
	case 'Control de Productos':
		$('#manageProduct').addClass('active');
		break;
	// case 'Shopping Cart':
	// $('#userModel').addClass('active');
	// break;
	default:
		if (menu == "Inicio")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	/*
	 * ---------------------------- Lista de productos para el usuario
	 * ----------------------------
	 */
	var $table = $('#productListTable');

	if ($table.length) {
		// console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			// Obteniendo url del JSON para todos los productos
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			// Obteniendo url del JSON para todos los productos por id
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({
					"language" : {
						"sProcessing" : "Procesando...",
						"sLengthMenu" : "Mostrar _MENU_ registros",
						"sZeroRecords" : "No se encontraron resultados",
						"sEmptyTable" : "Ningun dato disponible en esta tabla",
						"sInfo" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
						"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
						"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
						"sInfoPostFix" : "",
						"sSearch" : "Buscar:",
						"sUrl" : "",
						"sInfoThousands" : ",",
						"sLoadingRecords" : "Cargando...",
						"oPaginate" : {
							"sFirst" : "Primero",
							"sLast" : "Último",
							"sNext" : "Siguiente",
							"sPrevious" : "Anterior"
						},
						"oAria" : {
							"sSortAscending" : ": Activar para ordenar la columna de manera ascendente",
							"sSortDescending" : ": Activar para ordenar la columna de manera descendente"
						},
						"buttons" : {
							"copy" : "Copiar",
							"colvis" : "Visibilidad"
						}
					},
					// Cantidad de registros a mostrar
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3', '5', '10', 'Todos' ] ],
					pageLength : 5,
					// Cargando datos a mostrar
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					// Rellenando tabla con la propiedad 'data'
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									if (row.code === null) {
										data = 'Placeholder';
										return '<img src="'
												+ window.contextRoot
												+ '/resources/images/'
												+ data
												+ '.jpg" class="adminDataTableImg"/>';
									}

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';

								}
							},
							{
								data : 'name',
								bSortable : false,
							},
							{
								data : 'brand',
								bSortable : false,
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#36; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Producto no disponible!</span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';

									// Mirar mas detalles del producto
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary">'
											+ '<span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

									// Add al carrito de compras
									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {

										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}
									return str;
								}

							} ]
				});
	}
	// Mostrando mensaje durante 4 segundos
	$alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 4000);
	}
	/*
	 * // Boton switch $('.switch input[type="checkbox"]').on( 'change',
	 * function() { var checkbox = $(this); var checked =
	 * checkbox.prop('checked'); var msg = (checked) ? 'Desea activar este
	 * producto?' : 'Desea desactivar este producto?'; var value =
	 * checkbox.prop('value');
	 * 
	 * bootbox.confirm({ size : "medium", title : "Control de Productos",
	 * message : msg, callback : function(confirmed) { if (confirmed) {
	 * bootbox.alert({ size : 'medium', title : 'Información', message : 'Hara
	 * un cambio en el producto ' + value }); } else { checkbox.prop('checked',
	 * !checked); } } }); });
	 */
	/*
	 * ---------------------------- Tabla para admin
	 * ----------------------------
	 */
	var $adminProducTable = $('#adminProductsTables');

	if ($adminProducTable.length) {

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProducTable
				.DataTable({
					"language" : {
						"sProcessing" : "Procesando...",
						"sLengthMenu" : "Mostrar _MENU_ registros",
						"sZeroRecords" : "No se encontraron resultados",
						"sEmptyTable" : "Ningun dato disponible en esta tabla",
						"sInfo" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
						"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
						"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
						"sInfoPostFix" : "",
						"sSearch" : "Buscar:",
						"sUrl" : "",
						"sInfoThousands" : ",",
						"sLoadingRecords" : "Cargando...",
						"oPaginate" : {
							"sFirst" : "Primero",
							"sLast" : "Último",
							"sNext" : "Siguiente",
							"sPrevious" : "Anterior"
						},
						"oAria" : {
							"sSortAscending" : ": Activar para ordenar la columna de manera ascendente",
							"sSortDescending" : ": Activar para ordenar la columna de manera descendente"
						},
						"buttons" : {
							"copy" : "Copiar",
							"colvis" : "Visibilidad"
						}
					},
					// Cantidad de registros a mostrar
					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10', '30', '50', 'Todos' ] ],
					pageLength : 30,
					// Cargando datos a mostrar
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					// Rellenando tabla con la propiedad 'data'
					columns : [
							{
								data : 'id'
							},

							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg"/>';
								}
							},
							{
								data : 'name',
								bSortable : false,
							},
							{
								data : 'brand',
								bSortable : false,
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Producto no disponible!</span>';
									}

									return data;

								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#36; ' + data
								}
							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									if (data) {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '" checked="checked">  <div class="slider round"> </div></label>';

									} else {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '">  <div class="slider round"> </div></label>';
									}

									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}
							} ],

					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var msg = (checked) ? 'Desea activar este producto?'
													: 'Desea desactivar este producto?';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : "medium",
														title : "Control de Productos",
														message : msg,
														callback : function(
																confirmed) {
															if (confirmed) {
																var activationUrl = window.contextRoot
																		+ '/manage/products/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Informacion',
																								message : data
																							});
																				});

															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}
													});
										});
					}
				});
	}
	/*
	 * ---------------------------- Validacion para categoria
	 * ----------------------------
	 */
	var $categoryForm = $('#categoryForm');
	if ($categoryForm.length) {
		$categoryForm
				.validate({
					rules : {
						name : {
							required : true,
							minlength : 5
						},
						description : {
							required : true
						}
					},
					messages : {
						name : {
							required : 'Por favor, inserte el nombre de la categoria!',
							minlength : 'Nombre de la categoria indefinida!'
						},
						description : {
							required : 'Por favor, inserte la descripcion de la categoria!'
						}
					},
					errorElement : 'em',
					errorPlacement : function(error, element) {
						error.addClass('help-block');
						error.insertAfter(element);
					}

				});
	}
	/*
	 * ---------------------------- Validacion para categoria
	 * ----------------------------
	 */
});