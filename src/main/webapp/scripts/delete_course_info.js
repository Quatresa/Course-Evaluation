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
	                var tr='<tr><td  class="input1"><p><center><input name="checkbox'+
	                i+ '" type="checkbox" value='+
	                courseNo+'></center></p></td>'+
	                '<td><center>' +
	                courseNo +
	                '</center></td><td><center>' +
	                courseName +
	                '</center></td><td><center>' +
	                courseProperties +
	                '</center></td>' +
	                '<td><center>' +
	                courseHour +
	                '</center></td><td><center>' +
	                courseScore+
	                '</td></tr>';
	              tb.append(tr);
	        	}
	        	var tr1='<tr><td colspan="7"><center><input class="input2" type="button" id="delete_info" onclick="deleteCourseInfo()" value="删除"><center></td></tr>';
	        	tb.append(tr1);
	        }else{
	        	alert("查询失败！");
	        }
		});
	}

});
function deleteCourseInfo(){
	var checkboxs=$("input[type='checkbox']:checked");
	var courseNos=new Array();
	console.log(checkboxs);
	for(var i=0;i<checkboxs.length;i++){
		courseNos[i]=checkboxs[i].value;	
	}
	console.log(courseNos);
	var url="course/deleteCourseInfo.do";
	var data={courseNos:JSON.stringify(courseNos)};
	console.log("url:"+url);
	console.log("data:"+data);
	$.post(url,data,function(result){
		if(result.state==0){
			alert("删除成功！");
		}else{
			alert("删除失败！");
		}
	});
}




