// 기본형 ~document.querySelector('.header').style.display = 'none';~
// j쿼리 파일 있을때 같은말 ~$('.header').hide();~

// 객체 안에 있을때는 ;이 아니라 ,를 사용
$(function () {
    $('.main_slider').slick({
        arrows: false,
        autoplay: true,
        //    1000=1s js에서는 단위 안 붙임
        autoplaySpeed: 1000,
        vertical: true,
        dots: true,
    });
    $('.mopen').on('click', function () {
        $('.gnb').toggleClass('on')
        $('.mopen').toggleClass('on')
    })
})