/*登录界面JS脚本程序*/
$(function(){
	$('#old_pwd').blur(checkOldPassword);
	$('#new_pwd').blur(checkNewPassword);
	$('#confirm_pwd').blur(checkConfirmPassword);
	$('#save_info').click(updateAdminInfo);
	
});

function  updateAdminInfo(){
	var adminId=getCookie("adminId");
	var newPwd=$('#new_pwd').val();
	var url="admin/updateinfo.do";
	var data={adminId:adminId,newPwd:newPwd};
	$.post(url,data,function(result){
		if(result.state==0){
			var admin=result.data;
			console.log(admin);
			alert("保存成功");
		}else{
			alert("保存失败");
		}
	});
}
function checkOldPassword(){
	console.log("checkOldPassword");
	var adminId=getCookie("adminId");
	var oldPwd=$('#old_pwd').val();
	var url="admin/checkinfo.do";
	var data={adminId:adminId,oldPwd:oldPwd};
	$.post(url,data,function(result){
		if(result.state==0){
			var admin=result.data;
			console.log(admin);
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
		alert("新密码与原密码不能相同！");
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
