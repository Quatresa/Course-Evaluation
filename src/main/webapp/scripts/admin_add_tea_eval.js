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
			              "<input type='hidden' name='indexId' value='"+indexId+"'>"+
			              "</br></div>";
                div.append(list);
                   
        	}
			var list="<div class='clearfix floor'><span class='text0'>指标点：</span>"+
		     "<textarea name='index' class='text1' id='indexNo'></textarea>"+
		     "<input type='hidden' name='indexId' value=''>";
		    div.append(list);
		
		}else{
			alert("查询失败");
		}
	});
	$('#save_info').click(saveIndexNo);
	$('#ret').click(returnIndexPage);
});
function saveIndexNo(courseNo){
	var courseNo=GetQueryString('courseNo').split("=")[1];
	var indexNo=$("#indexNo").val();
	var data={indexNo:indexNo};
	console.log(data);
	var url="teacherEval/findIndexIdByNo.do";
	$.post(url,data,function(result){
		if(result.state==0){
			var teacherEvaluate1=result.data;
			console.log(teacherEvaluate1);
			if(teacherEvaluate1==null){
				alert("指标点信息不存在！");
				return false;
			}
			var indexId=teacherEvaluate1.indexId;
			var url1="teacherEval/addCourseIndexNoInfo.do";
			var data1={indexId:indexId,courseNo:courseNo};
			$.post(url1,data1,function(result){
				if(result.state==0){
					var teacherEvaluate=result.data;
					console.log(teacherEvaluate);	
					alert("保存成功");
				}else{
					return false;
				}
			});
		}else{
			return false;
		}
	});

	/*var url="teacherEval/updateEvalInfo.do"
	var totalWeight=0;
	for(var i=0;i<weights.length;i++){
		var weight=weights[i].value;
		alert(weight);
		var indexId=indexIds[i].value;
		totalWeight=totalWeight+weight;
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
			
	}*/
	
}
function returnIndexPage(){
	 var courseNo=GetQueryString('courseNo').split("=")[1];
	 location.href='admin_set_tea_eval.html?courseNo='+courseNo;
}

function GetQueryString(name)
{
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r!=null)return  unescape(r[0]); return null;
}






