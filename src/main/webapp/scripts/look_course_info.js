/*查看老师信息JS脚本程序*/
$(function(){	
	//获取表格tbody
    var tb=$("#course_info");
    //先清空tbody里面的数据
    tb.empty();
    lookCourseInfo(1);
    var url1="course/prepareCourseInfo.do";
	var data={};
	$.post(url1,data,function(result){
        if(result.state==0){
        	var courseList=result.data;
        	console.log(courseList);
        	courseList.pages;
        	changePage(12,courseList.pages,100);
        }
	});	
	
	//分页
	function changePage(pageSize, buttons, total) {
	    $("#course_info_page").jBootstrapPage({
	        pageSize : pageSize,
	        total : total,
	        maxPageButton : buttons,
	        onPageClicked : function(obj, pageIndex) {
	            // 点击页数执行操作
	           lookCourseInfo(pageIndex+1);
	           //$("#currentPage").html(pageIndex+1);
	        }
	    });
	}
	
	function lookCourseInfo(pageIndex){
		//获取表格tbody
	    var tb=$("#course_info");
	    //先清空tbody里面的数据
	    tb.empty();
		var url2="course/lookCourseInfo.do";
		var data={page:pageIndex};
		console.log(data);
		$.post(url2,data,function(result){
	        if(result.state==0){
	        	var courseList=result.data;
	        	console.log(courseList);
	        	 if(courseList.length==0){
	                 $("#info-list").hide();
	             }else{
	                 $("#info-list").show();
	             }
	        	for(var i=0;i<courseList.length;i++){
	                //获取对象的属性
	                var courseNo=courseList[i].courseNo;
	                var courseName=courseList[i].courseName;
	                if(courseList[i].courseProperties=="0"){
	                	courseProperties="必修";
	                }else{
	                	courseProperties="选修";
	                }
	                var courseHour=courseList[i].courseHour;
	                var courseScore=courseList[i].courseScore;
	                //将结果拼接在页面的列表中
	                var tr='<tr><td><center>' +
	                courseNo +
	                '</center></td><td><center>' +
	                courseName +
	                '</td><td><center>' +
	                courseProperties +
	                '</center></td>' +
	                '<td><center>' +
	                courseHour +
	                '</center></td><td><center>' +
	                courseScore+
	                '<td><center><input  type="button" value="学生评估" onclick="studentEvaluate(\''+courseNo+'\')"></center></td>'+
	                '<td><center><input  type="button" value="老师评估" onclick="teacherEvaluate(\''+courseNo+'\')"></center></td>'+
	                '</center></td><tr>';
	              tb.append(tr);
	        	}
	       
	        }else{
	        	alert("查询失败！");
	        }
		});
	}

});
function studentEvaluate(courseNo){
	location.href='admin_student_evaluate.html?courseNo='+courseNo;
}
function teacherEvaluate(courseNo){
	location.href='admin_set_tea_eval.html?courseNo='+courseNo;
}






