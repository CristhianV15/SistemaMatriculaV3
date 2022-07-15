function redireccion(text){
	window.document.location.href= text;
}

function confirmarAccion(url,text){
	if(!text) var text='DESEA EJECUTAR ESTA ACCION';
	if(!url) var url='#';
	var valor = confirm(text);
	if(valor===true){
		redireccion(url);
	}
	return false;
}
