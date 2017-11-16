// Document Ready Function
$(document).ready(function() {
	'use strict';
	$('select').selectpicker({
		style: 'form-control'
	});
	$('<style>@media print {.noPrint {display:none;} }</style>').appendTo('head');
	
//	 PieChart
	setZeroPieChart();
	
	
	
//	$('.chart').easyPieChart({
//		scaleColor: false,
//		barColor: 'green',
//		trackColor: '#e5e5e5',
//		size: 110,
//		onStep: function(from, to, percent) {
//			$(this.el).find('.percent').text(Math.round(percent));
//		}
//	});
	 
	 // alert("OK");
	

//	$('.chart').easyPieChart({
//	    animate: 2000,
//	    scaleColor: false,
//	    lineWidth: 3,
//	    lineCap: 'square',
//	    size: chartSize,
//	    trackColor: '#e5e5e5',
//	    barColor: '#3da0ea'    
//	});	
	
	
//	$('.chart').easyPieChart({
//	    animate: 2000,
//	    scaleColor: false,
//	    lineWidth: 10,
//	    lineCap: 'square',
//	    size: 100,
//	    trackColor: '#e5e5e5',
//	    barColor: '#0000FF'
//			    	
//	});
	
	
		
	alert("Page1 Loaded");
	
	// Callbacks
	$('.action-link-show-pie-chart').click(showPieChart);
	$('.action-link-hide-pie-chart').click(hidePieChart);
	
	$('.myPercent').blur(percentBlur);
	// $('.myPercent').change(drawPieChartOnChange);
	
	$('.currency').keydown(function (e) {
		checkCurrency($(this).val(), e);
	});
	$('.currency').blur(amountBlur);
	
	
});

function amountBlur() {
	var foo = $(this).val();
	var bar = "later";
}


function setZeroPieChart() {
	$('.chart').data('easy-pie-chart', null);
	$('.chart').easyPieChart({
		scaleColor: false,
		barColor: '#e5e5e5',
		trackColor: '#e5e5e5',
		size: 110,
		onStep: function(from, to, percent) {
			$(this.el).find('.percent').text(Math.round(percent));
		}
	});
}

function setPieChart() {
	$('.chart').data('easy-pie-chart', null);
	$('.chart').easyPieChart({
		scaleColor: false,
		barColor: 'green',
		trackColor: '#e5e5e5',
		size: 110,
		onStep: function(from, to, percent) {
			$(this.el).find('.percent').text(Math.round(percent));
		}
	});
}





// Account Selected
function accountSelected(data) {
	switch (data.status) {
		case 'begin':
			break;
		case 'complete':
			break;
		case 'success':
			break;
	
	}
}

function accountSelectValueChange(data) {
	switch(data.status) {
		case 'begin':
			break;
		case 'complete':
			break;
		case 'success':
			break;
	}
}


function showPieChart() {
	$('.pie-chart-section').show();
}
function hidePieChart() {
	$('.pie-chart-section').hide();
}

function percentBlur() {
	var theValue = $(this).val();
	if (theValue == 0) {
		setZeroPieChart();
		$('.chart').data('easyPieChart').update(theValue);
	} else {
		setPieChart();
		$('.chart').data('easyPieChart').update(theValue);
	}
	
}



function checkAjaxResponse() {
	var ajaxResult = document.getElementById('formID:requestResultState').value;
	if (ajaxResult === "fail") {
		redirectToErrorPage();
		return false;
	}
	return true;
}




