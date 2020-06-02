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
		$('#a_' + menu).addClass('active');
		break;
	}

	// Codigo para consumir json y mostrar en la tabla
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
					// Cantidad de registros a mostrar
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Registros', '5 Registros', '10 Registros',
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
									str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary btn-sm">'+
									'<span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

									// Add al carrito de compras
									str += '<a href="'+window.contextRoot+'/cart/add/'+data+ '/product" class="btn btn-success btn-sm">'+
									'<span class="glyphicon glyphicon-shopping-cart"></span></a>';
									return str;
								}

							} ]
				});
	}
});