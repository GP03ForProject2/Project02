function fnRegist() {
    var oUname = document.getElementById("form-name");
    var oUpass = document.getElementById("form-Password");
    var oPhone = document.getElementById("form-Phone");

    var oPass = document.getElementById("form-Password").value;
    var oPass1 = document.getElementById("form-Password2").value;

    var oError = document.getElementById("error_box");
    var isError = true;
    if (oPass != oPass1) {
        document.getElementById("error_box").innerHTML = "两次密码输入不一致";
    }

    if (oUname.value.length > 20 || oUname.value.length < 6) {
        oError.innerHTML = "用户名请输入6-20位字符";
        isError = false;
        return;
    }else if((oUname.value.charCodeAt(0)>=48) && (oUname.value.charCodeAt(0)<=57)){
        oError.innerHTML = "首字符必须为字母";
        return;
    }else for(var i=0;i<oUname.value.charCodeAt(i);i++){
        if((oUname.value.charCodeAt(i)<48)||(oUname.value.charCodeAt(i)>57) && (oUname.value.charCodeAt(i)<97)||(oUname.value.charCodeAt(i)>122)){
            oError.innerHTML = "必须为字母跟数字组成";
            return;
        }
    }

    if (oUpass.value.length > 20 || oUpass.value.length < 6) {
        oError.innerHTML = "密码请输入6-20位字符";
        isError = false;
        return;
    }

    for(var i=0;i<oPhone.value.charCodeAt(i);i++){
        if ((oPhone.value.length === 11) && (oPhone.value.charCodeAt(i)<97)||(oPhone.value.charCodeAt(i)>122)) {
            oError.innerHTML = "密码请输入6-20位字符";
            isError = false;
            return;
        }
    }
    window.alert("注册成功")
}


// 以下JS代码引用JQuery库，使用JQuery语法
let $form = $('#formSignUp');
let hash = {}; // 声明一个空对象
$form.on('submit', (e)=>{ // 监听submit事件
    e.preventDefault();  // 取消默认事件
    $form.find('.error').each((index, error)=>{ // 清空所有具有error属性的span标签的文本内容
        $(error).text('')
    });
    let list = ['email'];
    list.forEach((name)=>{ // 遍历list数组
        let value = $form.find(`[name="${name}"]`).val(); // 取得用户所输入的内容
        hash[name] = value // 将用户输入的内容存入空对象中，如： {email: '374xxxxxx@qq.com'}
    });
    if(hash.email === ''){ // 判断用户是否有输入
        $form.find('#email').siblings('.error').text('请输入邮箱'); // 如果用户每天输入信息，则在span标签中写入'请输入邮箱'
        return
    }
    // 使用JQuery中AJAX的API，以下是Ajax函数的简写形式
    $.post('/sign_up', hash); //使用HTTP POST请求，请求路径'/sign_up'，并发送给服务器一个对象
    then((response)=>{ // 请求成功
        alert('注册成功');
        window.location.href = '/sign_in' // 跳转到新的路径
    },(request)=>{ // 请求失败
        let {errors} = request.responseJSON; // 使用ES6语法解析赋值，取得服务器返回的内容
        if(errors.email && errors.email === 'invalid'){ // 判断服务器返回的内容
            $form.find('#email').siblings('.error').text('邮箱格式错误')
        }else if(errors.email && errors.email === 'used'){
            $form.find('#email').siblings('.error').text('该邮箱已被使用')
        }
    })
});