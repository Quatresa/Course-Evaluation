/*修改课程信息JS脚本程序*/
$(function(){
	$('#save_info').click(updateCourseInfo);
	var courseNo=GetQueryString('courseNo').split("=")[1];
	console.log(courseNo);	
	var url="course/lookinfo.do";
	var data={courseNo:courseNo};
	$.post(url,data,function(result){
		if(result.state==0){
			var course=result.data;
			$('#courseNo').val(course.courseNo);
			$('#courseName').val(course.courseName);
			if(course.courseProperties=="0"){
				$("input[name='selectCourse'][value='0']").attr("checked",true);
			}else{
				$("input[name='selectCourse'][value='1']").attr("checked",true);
			}
			$('#courseHour').val(course.courseHour);
			$('#courseScore').val(course.courseScore);
			return true;
		}else{
			return false;
		}
	});
});
function GetQueryString(name)
{
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r!=null)return  unescape(r[0]); return null;
} 
function  updateCourseInfo(){
	var courseNo=$('#courseNo').val();
	var courseName=$('#courseName').val();
	var courseProperties=$('input:radio:checked').val();
	var courseHour=$('#courseHour').val();
	var courseScore=$('#courseScore').val();
	var url="course/updateinfo.do";
	var data={courseNo:courseNo,courseName:courseName,courseProperties:courseProperties,courseHour:courseHour,courseScore:courseScore};
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