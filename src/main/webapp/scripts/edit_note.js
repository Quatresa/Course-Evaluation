//edit_note.js: 封装全部与笔记本有关的脚本
function showNotesAction(){
	//this是li元素
	console.log(this);
	//获取选中元素的序号，此序号是在显示笔记本列表时候绑定的。
	var li=$(this);
	var index=li.data('index');
	console.log(index);
	//处理视觉效果
	li.parent().find('a').removeClass('checked');
	li.find('a').addClass('checked');
	
	//让模型显示当前笔记本的全部笔记
	model.showNotes(index);
	
}
//显示选定笔记本的全部笔记
model.showNotes=function(notebookIndex){
	console.log(notebookIndex);
	//找到当前笔记本信息
	console.log(this);//model对象
	var notebook=this.notebooks[notebookIndex];
	console.log(notebook);
	//向服务器发起Ajax请求获取笔记列表
	var url="note/list.do";
	var data={notebookId:notebook.id};
	console.log(data);
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			//console.log(result.data);
			//更新笔记列表
			model.updateNotes(result.data);
		}else{
			alert(result.message);
		}
	});
}
//将notes 显示到界面
model.updateNotes=function(notes){
	
	var template='<li class="online">'+
		         '<a>'+
	             '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>[note.title]<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'+
                 '</a>'+
                  '<div class="note_menu" tabindex="-1">'+
	              '<dl>'+
		          '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'+
		          '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'+
		           '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'+
	                 '</dl>'+
                       '</div>'+
                        '</li>';
	console.log(notes);
	this.notes=notes;
	var ul=$('#notes').empty(); 
	for(var i=0;i<this.notes.length;i++){
		var note=this.notes[i];
		var li=template.replace('[note.title]',note.title);
		li=$(li);//可写可不写
		ul.append(li);
	}
}