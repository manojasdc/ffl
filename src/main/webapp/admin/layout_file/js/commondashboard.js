
/*function DisplayStudentApproval(statustype) {

	window.location.href = "/AFMS/admin/ApproveStudentDashboard?statustype=" + statustype;

}*/
$(document).ready(function() {
	    
  

	$('input[type=radio][name=apptype]').change(function() {
		var apptype = this.value;

		var jsondata = {
			"apptype": apptype,
		}



		$('#commondashboard').block({ message: 'Please wait....' });
		$.ajax(
			{
				url: '/AFMS/admin/YearWiseDataForChart1',
				type: "POST",
				contentType: 'application/json',
				dataType: 'json',
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',

			})
			.done(
				function(data) {

					if (data.status == '1') {
						var data1 = data.data;
						CraeetChart3("chartdiv", "Year", "TotalStudent", "ApprovedStudent", data1, "Total Seat Allocated to Student", "Total Student Registered", "From Total registration Number of Seat Allocated");
						//	CreateChart("chartdiv", "Year", "value", data1);
						$('#commondashboard').unblock();
					} else {
						$('#commondashboard').unblock();

					}

				})
			.fail(function(jqXHR, textStatus) {
				$('#commondashboard').unblock();
				$.alert({
				title: '',
				content: jqXHR.responseText,
			});
			});


		$('#commondashboard').block({ message: 'Please wait....' });
		$.ajax(
			{
				url: '/AFMS/admin/YearWiseApprovedRejectedChart2',
				type: "POST",
				contentType: 'application/json',
				dataType: 'json',
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',

			})
			.done(
				function(data) {

					if (data.status == '1') {
						var data1 = data.data;
						CreateChart2("chartdiv1", "status", "value", data1);
						$('#commondashboard').unblock();

					} else {
						$('#commondashboard').unblock();

					}

				})
			.fail(function(jqXHR, textStatus) {
				$('#commondashboard').unblock();
				$.alert({
				title: '',
				content: jqXHR.responseText,
			});
			});


		$('#commondashboard').block({ message: 'Please wait....' });
		$.ajax(
			{
				url: '/AFMS/admin/InstituteAndCoursewiseSeatChart3',
				type: "POST",
				contentType: 'application/json',
				dataType: 'json',
				data: JSON
					.stringify(jsondata),
				contentType: 'application/json',

			})
			.done(
				function(data) {

					if (data.status == '1') {
						var data1 = data.data;
						CraeetChart3("chartdiv2", "insname", "totalseat", "allocatedseat", data1, "Alocated Seats", "Total Seats", "Seat Allocated From Total Seats");
						$('#commondashboard').unblock();
					} else {
						$('#commondashboard').unblock();

					}

				})
			.fail(function(jqXHR, textStatus) {
				$('#commondashboard').unblock();
				$.alert({
				title: '',
				content: jqXHR.responseText,
			});
			});

	});



	var apptype = $("input[name='apptype']:checked").val();
	var jsondata = {
		"apptype": apptype
	}
	$('#commondashboard').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '/AFMS/admin/YearWiseDataForChart1',
			type: "POST",
			contentType: 'application/json',
			dataType: 'json',
			data: JSON
				.stringify(jsondata),
			contentType: 'application/json',

		})
		.done(
			function(data) {

				if (data.status == '1') {
					var data1 = data.data;
					CraeetChart3("chartdiv", "Year", "TotalStudent", "ApprovedStudent", data1, "Total Seat Allocated to Student", "Total Student Registered", "From Total registration Number of Seat Allocated");
					//CreateChart("chartdiv", "Year", "value", data1);
					$('#commondashboard').unblock();
				} else {
					$('#commondashboard').unblock();

				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#commondashboard').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});
		});


	$('#commondashboard').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '/AFMS/admin/YearWiseApprovedRejectedChart2',
			type: "POST",
			contentType: 'application/json',
			dataType: 'json',
			data: JSON
				.stringify(jsondata),
			contentType: 'application/json',

		})
		.done(
			function(data) {

				if (data.status == '1') {
					var data1 = data.data;
					CreateChart2("chartdiv1", "status", "value", data1);
					$('#commondashboard').unblock();

				} else {
					$('#commondashboard').unblock();

				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#commondashboard').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});
		});


	$('#commondashboard').block({ message: 'Please wait....' });
	$.ajax(
		{
			url: '/AFMS/admin/InstituteAndCoursewiseSeatChart3',
			type: "POST",
			contentType: 'application/json',
			dataType: 'json',
			data: JSON
				.stringify(jsondata),
			contentType: 'application/json',

		})
		.done(
			function(data) {

				if (data.status == '1') {
					var data1 = data.data;
					CraeetChart3("chartdiv2", "insname", "totalseat", "allocatedseat", data1, "Alocated Seats", "Total Seats", "Seat Allocated From Total Seats");
					$('#commondashboard').unblock();
				} else {
					$('#commondashboard').unblock();

				}

			})
		.fail(function(jqXHR, textStatus) {
			$('#commondashboard').unblock();
			$.alert({
				title: '',
				content: jqXHR.responseText,
			});
		});

});


