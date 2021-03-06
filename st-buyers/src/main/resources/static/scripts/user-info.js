/**
 * Created by Administrator on 2017/6/2.
 */
$(function () {
    $("input[type]").change(function() {
        var $file = $(this);
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        // var $img = $("#preview");
        var $img = $img = $(this).closest(".addImg").find("img");

        if(fileObj && fileObj.files && fileObj.files[0]){
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src',dataURL);
        }else{
            dataURL = $file.val();
            var imgObj = document.getElementById("preview");
// 两个坑:
// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

        }
    });


    var selectArea = new MobileSelectArea();
    selectArea.init({trigger:$('#text_addr'),value:$('#hd_addr').val(),data:'../json/data.json', callback: function (_this, scroller, text, value) {
        $("li.text_addr .right span").text(scroller.toString());
    }});

})