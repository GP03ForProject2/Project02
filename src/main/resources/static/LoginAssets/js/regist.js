function Regist() {
    var username = $("#username").val();
	var password = $("#password").val();
	var age = $("#age").val();
	var job = $("#job").val();
	 var user = {
            username:username,
            password:password,
            age:age,
            job:job,
        }

    $.ajax({
        url:"http://localhost:8090/regist",    //reg是注册接口
        type:'POST',
        dataType:'json',
        contentType:'application/json',
        data:JSON.stringify(user),
        success: function (result) {
            if (result == 1) {
                alert("注册成功");
            }
           window.location.href = "http://localhost:8090/tologin";
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
            alert("注册失败");
        }

    });


}