function CreateChart2(id, xaxis, yaxis, data1) {
	am4core.ready(function() {

		// Themes begin
		am4core.useTheme(am4themes_animated);
		// Themes end

		// Create chart instance
		var chart = am4core.create(id, am4charts.PieChart);

		// Add data
		chart.data = data1;

		// Add and configure Series
		var pieSeries = chart.series.push(new am4charts.PieSeries());
		pieSeries.dataFields.value = yaxis;
		pieSeries.dataFields.category = xaxis;
		pieSeries.innerRadius = am4core.percent(50);
		pieSeries.ticks.template.disabled = true;
		pieSeries.labels.template.disabled = true;

		var rgm = new am4core.RadialGradientModifier();
		rgm.brightnesses.push(-0.8, -0.8, -0.5, 0, - 0.5);
		pieSeries.slices.template.fillModifier = rgm;
		pieSeries.slices.template.strokeModifier = rgm;
		pieSeries.slices.template.strokeOpacity = 0.4;
		pieSeries.slices.template.strokeWidth = 0;

		pieSeries.labels.template.text = "{category}: {value.value}";
		pieSeries.slices.template.tooltipText = "{category}: {value.value}";
		//chart.legend.valueLabels.template.text = "{value.value}";

		/*pieSeries.slices.template.propertyFields.url = "http://localhost:8012/AFMS/admin/ApproveStudent";
		pieSeries.slices.template.urlTarget = "_blank";*/


		chart.logo.visible = false;
		chart.legend = new am4charts.Legend();
		chart.legend.position = "right";

		var currentSlice;
		pieSeries.slices.template.events.on("hit", function(ev) {
			window.location.href = "/AFMS/admin/ApproveStudentDashboard?statustype=" + ev.target.dataItem.properties.category;
		});

		pieSeries.colors.list = [
			am4core.color("#845EC2"),
			am4core.color("#D65DB1"),
			am4core.color("#FF6F91"),
			am4core.color("#FF9671"),
			am4core.color("#FFC75F"),
			am4core.color("#F9F871"),
		];



	}); // end am4core.ready()
}
function CraeetChart3(id, xaxis, yaxis, yaxis1, data1, title1, title2, Title) {
	am4core.ready(function() {

		// Themes begin
		am4core.useTheme(am4themes_animated);

		/*am4core.color("#ff0000");
		am4core.color("#f00");
		am4core.color("rgb(255, 0, 0)");
		am4core.color("rgba(255, 0, 0, 0.5)");
		am4core.color({ r: 255, g: 0, b: 0 });
		am4core.color("red");*/

		// Themes end

		// Create chart instance
		var chart = am4core.create(id, am4charts.XYChart3D);
		chart.logo.visible = false;
		// Add data
		chart.data = data1;

		// Create axes
		var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
		categoryAxis.dataFields.category = xaxis;
		categoryAxis.renderer.grid.template.location = 0;
		categoryAxis.renderer.minGridDistance = 30;

		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
		valueAxis.title.text = Title;
		valueAxis.renderer.labels.template.adapter.add("text", function(text) {
			return text + "%";
		});

		var label = categoryAxis.renderer.labels.template;
		label.wrap = true;
		label.maxWidth = 100;
		// Create series
		var series = chart.series.push(new am4charts.ColumnSeries3D());
		series.dataFields.valueY = yaxis1;
		series.dataFields.categoryX = xaxis;
		series.name = title1;
		series.clustered = false;
		series.columns.template.tooltipText = title1 + ": [bold]{valueY}[/]";
		series.columns.template.fillOpacity = 0.9;


		series.columns.template.stroke = am4core.color("#ffc107"); // red outline
		series.columns.template.fill = am4core.color("#ffc107");



		var series2 = chart.series.push(new am4charts.ColumnSeries3D());
		series2.dataFields.valueY = yaxis;
		series2.dataFields.categoryX = xaxis;
		series2.name = title2
		series2.clustered = false;
		series2.columns.template.tooltipText = title2 + ": [bold]{valueY}[/]";



	});

}