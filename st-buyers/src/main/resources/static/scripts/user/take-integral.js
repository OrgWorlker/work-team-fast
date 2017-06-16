$(function () {
    var $count = $("#count");
    var $isConfirm = $("#isConfirm");
    var $allCount = getAllCountVal($("#allCount").val());
    var $lastVal = 0;

    /**
     * 点击提交确认提现
     */
    $("#confirm").click(function () {
        if (validate() > 0) {
            console.log($count.val())
        }
    });

    
    /**
     * 修改按钮状态
     * @returns {*}
     */
    function validate() {
        var $count = $("#count").val();
        if ($count <= 100) {
            $("#confirm").val("最低限额100");
            $isConfirm.val(0);
        } else if ($count > $allCount) {
            $isConfirm.val(0);
            $("#confirm").val("超过最大额度");
        }
        return $isConfirm.val();
    }


    $count.focus();
    $("#allTake").click(function () {
        $("#confirm").val("确认");
        $count.val($allCount)
    });

    function getAllCountVal(count) {
        var indexOf = count.indexOf(".");
        if (indexOf > 0) {
            return count.substring(0, indexOf);
        } else {
            return count;
        }
    }

    $count.keydown(function () {
        $lastVal = $count.val();
    });

    $count.keyup(function () {
        $("#confirm").val("确认");
        if ($count.val() * 1 > $allCount * 1) {
            $count.val($allCount);
        }
    });


});