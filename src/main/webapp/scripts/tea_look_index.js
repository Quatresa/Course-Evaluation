/*查看课程信息JS脚本程序*/
$(function(){	
	$('#average').blur(showAverageScore);
	var indexId=GetQueryString('indexId').split("=")[1];
	console.log(indexId);
	//获取表格tbody
    var tb=$("#index_info");
    //先清空tbody里面的数据
    tb.empty();
    lookIndexInfo(1);
    //var url1="teacherEval/countIndex.do";
    var url1="teacherEval/prepareLookIndexInfo.do";
	var data={indexId:indexId};
	$.post(url1,data,function(result){
        if(result.state==0){
        	var indexList=result.data;
        	//var count=result.data;
        	//console.log(count);
        	indexList.pages;
        	console.log(indexList.pages);
        	changePage(5,indexList.pages,140);
        }
	});	
	
	//分页
	function changePage(pageSize, buttons, total) {
	    $("#index_info_page").jBootstrapPage({
	        pageSize : pageSize,
	        total : total,
	        maxPageButton : buttons,
	        onPageClicked : function(obj, pageIndex) {
	            // 点击页数执行操作
	           lookIndexInfo(pageIndex+1);
	           //$("#currentPage").html(pageIndex+1);
	        }
	    });
	}
	
	function lookIndexInfo(pageIndex){
		//获取表格tbody
	    var tb=$("#index_info");
	    //先清空tbody里面的数据
	    tb.empty();
		var url2="teacherEval/lookIndexInfo.do";
		var data={indexId:indexId,page:pageIndex};
		console.log(data);
		$.post(url2,data,function(result){
	        if(result.state==0){
	        	var indexList=result.data;
	        	console.log(indexList);
	        	 if(indexList.length==0){	 
	                 $("#info-list").hide();
	             }else{
	                 $("#info-list").show();
	             }
	        	 console.log(indexList);
	        	for(var i=0;i<indexList.length;i++){
	                //获取对象的属性
	        		var indexId=indexList[i].indexId;
	                var indexNo=indexList[i].indexNo;
	                var courseNo=indexList[i].courseNo;
	                var courseName=indexList[i].courseName;
	                var score=indexList[i].score;
	                var tr='<tr><td><center>' +
	                indexId +
	                '</center></td><td class="input1"><center>' +
	                indexNo +
	                '</td><td class="input5"><center>' +
	                courseNo +
	                '</center></td>' +
	                '<td class="input5"><center>' +
	                courseName +
	                '</center></td><td class="input5" name="score"><center>' +
	                score+
	                '</center></td></tr>';
	              tb.append(tr);
	        	}
	       
	        }else{
	        	alert("查询失败！");
	        }
		});
	}

});
function GetQueryString(name)
{
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r!=null)return  unescape(r[0]); return null;
}
function showAverageScore(){
	var scores=document.getElementsByName("score");
	console.log(scores);
	var totalScore=0;
	for(var i=0;i<scores.length;i++){
		var score=parseInt(scores[i].innerText);
		totalScore=totalScore+score;
	}
	var averageScore=totalScore/scores.length;
	$('#average').val(averageScore);
}



