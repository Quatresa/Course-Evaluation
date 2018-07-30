/*查看老师信息JS脚本程序*/
$(function(){	
	//获取表格tbody
    var tb=$("#student_info");
    //先清空tbody里面的数据
    tb.empty();
	var url="student/lookStudentInfo.do";
	var data={};
	$.post(url,data,function(result){
        if(result.state==0){
        	var studentList=result.data;
        	console.log(studentList);
        	 if(studentList.length==0){
                 $("#info-list").hide();
             }else{
                 $("#info-list").show();
             }
        	for(var i=0;i<studentList.length;i++){
                //获取对象的属性
                var studentNo=studentList[i].studentNo;
                var studentRealName=studentList[i].studentRealName;
                var studentSex=studentList[i].studentSex;
                var studentMajor=studentList[i].studentMajor;
                var studentTell=studentList[i].studentTell;
                var date1=new Date(studentList[i].studentBirth);
                var studentBirth=date1.toLocaleString();
                var tr='<tr><td><center>' +
                studentRealName+
                '</center></td><td><center>' +
                studentNo+
                '</center></td><td><center>' +
                studentSex +
                '</center></td>' +
                '<td><center>' +
                studentMajor +
                '</center></td><td><center>' +
                studentBirth+
                '</center></td><td><center>' +
                studentTell +
                '</center></td><tr>';
              tb.append(tr);
        	}
       
        }
	});
});

Date.prototype.toLocaleString=function(){
	return this.getFullYear()+"-"+(this.getMonth()+1)+"-"+this.getDate();
}



