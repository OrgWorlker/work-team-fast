$(function () {
    var currentPage = 1;
    var pageSize = 10;
    var $wrap = $('.list'),
        $box = $('.list-item'),
        html = '<li>\
                <div class="left"><p class="username">梧桐落叶飘霜雪</p><p class="browse">浏览</p><div class="label"><span class="labelButton">男</span><span class="labelButton">全国</span><span class="labelButton">18-24岁</span></div></div>\
            <div class="right"><p>0.20金币</p><button class="operateButton">领取任务</button></div>\
                </li>';
    var initHtml = html.repeat(10);

    dropload = $wrap.dropload({
        // scrollArea : window,
        // 初始化
        initFn: function (me) {
            me.opts.initFnBefore();//必须执行
            $.post("/order/userTaskList", {userId: userId}, function (result) {
                console.log(result)
                $box.html(initHtml);	//这里是加载数据的函数
                me.resetload();
            })
            // setTimeout(function(){ //setTimeout只是让dome效果明显，实际使用可去掉
            //     $box.html(initHtml);	//这里是加载数据的函数
            //     me.resetload();	//每次加载完都需要重置
            //     //me.unbind(); 多次调用可用此方法先解绑
            // },2000)
            me.opts.initFnAfter();//必须执行
        },
        //上滑加载
        loadDownFn: function (me) {
            setTimeout(function () { //setTimeout只是让dome效果明显，实际使用可去掉
                $box.append(html);	//这里是加载数据的函数
                me.resetload();	//每次加载完都需要重置
                //me.unbind(); 多次调用可用此方法先解绑
            }, 1500)

        },
        //下拉刷新
        loadUpFn: function (me) {
            console.log('me', me.$domUp.html())
            setTimeout(function () {
                $box.html(initHtml);	//这里是加载数据的函数
                me.resetload();		//每次加载完都需要重置
            }, 1500)
        }
    });
})