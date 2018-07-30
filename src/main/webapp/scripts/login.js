/*登录界面JS脚本程序*/

$(function(){
	//var identify= $("#identity").val();
	//var identify=$("#identity option:checked").text();
	//为登录按钮绑定单击事件
	//$('#login').click(loginByRole);
	$('#identity').change(loginByRole);
	//$('#regist_button').click(registByRole);
	$('#identity').change(registByRole);
	$('#count').blur(checkName);
	$('#password').blur(checkPassword);
	$('#regist_username').blur(checkRegistUsername);
	$('#regist_password').blur(checkRegistPassword);
	$('#final_password').blur(checkFinalPassword);
	
});

function  loginByRole(){
	var roleVal=$("#identity option:checked").val();
	  console.log(roleVal);
	if(roleVal=="1"){
		$('#login').click(adminLoginAction);
	}else if(roleVal=="2"){
		$('#login').click(teacherLoginAction);
	}else{
		$('#login').click(studentLoginAction);
	}
	 
}
function  registByRole(){
	var roleVal=$('input:radio:checked').val();
	console.log(roleVal);
	if(roleVal=="1"){
		$('#regist_button').click(adminRegistAction);
	}else if(roleVal=="2"){
		$('#regist_button').click(teacherRegistAction);
	}else{
		$('#regist_button').click(studentRegistAction);
	}
	 
}
//管理员注册按钮的动作
function adminRegistAction(){
	console.log("adminRegistAction");
	var pass=checkRegistUsername()+checkRegistPassword()+checkFinalPassword();
	console.log('pass'+pass);
	if(pass!=3){
		//测试///
		return;
	}
	var url="admin/regist.do";
	var name=$('#regist_username').val();
	var pwd=$('#regist_password').val();
	var confirm=$('#final_password').val();
	//向服务器发送
	var data={name:name,password:pwd,confirm:confirm};
	console.log("url:"+url);
	console.log("data:"+data);
	$.post(url,data,function(result){
		if(result.state==0){
			var admin=result.data;
			console.log(admin);
			$('#count').val(admin.adminName);
			$('#password').focus();
			location.href='login.html';
		}else if(result.state==2){
			$('#warning_1 span').html(result.message).parent().show();
		}else if(result.state==3){
			$('#warning_2 span').html(result.message).parent().show();
		}else{
			alert(result.message);
		}
	});
}
//学生注册按钮的动作
function studentRegistAction(){
	console.log("studentRegistAction");
	var pass=checkRegistUsername()+checkRegistPassword()+checkFinalPassword();
	console.log('pass'+pass);
	if(pass!=3){
		//测试///
		return;
	}
	var url="student/regist.do";
	var name=$('#regist_username').val();
	var pwd=$('#regist_password').val();
	var confirm=$('#final_password').val();
	//向服务器发送
	var data={name:name,password:pwd,confirm:confirm};
	console.log("url:"+url);
	console.log("data:"+data);
	$.post(url,data,function(result){
		if(result.state==0){
			var student=result.data;
			console.log(student);
			$('#count').val(student.studentName);
			$('#password').focus();
			location.href='login.html';
		}else if(result.state==2){
			$('#warning_1 span').html(result.message).parent().show();
		}else if(result.state==3){
			$('#warning_2 span').html(result.message).parent().show();
		}else{
			alert(result.message);
		}
	});
}
//老师注册按钮的动作
function teacherRegistAction(){
	console.log("teacherLoginAction");
	var pass=checkRegistUsername()+checkRegistPassword()+checkFinalPassword();
	console.log('pass'+pass);
	if(pass!=3){
		//测试///
		return;
	}
	var url="teacher/regist.do";
	var name=$('#regist_username').val();
	var pwd=$('#regist_password').val();
	var confirm=$('#final_password').val();
	//向服务器发送
	var data={name:name,password:pwd,confirm:confirm};
	console.log("url:"+url);
	console.log("data:"+data);
	$.post(url,data,function(result){
		if(result.state==0){
			var teacher=result.data;
			console.log(teacher);
			$('#count').val(teacher.teacherName);
			$('#password').focus();
			location.href='login.html';
		}else if(result.state==2){
			$('#warning_1 span').html(result.message).parent().show();
		}else if(result.state==3){
			$('#warning_2 span').html(result.message).parent().show();
		}else{
			alert(result.message);
		}
	});
}

