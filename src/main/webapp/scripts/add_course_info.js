/*登录界面JS脚本程序*/

$(function(){	
	$('#save_info').click(addCourseInfo);
});

function  addCourseInfo(){
	var courseNo=$('#courseNo').val();
	var courseName=$('#courseName').val();
	var courseProperties=$('input:radio:checked').val();
	var courseHour=$('#courseHour').val();
	var courseScore=$('#courseScore').val();
	var url="course/addinfo.do";
	var data={courseNo:courseNo,courseName:courseName,courseProperties:courseProperties,courseHour:courseHour,
			courseScore:courseScore};
	$.post(url,data,function(result){
		if(result.state==0){
			var course=result.data;
			console.log(course);
			alert("保存成功");
		}else{
			alert("保存失败");
		}
	});
	
}

