$(function () {

  //获取验证码
  $("#validationCode").click(function() {
    var phoneNum = $("#phoneNum").val();
    if (checkPhoneNum(phoneNum)) {
      $.get("/shortMessage/" + phoneNum, function (result) {
        if (result == "success") {
          alert("短信发送成功");
        }
      });
    }
  });

  $("#register").click(function(){
    var flag = true;
    $("form ul").find("input:text").each(function(index, contt){
      if (!checkIsNotNull(contt.value)) {
        flag = false;
        $.alert("请补全信息！");
        return;
      }
    });

    var checkLength = /^[a-zA-Z0-9]{6,18}$/;
    var checkQQ = /^[0-9]{4,16}$/;
    var passWordCheck = $("form ul").find("input:password");
    if (!checkIsNotNull(passWordCheck[0].value) || !checkIsNotNull(passWordCheck[1].value)) {
      $.alert("请补全信息！");
      flag = false;
      return;
    } else if (!checkQQ.test($("#qqCodeParam").val())) {
      $.alert("QQ输入有误！");
      flag = false;
      return;
    } else if (!checkLength.test(passWordCheck[0].value) || !checkLength.test(passWordCheck[1].value)) {
      $.alert("密码长度在6到18位，不能满足要求，重新修改！");
      flag = false;
      return;
    } else if (passWordCheck[0].value != passWordCheck[1].value) {
      $.alert("密码和确认密码不一致，重新修改！");
      flag = false;
      return;
    }


    if (flag) {
      $.post("/user/register", $("form").serialize(), function (result) {
        if (result == "success") {
          $.alert("注册成功！");
          location.href = "/login";
        } else {
          $.alert("注册失败！");
        }
      });
    }
  });

  /**
   * 验证字符串是否为空，如果为空则返回false，不为空则返回true
   * @param checkStr
   * @returns {boolean}
   */
  function checkIsNotNull(checkStr) {
    if (null == checkStr || "" == $.trim(checkStr)) {
      return false;
    }
    return true;
  }
});

