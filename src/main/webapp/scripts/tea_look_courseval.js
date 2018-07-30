/*教师评估信息JS脚本程序*/
$(function(){	
	$('#total').blur(showTotalScore);
	var courseNo=GetQueryString('courseNo').split("=")[1];
	console.log(courseNo);
	var url="teacherEval/evalInfo.do";
	var data={courseNo:courseNo};
	//获取表格tbody
    var div=$("#content");
    //先清空tbody里面的数据
    div.empty();
	$.post(url,data,function(result){
		if(result.state==0){
			var indexList=result.data;
			console.log(indexList);
			//var weight=1/indexList.length;
			 if(indexList.length==0){
                 $("#index_list").hide();
             }else{
                 $("#index_list").show();
             }
			for(var i=0;i<indexList.length;i++){
                //获取对象的属性
                var indexNo=indexList[i];
                var weight;
                if(indexList[i].weight!=null){
                	weight=indexList[i].weight;
                }else{
                	weight=(1/indexList.length).toFixed(2);
                }
                var indexId=indexList[i].indexId;
                var score=indexList[i].score;
                var list="<span class='text0'>指标点：</span>"+
			              "<textarea name='index' class='text1' id=''>"+indexList[i].indexNo+"</textarea>"+
			              "<span class='text0'>权重：</span>"+
			             "<input class='text2' name='weight' type='text'  value='";
			       if(indexList.length==3&&i==0&&indexList[i].weight==null){
			    	   weight=Number(weight)+Number(0.01);
			       }      
			      list=list+ weight+"'id='text" +i+
			              "'/><span class='text0'>分数：</span>"+
	              "<input class='text2' name='score' type='text'  value='" +score+
			      "' ><input type='hidden' name='indexId' value='"+indexId+"'></br>";
                div.append(list);   
        	}
		
		}else{
			alert("查询失败");
		}
	});
	$('#save_info').click(saveIndexWeight);
	
});
function saveIndexWeight(courseNo){
	var courseNo=GetQueryString('courseNo').split("=")[1];
	//var checkboxs=$("input[name='weight']").val();
	var weights=document.getElementsByName("weight");
	var indexs=document.getElementsByName("index");
	var indexIds=document.getElementsByName("indexId");
	var scores=document.getElementsByName("score");
	var url="teacherEval/updateEvalResult.do"
	for(var i=0;i<indexs.length;i++){
		var indexNo=indexs[i].value;
		var weight=weights[i].value;
		var indexId=indexIds[i].value;
		var score=scores[i].value;
		var data={courseNo:courseNo,indexNo:indexNo,weight:weight,indexId:indexId,score:score};
		console.log(data);
		$.post(url,data,function(result){
			if(result.state==0){
				var teacherEvaluate=result.data;
				console.log(teacherEvaluate);
				
			}else{
				return false;
			}
		});
			
	}
	alert("保存成功");
}
function GetQueryString(name)
{
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r!=null)return  unescape(r[0]); return null;
}
function showTotalScore(){
	var weights=document.getElementsByName("weight");
	var scores=document.getElementsByName("score");
	var totalScore=0;
	for(var i=0;i<weights.length;i++){
		var weight=weights[i].value;
		var score=scores[i].value;
		totalScore=totalScore+weight*score;	
	}
	$('#total').val(totalScore.toFixed(2));
}





