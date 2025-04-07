jQuery(document).ready(function ($) {
	var $select2 = $('.searchwithselect').select2({
    	containerCssClass: "wrap",
    	placeholder: "-- Select --",
    	tags: true
	});
	
	//	single search script
	var $select2 = $('.singleselect').select2({
    	minimumResultsForSearch: Infinity,
    	placeholder: "-- Select --",
    	tags: true
	});
	
	//	multi select script
	var $select2 = $('.multiselect2').select2({ 	
    	placeholder: "-- Select --",
    	tags: true
	});


});