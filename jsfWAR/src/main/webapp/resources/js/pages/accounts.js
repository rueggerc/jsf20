// Document Ready Function
$(document).ready(function() {
	'use strict';
//	$('select').selectpicker({
//		style: 'form-control'
//	});
//	$('<style>@media print {.noPrint {display:none;} }</style>').appendTo('head');

	setPageState();
	console.log("Account Page Ready");
	
});

// AJAX Functions BEGIN
function accountSelectedAJAX(data) {
	console.log("accountselectedAJAX");
	switch(data.status) {
		case 'begin':
			break;
		case 'complete':
			break;
		case 'success':
			if (checkAJAXResponse()) {
				accountSelected();
			}
			break;
	}
}

function checkAJAXResponse() {
	var ajaxResult = document.getElementById('accountsForm:requestResultState').value;
	if (ajaxResult === "fail") {
		redirectToErrorPage();
		return false;
	}
}
//AJAX Functions END


function setPageState() {
	console.log("Set Page State");
	rueggerllc.foo("captain");
	rueggerllc.bar("oscar");
}

function accountSelected() {
	console.log("Account Selected");
}

