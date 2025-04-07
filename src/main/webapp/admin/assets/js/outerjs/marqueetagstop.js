$(document).ready(function() {

	$("marquee").hover(function() {
		this.stop();
	}, function() {
		this.start();
	});
	
	$(".read-more-container").on("click", ".read-more-btn", function() {
		var btn = $(this);
		var text = $(this).siblings(".read-more-text");
		text.toggleClass("read-more read-less");
		btn.text(text.hasClass("read-less") ? "Read More..." : "Read Less...");
	});
});
	
