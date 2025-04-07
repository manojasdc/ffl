
$(document)
			.ready(
					function() {

						if (window.location.href.includes("?")) {
							var urlWithQueryString = window.location.href;
							var urlWithoutQueryString = urlWithQueryString
									.split("?")[0];
							window.history.pushState({}, document.title,
									urlWithoutQueryString);
							sessionStorage.setItem("urlWithQueryString",
									urlWithQueryString);
							sessionStorage.setItem("urlWithoutQueryString",
									urlWithoutQueryString);
							sessionStorage.setItem("flag",
									"trueflag");
						} else {
							var storedUrlWithQueryString = sessionStorage
									.getItem("urlWithQueryString");
							var storedUrlWithoutQueryString = sessionStorage
									.getItem("urlWithoutQueryString");
							if (storedUrlWithQueryString
									&& storedUrlWithoutQueryString) {
								if (storedUrlWithoutQueryString == window.location.href) {
									window.location.href = storedUrlWithQueryString;
								}
							}
							sessionStorage.setItem("urlWithQueryString",
									"");
							sessionStorage.setItem("urlWithoutQueryString",
									"");
						}
						
						if (sessionStorage.getItem("flag")=="trueflag"){
							sessionStorage.setItem("urlWithQueryString",
							"");
					sessionStorage.setItem("urlWithoutQueryString",
							"");
					sessionStorage.setItem("flag",
					"");
						}
						
					});
//$(document).ready(function() {
//	
//   
//	//	if (window.location.href.includes("?")) {
//	//		var url = window.location.href.split("?")[0];
//	//		window.history.pushState({}, document.title, url);
//	//
//	//	}
//	//	if (window.location.href.includes("//")) {
//	//		var url = window.location.href.split("//")[2];
//	//		if (url != undefined) {
//	//
//	//		}
//	//
//	//	}
//
//
//
//	if (window.location.href.includes("?")) {
//		var urlWithQueryString = window.location.href;
//		var urlWithoutQueryString = urlWithQueryString.split("?")[0];
//		window.history.pushState({}, document.title, urlWithoutQueryString);
//		sessionStorage.setItem("urlWithQueryString", urlWithQueryString);
//		sessionStorage.setItem("urlWithoutQueryString", urlWithoutQueryString);
//	} else {
//		var storedUrlWithQueryString = sessionStorage.getItem("urlWithQueryString");
//		var storedUrlWithoutQueryString = sessionStorage.getItem("urlWithoutQueryString");
//		if (storedUrlWithQueryString && storedUrlWithoutQueryString) {
//			if (storedUrlWithoutQueryString == window.location.href) {
//				window.location.href = storedUrlWithQueryString;
//			}
//		}
//	}
//	
//	
//	
//
//});





//function _base64ToArrayBuffer(base64) {
//	var binary_string = window.atob(base64);
//	var len = binary_string.length;
//
//
//	var bytes = new Uint8Array(len);
//	for (var i = 0; i < len; i++) {
//		bytes[i] = binary_string.charCodeAt(i);
//	}
//	return bytes;
//}
//

//function GeneratePDF1(base64Data) {
//
//
//	var file = new Blob(
//		[_base64ToArrayBuffer(base64Data)],
//		{ type: 'application/pdf' }
//	);
//	var fileURL = URL.createObjectURL(file);
//	var newWindow = window.open(fileURL, '_blank');
//
//	newWindow.onload = function() {
//		const embedTag = newWindow.document.getElementsByTagName('embed')[0]; // or document.querySelector('embed');
//		embedTag.style.position = 'absolute';
//	};
//
//
//}
document.addEventListener('DOMContentLoaded', function() {
//	//School
//	document.getElementById("bestInAcaSchool").onclick =
//		function() {
//			return GetPDFForDisplay("Best in Academics,School");
//		};
//	document.getElementById("bestInSportsSchool").onclick =
//		function() {
//			return GetPDFForDisplay("Best in Sports,School");
//		};
//	document.getElementById("overAllBestSchool").onclick =
//		function() {
//			return GetPDFForDisplay("Overall Best");
//		};
//	document.getElementById("otherAward").onclick =
//		function() {
//			return GetPDFForDisplay("Any Other Awards");
//		};
//
//	//Student		
//	document.getElementById("bestInAcaStudent").onclick =
//		function() {
//			return GetPDFForDisplay("Best in Academics,Student");
//		};
//
//	document.getElementById("bestInSportsStud").onclick =
//		function() {
//			return GetPDFForDisplay("Best in Sports,Student");
//		};
//	document.getElementById("bestInCompetitiveExams").onclick =
//		function() {
//			return GetPDFForDisplay("Best In Competitive Exam");
//		};
//	document.getElementById("bestInCoScholastic").onclick =
//		function() {
//			return GetPDFForDisplay("Best in Co-scholastic");
//		};
//	//staff
//	document.getElementById("bestTeacher").onclick =
//		function() {
//			return GetPDFForDisplay("Best Teacher");
//		};
//
//	document.getElementById("bestAdmin").onclick =
//		function() {
//			return GetPDFForDisplay("Best Admin");
//		};
//	//MISC
//	document.getElementById("gpais_id").onclick =
//		function() {
//			return GetPDFForDisplay("GPAIS");
//		};
//
//	document.getElementById("books_id").onclick =
//		function() {
//			return GetPDFForDisplay("Books");
//		};
//	document.getElementById("uniform_id").onclick =
//		function() {
//			return GetPDFForDisplay("Uniform");
//		};
//	//Publication		
//	document.getElementById("annualReports").onclick =
//		function() {
//			return GetPDFForDisplay("Annual Reports");
//		};
//
//	document.getElementById("yearlyPerformanceReview").onclick =
//		function() {
//			return GetPDFForDisplay("Yearly Performance Review");
//		};
//	document.getElementById("magazinesId").onclick =
//		function() {
//			return GetPDFForDisplay("Magazines");
//		};
//	document.getElementById("activityReports").onclick =
//		function() {
//			return GetPDFForDisplay("Activity Reports");
//		};
//	document.getElementById("calendar_id").onclick =
//		function() {
//			return GetPDFForDisplay("Calendar");
//		};
});


function _base64ToArrayBuffer(base64) {
	var binary_string = window.atob(base64);
	var len = binary_string.length;


	var bytes = new Uint8Array(len);
	for (var i = 0; i < len; i++) {
		bytes[i] = binary_string.charCodeAt(i);
	}
	return bytes;
}

function GeneratePDF(base64data) {
	var file = new Blob(
		[_base64ToArrayBuffer(base64data)],
		{ type: 'application/pdf' }
	);
	var fileURL = URL.createObjectURL(file);
	var newWindow = window.open(fileURL, '_blank');
	newWindow.onload = function() {
		const embedTag = newWindow.document.getElementsByTagName('embed')[0]; // or document.querySelector('embed');
		embedTag.style.position = 'absolute';
	};

}



function setevents_header() {



	document.querySelectorAll('.document_status').forEach((items, index) => {
		items.addEventListener('click', event => {
			var val = parseInt(index) + 1;
			var hida = document.getElementById('hida' + val).value;
			GetDocumentForMou(hida);
		});
	});


}