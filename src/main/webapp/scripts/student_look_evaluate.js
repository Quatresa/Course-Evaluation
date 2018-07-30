/*学生查看评估界面JS脚本程序*/
$(function(){	
	var courseNo=GetQueryString('courseNo').split("=")[1];
	console.log(courseNo);
	var url="studentEval/lookinfo.do";
	var data={courseNo:courseNo};
	$.post(url,data,function(result){
		if(result.state==0){
			var evalList=result.data;
			console.log(evalList);
			var totalScore=0;
			for(var i=0;i<evalList.length;i++){
                //获取对象的属性
                var options0=evalList[i].options;
                var optionValue=evalList[i].optionValue;
                $('#select'+i+'').html(i+1+"."+options0);  
                $("input[name='option"+i+"'][value='"+optionValue+"']").attr("checked",true);
                totalScore=totalScore+optionValue;
        	}
			$('#suggestions').val(evalList[0].suggestions);
			$('#totalScore').val("       "+totalScore);
		
		}else{
			alert("查询失败");
		}
	});
	/*var courseNo=GetQueryString('courseNo').split("=")[1];
	console.log(courseNo);	
	var url="studentEval/lookinfo.do";
	var data={courseNo:courseNo};
	$.post(url,data,function(result){
		if(result.state==0){
			var studentEvaluate=result.data;
			console.log(studentEvaluate);
			if(studentEvaluate==null){
				alert("该课程评估评估结果未提交！");
				return false;
			}
			var option1=studentEvaluate.option1;
			var option2=studentEvaluate.option2;
			var option3=studentEvaluate.option3;
			var option4=studentEvaluate.option4;
			var option5=studentEvaluate.option5;
			var totalScore=option1+option2+option3+option4+option5;
			var suggestions=studentEvaluate.suggestions;
			$("input[name='option1'][value='"+option1+"']").attr("checked",true);
			$("input[name='option2'][value='"+option2+"']").attr("checked",true);
			$("input[name='option3'][value='"+option3+"']").attr("checked",true);
			$("input[name='option4'][value='"+option4+"']").attr("checked",true);
			$("input[name='option5'][value='"+option5+"']").attr("checked",true);
			$('#suggestions').val(suggestions);
			$('#totalScore').val("       "+totalScore);
			return true;
		}else{
			return false;
		}
	});*/
});
function GetQueryString(name)
{
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r!=null)return  unescape(r[0]); return null;
} 








