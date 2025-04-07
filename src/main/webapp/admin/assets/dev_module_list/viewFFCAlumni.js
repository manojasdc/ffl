
$(document).ready(function() {
	getFFCAlumni(1);



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




function getFFCAlumni(page) {

	var jsondata = {
		"currentPage": page,

	}
	$
		.ajax(
			{
				url: '../admin/getFFCAlumni',
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
					$("#allNData").empty();

					$("#allNData").append(data.notdata);

					var pageNumber = page;
					// Current page number
					var totalItems = data.AlumniCount;

					// Total count of items
					//					var paginationInfo = displayPaginationInfo(pageNumber, itemsPerPage, totalItems);

					//					document.getElementById("paginationInfo").innerHTML = paginationInfo;
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
	getFFCAlumni(pageid)
}






