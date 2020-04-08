/*用户名验证*/   
function checkUser(){
  var Username=document.getElementById("Username").value;
  var reg=/^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;    
    if(reg.test(Username)==false){
	  alert("用户名以字母开头并且至少包含一个大写字母，长度在5~15之间");
    return false;
      }
      return true; 
    }
	
/*密码验证*/    
function checkPwd(){
  var Password =document.getElementById("Password").value;
  var reg=/^[a-zA-Z0-9]{6,10}$/;    
    if(reg.test(Password)==false){
       alert("密码不能含有非法字符，长度在6-10之间");
    return false;
      }
      return true;
    }

    

function checkRepwd(){
  var Password =document.getElementById("Password").value;
  var Repassword =document.getElementById("Repassword").value;
    if(Password!=Repassword){
       alert("两次输入的密码不一致");
    return false;
      }
      return true;
    }

 

/*验证邮箱*/

function checkEmail(){
  var Email =document.getElementById("Email").value;
  var reg=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;    
    if(reg.test(Email)==false){
      alert("Email格式不正确，例如web@sohu.com");
    return false;
      }
      return true;
}



function login3(Username,Password,Email) {
	$.ajax({            //几个参数需要注意一下
		async: false ,
		type: "POST",//方法类型
		dataType: "json",//预期服务器返回的数据类型
		url: "http://116.62.134.189:8080/test/SignUp",//url
		data: JSON.stringify([{"username":Username,"password":Password,"email":Email}]),          
		success:function(data){
			if(data[0].resultcode=="1")
				alert("用户名已存在！");
			else
				{
				document.Sign_up.action="Judge.html"; 
				document.Sign_up.submit();
				}
		},
		error:function(){
			alert("error");
		}
	});
	}	
	
	
    function Judge() 
    { 
		var Username=document.getElementById("Username").value;
		var Password =document.getElementById("Password").value;
		var Email =document.getElementById("Email").value;
		if(checkUser()&&checkPwd()&&checkRepwd()&&checkEmail())
    	login3(Username,Password,Email);
    } 
     
    function Login() 
    { 
		document.Sign_up.action="Login.html"; 
		document.Sign_up.submit(); 
    } 