function checkRegistUsername(){
	console.log("checkRegistUsername");
	var name=$('#regist_username').val();
	var reg=/^\w{3,10}$/;
	if(!reg.test(name)){
		$('#warning_1 span').html("不合规则").parent().show();
		return false;
	}
	$('#warning_1').hide();
	return true;
}
function checkRegistPassword(){
	console.log("checkRegistPassword");
	var pwd=$('#regist_password').val();
	var reg=/^\w{3,10}$/;
	if(!reg.test(pwd)){
		$('#warning_2 span').html("不合规则").parent().show();
		return false;
	}
	$('#warning_2').hide();
	return true;
}
function checkFinalPassword(){
	console.log("checkFinalPassword");
	var confirm=$('#final_password').val();
	var pwd=$('#regist_password').val();
	if(confirm!=pwd){
		$('#warning_3 span').html("不一致").parent().show();
		return false;
	}
	$('#warning_3').hide();
	return true;
}

//管理员登录按钮的动作
function adminLoginAction(){
	console.log('login click!');
	//收集用户名和密码数据
	var name=$('#count').val();
	var password=$('#password').val();
	//验证用户名和密码
	var pass=checkName()+checkPassword();
	if(pass!=2){
		return;
	}
	//name,password必须和控制器参数一致
	var paramter={'name':name,'password':password};
	//发送Ajax请求,发送请求用"post",接收响应用"get"
	$.ajax({
		url:'admin/login.do',data:paramter,dataType:'json',type:'POST',
		success:function(result){
			//{state:0,data:,message}
			if(result.state==0){//SUCCESS
				console.log("SUCCESS");
				console.log(result.data);
				var admin=result.data;
				setCookie('adminId',admin.adminId);
				location.href='admin_manage.html';
				return;
			}else if(result.state==2){
				//用户名错误
				$('#count-msg').html(result.message);
				return;
			}else if(result.state==3){
				//密码错误
				$('#password-msg').html(result.message);
				return;
			}
			alert(result.message);
		},
	    error:function(){
	    	alert('Ajax请求失败');
	    }
	});
	
}
//老师登录按钮的动作
function teacherLoginAction(){
	console.log('login click!');
	//收集用户名和密码数据
	var name=$('#count').val();
	var password=$('#password').val();
	//验证用户名和密码
	var pass=checkName()+checkPassword();
	if(pass!=2){
		return;
	}
	//name,password必须和控制器参数一致
	var paramter={'name':name,'password':password};
	//发送Ajax请求,发送请求用"post",接收响应用"get"
	$.ajax({
		url:'teacher/login.do',data:paramter,dataType:'json',type:'POST',
		success:function(result){
			//{state:0,data:,message}
			if(result.state==0){//SUCCESS
				console.log("SUCCESS");
				console.log(result.data);
				var teacher=result.data;
				setCookie('teacherId',teacher.teacherId);
				location.href='teacher_manage.html';
				return;
			}else if(result.state==2){
				//用户名错误
				$('#count-msg').html(result.message);
				return;
			}else if(result.state==3){
				//密码错误
				$('#password-msg').html(result.message);
				return;
			}
			alert(result.message);
		},
	    error:function(){
	    	alert("Ajax请求失败");
	    }
	});
}
//学生登录按钮的动作
function studentLoginAction(){
	console.log('login click!');
	//收集用户名和密码数据
	var name=$('#count').val();
	var password=$('#password').val();
	//验证用户名和密码
	var pass=checkName()+checkPassword();
	if(pass!=2){
		return;
	}
	//name,password必须和控制器参数一致
	var paramter={'name':name,'password':password};
	//发送Ajax请求,发送请求用"post",接收响应用"get"
	$.ajax({
		url:'student/login.do',data:paramter,dataType:'json',type:'POST',
		success:function(result){
			//{state:0,data:,message}
			if(result.state==0){//SUCCESS
				console.log("SUCCESS");
				console.log(result.data);
				var student=result.data;
				setCookie('studentId',student.studentId);
				location.href='student_manage.html';
				return;
			}else if(result.state==2){
				//用户名错误
				$('#count-msg').html(result.message);
				return;
			}else if(result.state==3){
				//密码错误
				$('#password-msg').html(result.message);
				return;
			}
			alert(result.message);
		},
	    error:function(){
	    	alert("Ajax请求失败");
	    }
	});
	
}

function checkName(){
	var name=$('#count').val();
	if(name==null||name==""){
		//提示错误
		$('#count-msg').html("用户名不能空");
		return false;
	}
	var reg=/^\w{3,10}$/;
	if(!reg.test(name)){
		$('#count-msg').html("用户名长度不对");
		return false;
	}
	$('#count-msg').empty();
	return true;
}

function checkPassword(){
	var password=$('#password').val();
	if(password==null||password==""){
		$('#password-msg').html("密码不能空");
		return false;
	}
	var reg=/^\w{3,10}$/;
	if(!reg.test(password)){
		$('#password-msg').html("密码长度不对");
		return false;
	}
	$('#password-msg').empty();
	return true;
}