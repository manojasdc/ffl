
$(document).ready(function() {
	getEjournal(1);

});

document.addEventListener('DOMContentLoaded', function() {

	var totalpages = document.getElementById("totalpage").value;

	var data = "";
	var counter = 1;

	for (var i = 0; i < totalpages; i++) {

		data += '<li' 
			+ '><a href="javascript:void(0)"'+ (counter === 1 ? ' class="active"' : '')+' id="page' + counter + '">'
			+ counter + '</a></li>';
		counter++;
	}
	$("#pagination").append(data);
	for (var i = 0; i < totalpages; i++) {

		(function() {
			var idval = i + 1;

			document.getElementById("page" + idval).onclick = function() {

				for (var j = 1; j <= totalpages; j++) {
					$("#page" + j).removeClass("active");
				}

				$(this).addClass("active");
				return LoadPageData(idval);
			};

		})();
	}

});

function getEjournal(page) {
	var jsondata = {
		"currentPage": page,

	}
	$
		.ajax(
			{
				url: '../admin/getEjournal',
				type: "POST",
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#work').unblock();
				if (data.status == '1') {
					$("#ejournalData").empty();
					$("#ejournalData").append(data.journaldata);
//alert(data.journaldata)
					var pageNumber = page;
					// Current page number
					var itemsPerPage = 10; // Items per page
					var totalItems = data.Ejournalcount;

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

function LoadPageData(pageid) {
	getEjournal(pageid)
}






