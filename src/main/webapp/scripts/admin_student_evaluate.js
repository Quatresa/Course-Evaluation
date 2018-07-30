/*学生评估信息JS脚本程序*/
$(function(){		
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
                $('#option'+i+'').val(options0);                  
        	}
		
		}else{
			alert("查询失败");
		}
	});
	$('#save_info').click(saveEvalInfo);
	
});
function saveEvalInfo(){
	var courseNo=GetQueryString('courseNo').split("=")[1];
	console.log(courseNo);
	var options1=document.getElementsByName("option");
	var url="studentEval/updateEvalInfo.do";
	var courseNo=GetQueryString('courseNo').split("=")[1];
	console.log(courseNo);
	var url1="studentEval/lookinfo.do";
	var data1={courseNo:courseNo};
	$.post(url1,data1,function(result){
		if(result.state==0){
			var evalList=result.data;
			console.log(evalList);
			for(var i=0;i<evalList.length;i++){
                //获取对象的属性
                var studentEvalId=evalList[i].studentEvalId;
                var options=options1[i].value;
        		var data={studentEvalId:studentEvalId,courseNo:courseNo,options:options};
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
	alert("保存成功");
}
function GetQueryString(name)
{
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r!=null)return  unescape(r[0]); return null;
}






