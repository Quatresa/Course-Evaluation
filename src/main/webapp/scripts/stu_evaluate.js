/*学生评估界面JS脚本程序*/

$(function(){
	//为提交按钮绑定单击事件
	$('#save_info').click(saveEvalResult);
	var courseNo=GetQueryString('courseNo').split("=")[1];
	console.log(courseNo);
	var url="studentEval/lookinfo.do";
	var data={courseNo:courseNo};
	$.post(url,data,function(result){
		if(result.state==0){
			var evalList=result.data;
			console.log(evalList);
			for(var i=0;i<evalList.length;i++){
                //获取对象的属性
                var options0=evalList[i].options;
                $('#select'+i+'').html(i+1+"."+options0);                  
        	}
		
		}else{
			alert("查询失败");
		}
	});
});

function saveEvalResult(){
	var courseNo=GetQueryString('courseNo').split("=")[1];
	console.log(courseNo);
	var options1=document.getElementsByName("option");
	var url="studentEval/updateEvalResultInfo.do";
	var courseNo=GetQueryString('courseNo').split("=")[1];
	console.log(courseNo);
	var url1="studentEval/lookinfo.do";
	var data1={courseNo:courseNo};
	var suggestions=$('#suggestions').val();
	console.log(suggestions);
	if(suggestions==""||suggestions==null){
		alert("请输入您对该课程的具体建议！");
	}else{
		$.post(url1,data1,function(result){
			if(result.state==0){
				var evalList=result.data;
				console.log(evalList);
				for(var i=0;i<evalList.length;i++){
	                //获取对象的属性
	                var studentEvalId=evalList[i].studentEvalId;
	                var optionValue=$('input[name="option'+i+'"'+']:radio:checked').val();
	        		var data={studentEvalId:studentEvalId,courseNo:courseNo,optionValue:optionValue,suggestions:suggestions};
	        		console.log(data);
	        		$.post(url,data,function(result){
	        			if(result.state==0){
	        				var studentEvaluate=result.data;
	        				console.log(studentEvaluate);
	        				
	        			}else{
	        				return false;
	        			}
	        		});		
	        	}
			}
		});
		alert("保存成功！");
	}
	
}

function GetQueryString(name)
{
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r!=null)return  unescape(r[0]); return null;
} 
	 





