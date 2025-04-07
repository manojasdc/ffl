

var c = 0;
var root5 = "";
var chart5 = "";

$(document).ready(function() {
	const d = new Date();
	let year = d.getFullYear();
	let nextYear = year + 1;
	Searchchart(year, nextYear);

	//	alert(year)

});

function Searchchart(year) {


	$
		.ajax(
			{
				url: '../admin/getusersinembasychart',
				type: "POST",
				data: { "year": year },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#categorydiv').unblock();
				if (data.status == '1') {

					CreateChart5('chartdiv5', data.data);
					//					alert(data.data)
				} else {
					$.alert({
						title: '',
						content: data.message,
					});
				}
			})

		.fail(function(jqXHR, textStatus) {
			$('#accessdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});


}
window.onload = function() {
	//Reference the DropDownList.
	var ddlYears = document.getElementById("year");

	//Determine the Current Year.
	var currentYear = (new Date()).getFullYear();

	//Loop and add the Year values to DropDownList.
	for (var i = currentYear; i >= 2000; i--) {
		var option = document.createElement("OPTION");
		option.innerHTML = i;
		option.value = i;
		if (i == currentYear) {
			option.selected = true;
		}
		ddlYears.appendChild(option);
	}
};
document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("year").onchange =
		function() {

			var year = document.getElementById("year").value
			Searchchart(year)

		}



	document.getElementById("reset").onclick =
		function() {
			return ResetInput();
		};

});



function CreateChart5(divname, data) {
	//	alert(JSON.stringify(data))
	am5.ready(function() {
		if (c == 0) {
			root5 = am5.Root.new(divname);
			root5._logo.dispose();
			chart5 = root5.container.children.push(am5xy.XYChart.new(root5, {
				panX: true,
				panY: false,
				wheelX: "panX",
				wheelY: "zoomX",
				layout: root5.verticalLayout
			}));
		} else {
			root5.dispose();
			root5 = am5.Root.new(divname);
			root5._logo.dispose();
			chart5 = root5.container.children.push(am5xy.XYChart.new(root5, {
				panX: true,
				panY: false,
				wheelX: "panX",
				wheelY: "zoomX",
				layout: root5.verticalLayout
			}));
		}

		var legend = chart5.children.push(
			am5.Legend.new(root5, {
				centerX: am5.p50,
				x: am5.p50
			})
		);

		// Create axes
		var xRenderer = am5xy.AxisRendererX.new(root5, {
			cellStartLocation: 0.1,
			cellEndLocation: 0.9
		})

		var xAxis = chart5.xAxes.push(am5xy.CategoryAxis.new(root5, {
			categoryField: "month",
			renderer: xRenderer,
			tooltip: am5.Tooltip.new(root5, {})
		}));

		xRenderer.grid.template.setAll({
			location: 1
		})

		xAxis.data.setAll(data);

		var yAxis = chart5.yAxes.push(am5xy.ValueAxis.new(root5, {
			min: 0,
			renderer: am5xy.AxisRendererY.new(root5, {
				strokeOpacity: 0.1
			})
		}));

		chart5.get("colors").set("colors", [
			am5.color(0x33CCFF)
		]);

		// Add series
		// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
		function makeSeries(name, fieldName) {
			var series = chart5.series.push(am5xy.ColumnSeries.new(root5, {
				name: name,
				xAxis: xAxis,
				yAxis: yAxis,
				valueYField: fieldName,
				categoryXField: "month",
			}));

			series.columns.template.setAll({
				tooltipText: "Month: {categoryX}\n{name} Count: {valueY}\nMale: {male}\nFemale: {female}",
				width: am5.percent(50),
				tooltipY: 0,
				strokeOpacity: 0
			});

			series.data.setAll(data);

			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			series.appear();

			series.bullets.push(function() {
				return am5.Bullet.new(root5, {
					locationY: 0,
					sprite: am5.Label.new(root5, {
						text: "{valueY}",
						fill: root5.interfaceColors.get("alternativeText"),
						centerY: 0,
						centerX: am5.p50,
						populateText: true
					})
				});
			});

			legend.data.push(series);
		}

//		makeSeries("male", "male");
//		makeSeries("female", "female");
		makeSeries("total", "total");


		// Make stuff animate on load
		// https://www.amcharts.com/docs/v5/concepts/animations/
		chart5.appear();
		//root2.dispose();	
		c++;
	}); // end 
}


function getyear() {

	$('#screenmasterdiv').block({ message: 'Please wait....' });
	$
		.ajax(
			{
				url: '../admin/getyear',
				type: "POST",
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				//				$('#schooldiv').unblock();
				var selectHtml = "";
				selectHtml = selectHtml + "<option value='-1'>------Select Year--</option>";
				$.each(data.yearList, function(jdIndex, jdData) {
					selectHtml = selectHtml + "<option value='" + jdData.id + "'>" + jdData.year + "</option>";
				});

				$('#year').html(selectHtml);

			})
		.fail(function(jqXHR, textStatus) {
			$('#screenmasterdiv').unblock();
//			$.alert({
//				title: '',
//				content: jqXHR.responseText,
//			});

		});
}




function ResetInput() {
	window.location.reload();
}
