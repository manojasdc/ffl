

$(document).ready(function() {
	mockjax1('dashboardtbl');
	dt = dataTable('dashboardtbl');


getRoData();
//SearchSchoolData();
//	GETNEWSCHOOLNAME1();
//	



//
//
//function SearchSchoolData(id) {
//	console.log(id);
//
//		$.ajax(
//		{
//			url: '/FriendsForLife/admin/loadSchoolwiseStudent?schoolid=' + id?
//			type: "POST",
//			contentType: 'application/json',
//			dataType: 'json',
//
//		})
//		.done(
//			function(data) {
//
//				if (data.status == '1') {
//					var length = Object.keys(data.data).length;
//					for (var i = 0; i < length; i++) {
//						var statusData = data.data[i];
//						jsondata.push([
//							statusData.srno,
//							statusData.school_name,
//							statusData.class_name,
//							statusData.total_boys,
//							statusData.total_girls,
//							statusData.total_students
//
//						]);
//						FilteredRecords = data.TotalCount;
//					}
//					$('#classdiv').unblock();
//					
////					htm="<th>Total</th>";
//////					htm="<th></th>";
//////					htm="<th></th>";
////					htm+=`<th>${data.total_boys_sum}</th>`;
////					htm+=`<th>${data.total_girls_sum}</th>`;
////					htm+=`<th>${data.total_students_sum}</th>`;
//////					htm="<th></th>";
////
////					$('#Hello').append(htm);
//						//setTimeout(setevents, 1000);
//
//				} else {
//					$('#classdiv').unblock();
//					alert(data.message);
//				}
//			})
//		.fail(function(jqXHR, textStatus) {
//			$('#classdiv').unblock();
//			alert(jqXHR.responseText);
//		});
//}
//
//		
//	
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//	

	

});

document.addEventListener('DOMContentLoaded', function() {

document.getElementById("roName").onchange =
		function() {

			var id = $('#roName').val();

		 getNewSchoolName(id);
			

		};


//document.getElementById("schoolName").onchange =
//		function() {
//
//			var id = $('#schoolName').val();
//
//		 getNewSchoolName(id);
//			
//
//		};




	document.getElementById("reset").onclick =
		function() {
			return ResetInput();
		};

////		document.getElementById("schoolName").onchange =
////		function() {
////			
////			var sid = $('#schoolName').val();
//////				document.getElementById("title1").innerHTML = "Class Wise Boys & Girls",
//////			document.getElementById("title2").innerHTML = "School Wise Male & Female Teaches",
//////			document.getElementById("title3").innerHTML = "School Wise Types of Staff",
//////			document.getElementById("title4").innerHTML = "Class Wise Result in (%)",
//////			document.getElementById("title5").innerHTML = "School Wise Income and Expenditure",
//////
//////			SearchSchoolData(sid);//id,,sectionid();
////		
////		//	chart.destroy();
////
////		};
////		
//		

});





function getRoData() {
	$('#accessdiv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '../admin/getRoData',
				type: "POST",
				
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#accessdiv').unblock();
				
				var selectHtml = "";

				selectHtml = selectHtml + "<option value='-1'>--Select RO--</option>";
				$.each(data.RoList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.RoName + "</option>";

				});
				$('#roName').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#accessdiv').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});

		});


}


function getNewSchoolName(id) {


	$('#rolediv').block({ message: 'Please wait....' });

	$
		.ajax(
			{
				url: '/FriendsForLife/admin/getNewSchoolName',
				type: "POST",
				data: { "id": id },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#rolediv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>--- Select School ---</option>";
				$.each(data.rolelist, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
				});
				$('#schoolName').html(selectHtml);
				//				jQuery('#coursenamedrp').multiselect({
				//					columns: 1,
				//					placeholder: 'Select Course Name',
				//					data: selectHtml
				//				});
			})
		.fail(function(jqXHR, textStatus) {
			$('#rolediv').unblock();
			alert(jqXHR.responseText);

		});

}






function ResetInput() {
	window.location.reload();
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//function getRoData1() {
//	$('#accessdiv').block({ message: 'Please wait....' });
//
//	$
//		.ajax(
//			{
//				url: '/FriendsForLife/admin/getRoData1',
//				type: "POST",
//				
//				cors: true,
//				dataType: 'json',
//
//			})
//		.done(
//			function(data) {
//				$('#accessdiv').unblock();
//				
//				var selectHtml = "";
//
//				selectHtml = selectHtml + "<option value='-1'>--Select RO--</option>";
//				$.each(data.RoList, function(jdIndex, jdData) {
//					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.RoName + "</option>";
//
//				});
//				$('#roName').html(selectHtml);
//
//			})
//		.fail(function(jqXHR, textStatus) {
//			$('#accessdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});
//
//		});
//
//
//}
//

//function getNewSchoolName1(id) {
//
//
//	$('#rolediv').block({ message: 'Please wait....' });
////alert(9);
//	$
//		.ajax(
//			{
//				url: '/FriendsForLife/admin/getNewSchoolName1',
//				type: "POST",
//				data: { "id": id },
//				cors: true,
//				dataType: 'json',
//
//			})
//		.done(
//			function(data) {
//				$('#rolediv').unblock();
//				var selectHtml = "";
//				selectHtml = selectHtml + "<option value='-1'>--- Select School ---</option>";
//				$.each(data.rolelist, function(jdIndex, jdData) {
//					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.name + "</option>";
//				});
//				$('#schoolName').html(selectHtml);
//				//				jQuery('#coursenamedrp').multiselect({
//				//					columns: 1,
//				//					placeholder: 'Select Course Name',
//				//					data: selectHtml
//				//				});
//			})
//		.fail(function(jqXHR, textStatus) {
//			$('#rolediv').unblock();
//			alert(jqXHR.responseText);
//
//		});
//
//}

	






function dataTable(tableName) {
	var table = $('#dashboarddiv' + tableName).DataTable({
		"order": [[0, "asc"]],
		//		"lengthMenu": [[10, 25, 50, 100, 200, -1], [10, 25, 50, 100, 200, "All"]],
	"lengthMenu": [[-1], ["All"]],
		"scrollY": "400px",
		"scrollX": true,
		"scrollCollapse": true,
		"sPaginationType": "full_numbers",
		"bDestroy": true,
		"bLengthChange": true,
		'language': {
			'loadingRecords': '&nbsp;',
			'processing': '<div class="spinner"></div>'
		},
		ajax: '/test1',
		'processing': true,
		"serverSide": true
	});
	return table;
}








window.onload = function () {
            //Reference the DropDownList.
            var ddlYears = document.getElementById("academicyear");

            //Determine the Current Year.
            var currentYear = (new Date()).getFullYear();

            //Loop and add the Year values to DropDownList.
            for (var i = currentYear; i >= 2022; i--) {
                var option = document.createElement("OPTION");
                option.innerHTML = i+"-"+(i+1);
                option.value = i+"-"+(i+1);
                ddlYears.appendChild(option);
            }
        };




function ResetInput() {
	window.location.reload();
}

