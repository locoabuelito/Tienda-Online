$(function() {

	// solving the active menu problem
	switch (menu) {

	case 'Inicio':
		$('#inicio').addClass('active');
		break;
	case 'Contactos':
		$('#contactos').addClass('active');
		break;
	case 'Productos':
		$('#listProducts').addClass('active');
		break;
	// case 'Manejo de Productos':
	// $('#manageProduct').addClass('active');
	// break;
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

	// Mostrar todos los productos
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
						"sEmptyTable" : "Ningún dato disponible en esta tabla",
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
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3', '5', '10',
									'Todos' ] ],
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
										return '<span style="color:red">Stock no disponible!</span>';
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
											+ '/product" class="btn btn-primary btn-lg">'
											+ '<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a> &#160;';

									// Add al carrito de compras
									str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class="btn btn-success btn-lg">'
											+ '<span class="glyphicon glyphicon-credit-card"></span></a>';
									return str;
								}

							} ]
				});
	}
});