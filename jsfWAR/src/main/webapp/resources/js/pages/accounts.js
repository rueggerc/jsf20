// Document Ready Function
$(document).ready(function() {
	'use strict';
//	$('select').selectpicker({
//		style: 'form-control'
//	});
//	$('<style>@media print {.noPrint {display:none;} }</style>').appendTo('head');

	console.log("Account Page Ready");
	
});


function accountSelectedAJAX(data) {
	console.log("accountselectedAJAX");
	switch(data.status) {
		case 'begin':
			break;
		case 'complete':
			break;
		case 'success':
			accountSelected();
			break;
	}
}

function accountSelected() {
	console.log("Account Selected");
}
