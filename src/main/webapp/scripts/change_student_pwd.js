/*登录界面JS脚本程序*/
$(function(){
	$('#old_pwd').blur(checkOldPassword);
	$('#new_pwd').blur(checkNewPassword);
	$('#confirm_pwd').blur(checkConfirmPassword);
	$('#save_info').click(updateStudentPwd);	
});

function  updateStudentPwd(){
	var studentId=getCookie("studentId");
	var newPwd=$('#new_pwd').val();
	var url="student/updateinfo.do";
	var data={studentId:studentId,newPwd:newPwd};
	$.post(url,data,function(result){
		if(result.state==0){
			var student=result.data;
			console.log(student);
			alert("保存成功");
		}else{
			alert("保存失败");
		}
	});
}
function checkOldPassword(){
	console.log("checkOldPassword");
	var studentId=getCookie("studentId");
	var oldPwd=$('#old_pwd').val();
	var url="student/checkinfo.do";
	var data={studentId:studentId,oldPwd:oldPwd};
	$.post(url,data,function(result){
		if(result.state==0){
			var student=result.data;
			console.log(student);
		}else{
			alert("原密码不正确！");
		}
	});
	return true;
}
function checkNewPassword(){
	console.log("checkNewPassword");
	var oldPwd=$('#old_pwd').val();
	var newPwd=$('#new_pwd').val();
	var reg=/^\w{3,10}$/;
	if(!reg.test(newPwd)){
		alert("新密码不合规则！");
		return false;
	}
	if(oldPwd==newPwd){
		alert("新密码不能与原密码相同！");
		return false;
	}
	return true;
}
function  checkConfirmPassword(){
	console.log("checkConfirmPassword");
	var newPwd=$('#new_pwd').val();
	var confirmPwd=$('#confirm_pwd').val();
	if(confirmPwd!=newPwd){
		alert("确认密码与新密码不一致！");
		return false;
	}
	return true;
}
