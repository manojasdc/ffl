
  $('.SliderLN').slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        arrows: true,
        adaptiveHeight: true,
        infinite: true,
        autoplay: true,
        vertical: true,
        verticalSwiping: true,
        prevArrow: $('#ltNews-prev'),
        nextArrow: $('#ltNews-next')
    });
    $('#ltNews_Toggle_btn').click(function () {
        if ($(this).html() == '<i class="fa fa-pause-circle"></i>') {
            $('.SliderLN').slick('slickPause');
            $(this).html('<i class="fa fa-play-circle"></i>');
//           $('.SliderLN .slick-list').css({ "overflow-y": "auto", "padding-right": '20px' });
        } else {
            $('.SliderLN').slick('slickPlay');
            $(this).html('<i class="fa fa-pause-circle"></i>');
//           $('.SliderLN .slick-list').css({ "overflow-y": "hidden", "padding-right": "0px" });
        }
    });
    
//     $('.SliderOpAch').slick({
//        slidesToShow: 3,
//        slidesToScroll: 1,
//        arrows: true,
//        adaptiveHeight: true,
//        infinite: true,
//        autoplay: true,
//        vertical: true,
//        verticalSwiping: true,
//        prevArrow: $('#OpAchNews-prev'),
//        nextArrow: $('#OpAchNews-next')
//    });
//    $('#OpAchNews_Toggle_btn').click(function () {
//        if ($(this).html() == '<i class="fa fa-pause-circle"></i>') {
//            $('.SliderOpAch').slick('slickPause');
//            $(this).html('<i class="fa fa-play-circle"></i>');
//            $('.SliderOpAch .slick-list').css({ "overflow-y": "auto", "padding-right": '20px' });
//        } else {
//            $('.SliderOpAch').slick('slickPlay');
//            $(this).html('<i class="fa fa-pause-circle"></i>');
//            $('.SliderOpAch .slick-list').css({ "overflow-y": "hidden", "padding-right": "0px" });
//        }
//    });

$('#pg-slider').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: true,
        adaptiveHeight: true,
        infinite: true,
        autoplay: true,
        prevArrow: $('#pg_slider_Pre'),
        nextArrow: $('#pg_slider_Nxt')
    });
    
     $('#pg_slider_Toggle_btn').click(function () {
        if ($(this).html() == '<i class="fa fa-pause-circle"></i>') {
            $('#pg-slider').slick('slickPause');
            $(this).html('<i class="fa fa-play-circle"></i>');
//           $('.SliderLN .slick-list').css({ "overflow-y": "auto", "padding-right": '20px' });
        } else {
            $('#pg-slider').slick('slickPlay');
            $(this).html('<i class="fa fa-pause-circle"></i>');
//           $('.SliderLN .slick-list').css({ "overflow-y": "hidden", "padding-right": "0px" });
        }
    });
    
    