(function($) {

	"use strict";

	// Page loading animation
	$(window).on('load', function() {

		$('#js-preloader').addClass('loaded');

	});


	/*$(window).scroll(function() {
	  var scroll = $(window).scrollTop();
	  var box = $('.background-header-sticky').height();
	  var header = $('header').height();

	  if (scroll >= box - header) {
		$("header").addClass("background-header");
	  } else {
		$("header").removeClass("background-header");
	  }
	})*/

	var width = $(window).width();
	$(window).resize(function() {
		if (width > 767 && $(window).width() < 767) {
			location.reload();
		}
		else if (width < 767 && $(window).width() > 767) {
			location.reload();
		}
	})

	const elem = document.querySelector('.event_box');
	const filtersElem = document.querySelector('.event_filter');
	if (elem) {
		const rdn_events_list = new Isotope(elem, {
			itemSelector: '.event_outer',
			layoutMode: 'masonry'
		});
		if (filtersElem) {
			filtersElem.addEventListener('click', function(event) {
				if (!matchesSelector(event.target, 'a')) {
					return;
				}
				const filterValue = event.target.getAttribute('data-filter');
				rdn_events_list.arrange({
					filter: filterValue
				});
				filtersElem.querySelector('.is_active').classList.remove('is_active');
				event.target.classList.add('is_active');
				event.preventDefault();
			});
		}
	}


	$('.owl-banner').owlCarousel({
		//center: true,
		right: true,
		items: 1,
		loop: true,
		nav: true,
		autoplay: true,
		autoplayTimeout: 3000,
		autoplayHoverPause: true,
		navText: ['<i class="fa fa-angle-left" aria-hidden="true"></i>', '<i class="fa fa-angle-right" aria-hidden="true"></i>'],
		margin: 30,
		responsive: {
			992: {
				items: 1
			},
			1200: {
				items: 1
			}
		}
	});

	$('.owl-testimonials').owlCarousel({
		center: true,
		items: 1,
		loop: true,
		nav: true,
		navText: ['<i class="fa fa-angle-left" aria-hidden="true"></i>', '<i class="fa fa-angle-right" aria-hidden="true"></i>'],
		margin: 30,
		responsive: {
			992: {
				items: 1
			},
			1200: {
				items: 1
			}
		}
	});

	$(document).ready(function() {
		var owl = $('.custom-logo-owl');
		owl.owlCarousel({
			loop: true,
			/*  nav: true,
			  navText: ['<i class="fa fa-angle-left" aria-hidden="true"></i>','<i class="fa fa-angle-right" aria-hidden="true"></i>'],*/
			margin: 40,
			autoplay: true,
			autoplayTimeout: 2000,
			autoplayHoverPause: true,
			responsiveClass: true,
			responsive: {
				0: {
					items: 1,
				},
				500: {
					items: 2,
				},
				600: {
					items: 2,
				},
				1000: {
					items: 3,
				},
				1200: {
					items: 5,
				}
			}
		});
	})

//	$(document).ready(function() {
//		var owl = $('.custom-logo-owl');
//		owl.owlCarousel({
//			loop: true,
//			/*  nav: true,
//			  navText: ['<i class="fa fa-angle-left" aria-hidden="true"></i>','<i class="fa fa-angle-right" aria-hidden="true"></i>'],*/
//			margin: 10,
//			autoplay: true,
//			autoplayTimeout: 2000,
//			autoplayHoverPause: true,
//			responsiveClass: true,
//			responsive: {
//				0: {
//					items: 1,
//				},
//				500: {
//					items: 2,
//				},
//				600: {
//					items: 3,
//				},
//				1000: {
//					items: 5,
//				},
//				1200: {
//					items: 6,
//				}
//			}
//		});
//	})

	/*$('.owl-events').owlCarousel({
		   items:4,
		loop:true,
		margin:10,
		autoplay:true,
		autoplayTimeout:1000,
		autoplayHoverPause:true,
		});
		$('.play').on('click',function(){
		owl.trigger('play.owl.autoplay',[1000])
	})
	$('.stop').on('click',function(){
		owl.trigger('stop.owl.autoplay')
	})*/

	/* $(document).ready(function() {
				 var owl = $('.owl-events');
				 owl.owlCarousel({
				   items: 4,
				   loop: true,
				   margin: 10,
				   autoplay: true,
				   autoplayTimeout: 1000,
				   autoplayHoverPause: true,
				 });
				 $('.play').on('click', function() {
				   owl.trigger('play.owl.autoplay', [1000])
				 })
				 $('.stop').on('click', function() {
				   owl.trigger('stop.owl.autoplay')
				 })
			   })*/

	/*  $(document).ready(function() {
	 $('.owl-events').owlCarousel({
   loop: true,
autoplay: true,
items: 1,
nav: true,
autoplayHoverPause: true,
autoHeight: true,
merge:true,
animateOut: 'slideOutUp',
animateIn: 'slideInUp'
});   
 })*/

	/* $(document).ready(function() {
			  var owl = $('.owl-events');
			  owl.owlCarousel({
				stagePadding: 0,
	margin: 15,
	loop: true,
	dots: false,
	nav: true,
	  animateOut: 'slideOutUp',
  animateIn: 'slideInUp',
	navText: [
	  "<i class='fa fa-angle-up'></i>",
	  "<i class='fa fa-angle-down'></i>"
	],
	items: 2,
			  });
			 
			})*/


	// Menu Dropdown Toggle
	if ($('.menu-trigger').length) {
		$(".menu-trigger").on('click', function() {
			$(this).toggleClass('active');
			$('.header-area .nav').slideToggle(200);
		});
	}


	// Menu elevator animation
	$('.scroll-to-section a[href*=\\#]:not([href=\\#])').on('click', function() {
		if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
			var target = $(this.hash);
			target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
			if (target.length) {
				var width = $(window).width();
				if (width < 767) {
					$('.menu-trigger').removeClass('active');
					$('.header-area .nav').slideUp(200);
				}
				$('html,body').animate({
					scrollTop: (target.offset().top) - 80
				}, 700);
				return false;
			}
		}
	});

	$(document).ready(function() {
		$(document).on("scroll", onScroll);

		//smoothscroll
		$('.scroll-to-section a[href^="#"]').on('click', function(e) {
			e.preventDefault();
			$(document).off("scroll");

			$('.scroll-to-section a').each(function() {
				$(this).removeClass('active');
			})
			$(this).addClass('active');

			var target = this.hash,
				menu = target;
			var target = $(this.hash);
			$('html, body').stop().animate({
				scrollTop: (target.offset().top) - 79
			}, 500, 'swing', function() {
				window.location.hash = target;
				$(document).on("scroll", onScroll);
			});
		});
	});

	function onScroll(event) {
		var scrollPos = $(document).scrollTop();
		$('.nav a').each(function() {
			var currLink = $(this);
			var refElement = $(currLink.attr("href"));
			if (refElement.position().top <= scrollPos && refElement.position().top + refElement.height() > scrollPos) {
				$('.nav ul li a').removeClass("active");
				currLink.addClass("active");
			}
			else {
				currLink.removeClass("active");
			}
		});
	}


	// Page loading animation
	$(window).on('load', function() {
		if ($('.cover').length) {
			$('.cover').parallax({
				imageSrc: $('.cover').data('image'),
				zIndex: '1'
			});
		}

		$("#preloader").animate({
			'opacity': '0'
		}, 600, function() {
			setTimeout(function() {
				$("#preloader").css("visibility", "hidden").fadeOut();
			}, 300);
		});
	});

	const dropdownOpener = $('.main-nav ul.nav .has-sub > a');

	// Open/Close Submenus
	if (dropdownOpener.length) {
		dropdownOpener.each(function() {
			var _this = $(this);

			_this.on('tap click', function(e) {
				var thisItemParent = _this.parent('li'),
					thisItemParentSiblingsWithDrop = thisItemParent.siblings('.has-sub');

				if (thisItemParent.hasClass('has-sub')) {
					var submenu = thisItemParent.find('> ul.sub-menu');

					if (submenu.is(':visible')) {
						submenu.slideUp(450, 'easeInOutQuad');
						thisItemParent.removeClass('is-open-sub');
					} else {
						thisItemParent.addClass('is-open-sub');

						if (thisItemParentSiblingsWithDrop.length === 0) {
							thisItemParent.find('.sub-menu').slideUp(400, 'easeInOutQuad', function() {
								submenu.slideDown(250, 'easeInOutQuad');
							});
						} else {
							thisItemParent.siblings().removeClass('is-open-sub').find('.sub-menu').slideUp(250, 'easeInOutQuad', function() {
								submenu.slideDown(250, 'easeInOutQuad');
							});
						}
					}
				}

				e.preventDefault();
			});
		});
	}
	$(document).ready(function() {
		function scrollTop() {
			if ($(window).scrollTop() > 200) {
				$(".back-to-top").addClass("active");
			} else {
				$(".back-to-top").removeClass("active");
			}
		}
		$(function () {
			scrollTop();
			$(window).on("scroll", scrollTop);
			$(".back-to-top").click(function () {
				$("html, body").animate({
					scrollTop: 0
				}, 1);
				return false;
			});
		});
	});
	

})(window.jQuery);