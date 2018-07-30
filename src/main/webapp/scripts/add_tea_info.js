/*登录界面JS脚本程序*/

$(function(){
	$('#save_info').click(updateTeacherInfo);
	var teacherId=getCookie("teacherId");
	var url="teacher/lookinfo.do";
	var data={teacherId:teacherId};
	$.post(url,data,function(result){
		if(result.state==0){
			var teacher=result.data;
			$('#teacherNo').val(teacher.teacherNo);
			$('#teacherRealName').val(teacher.teacherRealName);
			if(teacher.teacherSex=="男"){
				$("input[name='sex'][value='男']").attr("checked",true);
			}else if(teacher.teacherSex=="女"){
				$("input[name='sex'][value='女']").attr("checked",true);
			}
			$('#teacherJob').val(teacher.teacherJob);
			$('#teacherTell').val(teacher.teacherTell);
			var date1=new Date(teacher.teacherBirth);
			$('#teacherBirth').val(date1.toLocaleString());
			return true;
		}else{
			return false;
		}
	});
});

Date.prototype.toLocaleString=function(){
	return this.getFullYear()+"-"+(this.getMonth()+1)+"-"+this.getDate();
}

function  updateTeacherInfo(){
	var teacherId=getCookie("teacherId");
	var teacherNo=$('#teacherNo').val();
	var teacherRealName=$('#teacherRealName').val();
	var teacherSex=$('input:radio:checked').val();
	var teacherJob=$('#teacherJob').val();
	var teacherTell=$('#teacherTell').val();
	var teacherBirth=$('#teacherBirth').val();
	var reg1=/^(\+86)?\s*\d{11}$/;
	var reg2=/^\d{4}-\d{2}-\d{2}$/;
	if(!reg1.test(teacherTell)){
		alert("联系方式格式不合规范！");
	}else if(!reg2.test(teacherBirth)){
		alert("出生日期格式不合规范！");
	}else{
		var url="teacher/addinfo.do";
		var data={teacherId:teacherId,teacherNo:teacherNo,teacherRealName:teacherRealName,teacherSex:teacherSex,teacherJob:teacherJob,
				teacherTell:teacherTell,teacherBirth:teacherBirth};
		$.post(url,data,function(result){
			if(result.state==0){
				var teacher=result.data;
				console.log(teacher);
				alert("保存成功");
			}else{
				alert("保存失败");
			}
		});
	}		
}

