
var a = 0;
var root3 = "";
var chart3 = "";

var b = 0;
var root4 = "";
var chart4 = "";

var c = 0;
var root5 = "";
var chart5 = "";

$(document).ready(function() {

	$("#hideoninstitute").hide(); // show institute dropdown by default
	$("#hideonyear").hide(); // show year dropdown by default
	$("#hideoncountry").show();
	$("#hideonusers").hide();
	$("#hideyear1").hide();
	$("#registrationchart").hide();
	$("#passoutchart").hide();
	const d = new Date();
	let year = d.getFullYear();
	let nextYear = year + 1;
	Searchchart(year, nextYear);

	$('input[name="year"]').change(function() {
		if ($(this).val() === "registrationyear") {
			$("#hideyear1").show();

		} else {
			$("#hideyear1").hide();
		}
	});

});

function Searchpassoutchart() {
	$.ajax({
		url: '../admin/getpassoutuserschart',
		type: "POST",
		dataType: 'json',
		cors: true
	})
		.done(function(data) {
			console.log("Chart Data Received: ", data);
			$('#categorydiv').unblock();

			if (data.status == '1' && Array.isArray(data.data) && data.data.length > 0) {
				console.log("Passing Data to Chart: ", data.data);
				CreateChart6('chartdiv6', data.data);
			} else {
				$.alert({
					title: '',
					content: data.message || "No data available",
				});
			}
		})
		.fail(function(jqXHR, textStatus) {
			console.error("AJAX Error: ", jqXHR.responseText);
			$('#accessdiv').unblock();
		});
}


