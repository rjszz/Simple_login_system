if(self!=top)
	{
	parent.location.href='Login.html';
	}
function CheckLogin(obj){
	if(obj.username.value=='')
	{
		alert('请输入用户名');
		obj.username.focus();
		return false;
	}
	if(obj.password.value=='')
	{
		alert('请输入登录密码');
		obj.password.focus();
		return false;
	}
	return true;
}	
	
	function login2(Username,Password) {
		$.ajax({            //几个参数需要注意一下
			async: false ,
			type: "POST",//方法类型
			dataType: "json",//预期服务器返回的数据类型
			url: "http://116.62.134.189:8080/test/SignIn",//url
			data: JSON.stringify([{"username":Username,"password":Password}]),          
			success:function(data){
				if(data[0].resultcode=="3")
					alert("用户名不存在！");
				else if(data[0].resultcode=="2")
					alert("密码错误！");
				else
					{
					document.login.action="welcome.html"; 
					document.login.submit();
					}
			},
			error:function(){
				alert("error");
			}
		});
	}	

    function Sign_up(obj) 
    { 
		document.login.action="Sign_up.html"; 
		document.login.submit();
    } 
    

    function welcome(obj) 
    { 
		var Username=document.getElementById("Username").value;
		var Password =document.getElementById("Password").value;
		if(CheckLogin(obj)) 
		login2(Username,Password);

    } 
	
