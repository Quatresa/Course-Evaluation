/*登录界面JS脚本程序*/

$(function(){	
	$('#save_info').click(updateStudentInfo);
	var studentId=getCookie("studentId");
	var url="student/lookinfo.do";
	var data={studentId:studentId};
	$.post(url,data,function(result){
		if(result.state==0){
			var student=result.data;
			$('#studentNo').val(student.studentNo);
			$('#studentRealName').val(student.studentRealName);
			if(student.studentSex=="男"){
				$("input[name='sex'][value='男']").attr("checked",true);
			}else{
				$("input[name='sex'][value='女']").attr("checked",true);
			}
			$('#studentMajor').val(student.studentMajor);
			$('#studentTell').val(student.studentTell);
			var date1=new Date(student.studentBirth);
			$('#studentBirth').val(date1.toLocaleString());
			return true;
		}else{
			return false;
		}
	});
	
});

Date.prototype.toLocaleString=function(){
	return this.getFullYear()+"-"+(this.getMonth()+1)+"-"+this.getDate();
}

function  updateStudentInfo(){
	var studentId=getCookie("studentId");
	var studentNo=$('#studentNo').val();
	var studentRealName=$('#studentRealName').val();
	var studentSex=$('input:radio:checked').val();
	var studentMajor=$('#studentMajor').val();
	var studentTell=$('#studentTell').val();
	var studentBirth=$('#studentBirth').val();  
	var reg1=/^(\+86)?\s*\d{11}$/;
	var reg2=/^\d{4}-\d{2}-\d{2}$/;
	if(!reg1.test(studentTell)){
		alert("联系方式格式不合规范！");
	}else if(!reg2.test(studentBirth)){
		alert("出生日期格式不合规范！");
	}else{
		var url="student/addinfo.do";
		var data={studentId:studentId,studentNo:studentNo,studentRealName:studentRealName,studentSex:studentSex,studentMajor:studentMajor,
				studentTell:studentTell,studentBirth:studentBirth};
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
	
}

