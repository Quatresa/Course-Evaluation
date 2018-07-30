package cn.just.course.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import cn.just.course.entity.Teacher;
import cn.just.course.service.PasswordException;
import cn.just.course.service.TeacherService;
import cn.just.course.service.UserNameException;
import cn.just.course.util.JsonResult;

@Controller 
@RequestMapping("/teacher")
public class TeacherController extends AbstractController{

	@Resource
	private TeacherService teacherService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult<Teacher> login(String name,String password){
			Teacher teacher=teacherService.login(name, password);
			return new JsonResult<Teacher>(teacher);
	}
	
	//JSON: {state:0,data:{id:...},message:null}--map
	//JSON: {state:1,data:null,message:名字空}--map
	//临时性的用map,反复重用的用对象
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult<Teacher> regist(String name,String password,String confirm){
			Teacher teacher=teacherService.regist(name, password, confirm);
			return  new JsonResult<Teacher>(teacher);
	}
	
	@RequestMapping("/lookinfo.do")
	@ResponseBody
	public JsonResult<Teacher> lookInfo(String teacherId){
			Teacher teacher=new Teacher();
			try {
				teacher = teacherService.lookTeacherInfo(teacherId);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<Teacher>(teacher);
	}
	
	@ExceptionHandler(UserNameException.class)
	@ResponseBody
	public JsonResult userName(UserNameException e){
		e.printStackTrace();
		return new JsonResult(2,e);
	}
	
	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public JsonResult password(PasswordException e){
		e.printStackTrace();
		return new JsonResult(3,e);
	}
	
	@RequestMapping("/addinfo.do")
	@ResponseBody
	public JsonResult<Teacher> updateInfo(String teacherId, String teacherNo, String teacherRealName, String teacherSex,
			String teacherJob, String teacherTell, String teacherBirth){
		   Teacher teacher=new Teacher();
			try {
				teacher = teacherService.addTeacherInfo(teacherId,teacherNo,teacherRealName,teacherSex,teacherJob,
						teacherTell,teacherBirth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<Teacher>(teacher);
	}
	
	@RequestMapping("/checkinfo.do")
	@ResponseBody
	public JsonResult<Teacher> checkInfo(String teacherId, String oldPwd){
		   Teacher teacher=teacherService.checkInfo(teacherId,oldPwd);
		   return  new JsonResult<Teacher>(teacher);
	}
	
	@RequestMapping("/updateinfo.do")
	@ResponseBody
	public JsonResult<Teacher> updateInfo(String teacherId,String newPwd){
		    Teacher teacher=new Teacher();
			try {
				teacher = teacherService.updateInfo(teacherId,newPwd);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<Teacher>(teacher);
	}
	
	@RequestMapping("/lookTeacherInfo.do")
	@ResponseBody
	public JsonResult<ArrayList> lookTeacherInfo(){
			ArrayList teacherList=new ArrayList();
			try {
				teacherList=teacherService.lookTeacherInfo();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<ArrayList>(teacherList);
	}
	
	@RequestMapping("/deleteTeacherInfo.do")
	@ResponseBody
	public JsonResult<ArrayList> deleteTeacherInfo(String teacherNos){
		String teacherno1;
		int start=teacherNos.indexOf("[")+1;
		int end=teacherNos.indexOf("]");
		teacherno1=teacherNos.substring(start,end);
		List teacherNoList=new ArrayList();
	    String[] teacherNo2=teacherno1.split(",");
	    teacherNoList=Arrays.asList(teacherNo2);
		try {
			teacherService.deleteTeacherInfo(teacherNoList);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<ArrayList>();
	}
	
}
