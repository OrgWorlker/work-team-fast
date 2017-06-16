$(function () {
    var selectArea = new MobileSelectArea();
    selectArea.init({trigger:$('#text_area'),value:$('#hd_area').val(),data:'/static/json/data.json'});
    var selectAge = new MobileSelectArea();
    selectAge.init({level: 1,trigger:$('#text_age'),value:$('#hd_age').val(),data:'/static/json/bank.json'});

});