function Searchchart(year) {

	$
		.ajax(
			{
				url: '../admin/getalluserschart',
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

	$
		.ajax(
			{
				url: '../admin/getallcountryuserschart',
				type: "POST",
				//				data: { "year": year },
				cors: true,
				dataType: 'json',

			})
		.done(
			function(data) {
				$('#categorydiv').unblock();
				if (data.status == '1') {

					CreateChart4('chartdiv4', data.data);
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
	var ddlYears = document.getElementById("year");

	// Determine the Current Year.
	var currentYear = (new Date()).getFullYear();

	for (var i = currentYear; i >= 2000; i--) {
		var option1 = document.createElement("OPTION");
		option1.innerHTML = i;
		option1.value = i;

		if (i == currentYear) {
			option1.selected = true;
		}
		ddlYears.appendChild(option1);
	}
};

document.addEventListener('DOMContentLoaded', function() {
	document.getElementById("yearradio").onchange =
		$('input[name="year"]').change(function() {
			if ($(this).val() === "registrationyear") {
				$("#registrationchart").show();
				$("#passoutchart").hide();
			} else if ($(this).val() === "passoutyear") {
				$("#passoutchart").show();
				$("#registrationchart").hide();
				Searchpassoutchart();
			}
		});

	document.getElementById("year").onchange = function() {
		var year = document.getElementById("year").value
		Searchchart(year)
	}

	//	document.getElementById("insthide").onclick = function() {
	//		$("#hideoncountry").hide();
	//		$("#hideoninstitute").show();
	//		$("#hideonusers").hide();
	//	};

	document.getElementById("counthide").onclick = function() {
		$("#hideonusers").hide();
		$("#hideoninstitute").hide();
		$("#hideoncountry").show();
	};

	document.getElementById("userhide").onclick = function() {
		$("#hideoncountry").hide();
		$("#hideoninstitute").hide();
		$("#hideonusers").show();
		$("#hideonyear").show();
	};

	document.getElementById("reset").onclick =
		function() {
			return ResetInput();
		};

});
function CreateChart3(divname, data) {

	//	alert(JSON.stringify(data))
	am5.ready(function() {
		if (a == 0) {
			root3 = am5.Root.new(divname);
			root3._logo.dispose();
			chart3 = root3.container.children.push(am5xy.XYChart.new(root3, {
				panX: true,
				panY: false,
				wheelX: "panX",
				wheelY: "zoomX",
				layout: root3.verticalLayout
			}));
		} else {
			root3.dispose();
			root3 = am5.Root.new(divname);
			root3._logo.dispose();
			chart3 = root3.container.children.push(am5xy.XYChart.new(root3, {
				panX: true,
				panY: false,
				wheelX: "panX",
				wheelY: "zoomX",
				layout: root3.verticalLayout
			}));
		}

		var legend = chart3.children.push(
			am5.Legend.new(root3, {
				centerX: am5.p50,
				x: am5.p50
			})
		);

		// Create axes
		var xRenderer = am5xy.AxisRendererX.new(root3, {
			cellStartLocation: 0.1,
			cellEndLocation: 0.9
		})

		var xAxis = chart3.xAxes.push(am5xy.CategoryAxis.new(root3, {
			categoryField: "blogs",
			renderer: xRenderer,
			tooltip: am5.Tooltip.new(root3, {})
		}));

		xRenderer.grid.template.setAll({
			location: 1
		})

		xAxis.data.setAll(data);

		var yAxis = chart3.yAxes.push(am5xy.ValueAxis.new(root3, {
			min: 0,
			renderer: am5xy.AxisRendererY.new(root3, {
				strokeOpacity: 0.1
			})
		}));

		chart3.get("colors").set("colors", [
			am5.color(0x33CCFF)
		]);

		// Add series
		// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
		function makeSeries(name, fieldName) {
			var series = chart3.series.push(am5xy.ColumnSeries.new(root3, {
				name: name,
				xAxis: xAxis,
				yAxis: yAxis,
				valueYField: fieldName,
				categoryXField: "blogs"
			}));

			series.columns.template.setAll({
				tooltipText: "{name}, {categoryX}:{valueY}",
				width: am5.percent(50),
				tooltipY: 0,
				strokeOpacity: 0
			});

			series.data.setAll(data);

			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			series.appear();

			series.bullets.push(function() {
				return am5.Bullet.new(root3, {
					locationY: 0,
					sprite: am5.Label.new(root3, {
						text: "{valueY}",
						fill: root3.interfaceColors.get("alternativeText"),
						centerY: 0,
						centerX: am5.p50,
						populateText: true
					})
				});
			});

			legend.data.push(series);
		}
		makeSeries("blogs", "blogs");
		makeSeries("institute", "institute");
		//		makeSeries("Girls", "girls");
		//		makeSeries("Total Students", "totalstudent");



		// Make stuff animate on load
		// https://www.amcharts.com/docs/v5/concepts/animations/
		chart3.appear();
		//root2.dispose();	
		a++;
	}); // end 
}


function CreateChart4(divname, data) {
	//	alert(JSON.stringify(data))
	am5.ready(function() {
		if (b == 0) {
			root4 = am5.Root.new(divname);
			root4._logo.dispose();
			chart4 = root4.container.children.push(am5xy.XYChart.new(root4, {
				panX: true,
				panY: false,
				wheelX: "panX",
				wheelY: "zoomX",
				layout: root4.verticalLayout
			}));
		} else {
			root4.dispose();
			root4 = am5.Root.new(divname);
			root4._logo.dispose();
			chart4 = root4.container.children.push(am5xy.XYChart.new(root4, {
				panX: true,
				panY: false,
				wheelX: "panX",
				wheelY: "zoomX",
				layout: root4.verticalLayout
			}));
		}

		var legend = chart4.children.push(
			am5.Legend.new(root4, {
				centerX: am5.p50,
				x: am5.p50
			})
		);

		// Create axes
		var xRenderer = am5xy.AxisRendererX.new(root4, {
			cellStartLocation: 0.1,
			cellEndLocation: 0.9
		})

		var xAxis = chart4.xAxes.push(am5xy.CategoryAxis.new(root4, {
			categoryField: "country",
			renderer: xRenderer,
			tooltip: am5.Tooltip.new(root4, {})
		}));

		xRenderer.grid.template.setAll({
			location: 1
		})

		xAxis.data.setAll(data);

		var yAxis = chart4.yAxes.push(am5xy.ValueAxis.new(root4, {
			min: 0,
			renderer: am5xy.AxisRendererY.new(root4, {
				strokeOpacity: 0.1
			})
		}));

		chart4.get("colors").set("colors", [
			am5.color(0x33CCFF)
		]);

		// Add series
		// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
		function makeSeries(name, fieldName) {
			var series = chart4.series.push(am5xy.ColumnSeries.new(root4, {
				name: name,
				xAxis: xAxis,
				yAxis: yAxis,
				valueYField: fieldName,
				categoryXField: "country",
			}));

			series.columns.template.setAll({
				tooltipText: "Country: {categoryX}\n{name} Count: {valueY}\nMale: {male}\nFemale: {female}",
				width: am5.percent(50),
				tooltipY: 0,
				strokeOpacity: 0
			});

			series.data.setAll(data);

			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			series.appear();

			series.bullets.push(function() {
				return am5.Bullet.new(root4, {
					locationY: 0,
					sprite: am5.Label.new(root4, {
						text: "{valueY}",
						fill: root4.interfaceColors.get("alternativeText"),
						centerY: 0,
						centerX: am5.p50,
						populateText: true
					})
				});
			});

			legend.data.push(series);
		}

		//		makeSeries("country", "country");
		//		makeSeries("female", "female");

		makeSeries("total", "total");
		//		makeSeries("Girls", "girls");
		//		makeSeries("Total Students", "totalstudent");



		// Make stuff animate on load
		// https://www.amcharts.com/docs/v5/concepts/animations/
		chart4.appear();
		//root2.dispose();	
		b++;
	}); // end 
}
function CreateChart6(divname, data) {
	am5.ready(function() {
		root6 = am5.Root.new(divname);
		if (c == 0) {

			root6._logo.dispose();
			chart6 = root6.container.children.push(am5xy.XYChart.new(root6, {
				panX: true,
				panY: false,
				wheelX: "panX",
				wheelY: "zoomX",
				layout: root6.verticalLayout
			}));
		} else {
			root6.dispose();
			root6 = am5.Root.new(divname);
			root6._logo.dispose();
			chart6 = root6.container.children.push(am5xy.XYChart.new(root6, {
				panX: true,
				panY: false,
				wheelX: "panX",
				wheelY: "zoomX",
				layout: root6.verticalLayout
			}));
		}

		var legend = chart6.children.push(
			am5.Legend.new(root6, {
				centerX: am5.p50,
				x: am5.p50
			})
		);

		// **Create X-Axis (Years)**
		var xRenderer = am5xy.AxisRendererX.new(root6, {
			cellStartLocation: 0.1,
			cellEndLocation: 0.9
		});

		var xAxis = chart6.xAxes.push(am5xy.CategoryAxis.new(root6, {
			categoryField: "year",  // X-axis is Year
			renderer: xRenderer,
			tooltip: am5.Tooltip.new(root6, {})
		}));

		xAxis.data.setAll(data);

		var yAxis = chart6.yAxes.push(am5xy.ValueAxis.new(root6, {
			min: 0,
			renderer: am5xy.AxisRendererY.new(root6, {
				strokeOpacity: 0.1
			})
		}));

		chart6.get("colors").set("colors", [am5.color(0x33CCFF)]);

		// **Create the Series for Total Count**
		function makeSeries(name, fieldName) {
			var series = chart6.series.push(am5xy.ColumnSeries.new(root6, {
				name: name,
				xAxis: xAxis,
				yAxis: yAxis,
				valueYField: fieldName,  // ? Maps Y-Axis to "total"
				categoryXField: "year",  // ? Maps X-Axis to "year"
			}));

			series.columns.template.setAll({
				tooltipText: "{categoryX}: {valueY}",
				width: am5.percent(50),
				tooltipY: 0,
				strokeOpacity: 0
			});

			series.data.setAll(data);
			series.appear();

			series.bullets.push(function() {
				return am5.Bullet.new(root6, {
					locationY: 0,
					sprite: am5.Label.new(root6, {
						text: "{valueY}",
						fill: root6.interfaceColors.get("alternativeText"),
						centerY: 0,
						centerX: am5.p50,
						populateText: true
					})
				});
			});

			legend.data.push(series);
		}

		// Call the function with correct field name
		makeSeries("total", "total");

		chart6.appear();
		c++;
	});
}


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


//window.onload = function() {
//	//Reference the DropDownList.
//	var ddlYears = document.getElementById("created_date");
//
//	//Determine the Current Year.
//	var currentYear = (new Date()).getFullYear();
//
//	//Loop and add the Year values to DropDownList.
//	for (var i = currentYear; i >= 2000; i--) {
//		var option = document.createElement("OPTION");
//		option.innerHTML = i + "-" + (i + 1);
//		option.value = i + "-" + (i + 1);
//		ddlYears.appendChild(option);
//	}
//};


function ResetInput() {
	window.location.reload();
}
