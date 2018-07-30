/*查看老师信息JS脚本程序*/
$(function(){	
	//获取表格tbody
    var tb=$("#teach_info");
    //先清空tbody里面的数据
    tb.empty();
	var url="teacher/lookTeacherInfo.do";
	var data={};
	$.post(url,data,function(result){
        if(result.state==0){
        	var teacherList=result.data;
        	console.log(teacherList);
        	 if(teacherList.length==0){
                 $("#info-list").hide();
             }else{
                 $("#info-list").show();
             }
        	for(var i=0;i<teacherList.length;i++){
                //获取对象的属性
                var teacherNo=teacherList[i].teacherNo;
                var teacherRealName=teacherList[i].teacherRealName;
                var teacherSex=teacherList[i].teacherSex;
                var teacherJob=teacherList[i].teacherJob;
                var teacherTell=teacherList[i].teacherTell;
                var date1=new Date(teacherList[i].teacherBirth);
                var teacherBirth=date1.toLocaleString();
                var tr='<tr><td><center>' +
                teacherNo +
                '</center></td><td><center>' +
                teacherRealName +
                '</center></td><td><center>' +
                teacherSex +
                '</center></td>' +
                '<td><center>' +
                teacherJob +
                '</center></td><td><center>' +
                 teacherBirth+
                '</center></td><td><center>' +
                teacherTell +
                '</center></td><tr>';
              tb.append(tr);
        	}
       
        }
	});
});

Date.prototype.toLocaleString=function(){
	return this.getFullYear()+"-"+(this.getMonth()+1)+"-"+this.getDate();
}



