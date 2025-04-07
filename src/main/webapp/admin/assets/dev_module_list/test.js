

$(document).ready(function() {

	var a = '<li><a class="is_active" href="#!" data-filter="*">Show All</a></li><li><a href="#!" data-filter=".wac">WAC</a></li>';
	a = a + '<li><a href="#!" data-filter=".sac">SAC</a></li><li><a href="#!" data-filter=".eac">EAC</a></li>';
	a = a + '<li><a href="#!" data-filter=".swac">SWAC</a></li><li><a href="#!" data-filter=".cac">CAC</a></li>';
	a = a + '<li><a href="#!" data-filter=".mc">MC</a></li><li><a href="#!" data-filter=".tc">TC</a></li>';

	$('#event1').html(a);

	var b = '<div class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer wac"> <div class="events_item"><div class="thumb"> <a href="#"><img';
	b = b + 'src="admin/assets/images/outerimages/gallery-img1.jpg" alt="" title=""></a><span class="category">Event Type</span>  <span class="price"><h6>';
	b = b + 'WAC</h6> </span> </div><div class="down-content"><span class="author">Event Place</span> <h4>Event Name</h4> </div> </div></div>';



	$('#event2').html(b);


});


