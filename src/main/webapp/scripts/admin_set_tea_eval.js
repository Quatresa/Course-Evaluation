/*教师评估信息JS脚本程序*/
$(function(){		
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
                var list="<div class='clearfix floor'><span class='text0'>指标点：</span>"+
			              "<textarea name='index' class='text1' id=''>"+indexList[i].indexNo+"</textarea>"+
			              "<span class='text0'>权重：</span>"+
			             "<input class='text2' align='center' name='weight' type='text'  value='";
			       if(indexList.length==3&&i==0&&indexList[i].weight==null){
			    	   weight=Number(weight)+Number(0.01);
			       }      
			      list=list+ weight+"'id='text" +i+
			              "'/><input type='hidden' name='indexId' value='"+indexId+"'>"+
			              "<input class='del clearfix' type='submit' id='del' value='删除' onclick='deleteIndexNo(\""+indexId+"\")'></br></div>";
                div.append(list);
                   
        	}
		
		}else{
			alert("查询失败");
		}
	});
	$('#save_info').click(saveIndexWeight);
	$('#inc').click(increaseIndexIndo);
	
});
function saveIndexWeight(courseNo){
	var courseNo=GetQueryString('courseNo').split("=")[1];
	//var checkboxs=$("input[name='weight']").val();
	var weights=document.getElementsByName("weight");
	var indexs=document.getElementsByName("index");
	var indexIds=document.getElementsByName("indexId");
	var url="teacherEval/updateEvalInfo.do"
	var totalWeight=0;
	for(var i=0;i<weights.length;i++){
		var weight=weights[i].value;
		var indexId=indexIds[i].value;
		totalWeight=totalWeight+weight;
	}
	if(totalWeight!=1){
		alert("总权重必须为1！");
		return false;
	}		
	for(var i=0;i<indexs.length;i++){
		var indexNo=indexs[i].value;
		var weight=weights[i].value;
		var indexId=indexIds[i].value;
		var data={courseNo:courseNo,indexNo:indexNo,weight:weight,indexId:indexId};
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
function increaseIndexIndo(courseNo){
	 var courseNo=GetQueryString('courseNo').split("=")[1];
	 location.href='admin_add_tea_eval.html?courseNo='+courseNo;
}
function deleteIndexNo(indexId){
	var courseNo=GetQueryString('courseNo').split("=")[1];
	var url="teacherEval/deleteIndexInfo.do";
	var data={courseNo:courseNo,indexId:indexId};
	$.post(url,data,function(result){
		if(result.state==0){
			var teacherEval=result.data;
			console.log(teacherEval);
			alert("删除成功");
		}else{
			alert("删除失败");
		}
	});
}
function GetQueryString(name)
{
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r!=null)return  unescape(r[0]); return null;
}






