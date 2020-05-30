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
//	case 'Manejo de Productos':
//		$('#manageProduct').addClass('active');
//		break;
//	case 'Shopping Cart':
//		$('#userModel').addClass('active');
//		break;		
	default:
		if (menu == "Home")
			break;
		$('#a_' + menu).addClass('active');
		break;
	}