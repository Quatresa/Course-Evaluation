/*查看课程信息JS脚本程序*/
$(function(){	
	//获取表格tbody
    var tb=$("#index_info");
    //先清空tbody里面的数据
    tb.empty();
    lookIndexInfo(1);
    //var url1="teacherEval/countIndex.do";
    var url1="teacherEval/preLookIndexInfo.do";
	var data={};
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
		var url2="teacherEval/lookIndex.do";
		var data={page:pageIndex};
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
	                var tr='<tr><td><center>' +
	                indexId +
	                '</center></td><td class="input1"><center>' +
	                indexNo +
	                '</td>'+
	                '<td><center><input  type="button" value="查看统计" onclick="lookIndexDetail(\''+indexId+'\')"></center></td>'+
	                '</center></td></tr>';
	              tb.append(tr);
	        	}
	       
	        }else{
	        	alert("查询失败！");
	        }
		});
	}

});

function lookIndexDetail(indexId){
	location.href='tea_look_index.html?indexId='+indexId;
}




