
$(document).ready(function() {
	getwhatsnewscroll();



});


document.addEventListener('DOMContentLoaded', function() {




});




function getwhatsnewscroll() {
	

	
	$
		.ajax(
			{
				url: '../admin/getwhatsnewscroll',
				type: "POST",
//				data: JSON
//					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#work').unblock();
				if (data.status == '1') {
					$("#allwhatsnew").empty();

					$("#allwhatsnew").append(data.notdata);
					

				} else {
					$.alert({
						title: '',
						content: data.message,
					});
				}
			})
		.fail(function(jqXHR, textStatus) {
			$('#work').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
		});



}













