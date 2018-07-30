package cn.just.course.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.just.course.entity.Admin;
import cn.just.course.entity.Student;
import cn.just.course.service.PasswordException;
import cn.just.course.service.StudentService;
import cn.just.course.service.UserNameException;
import cn.just.course.util.JsonResult;

@Controller 
@RequestMapping("/student")
public class StudentController extends AbstractController{

	@Resource
	private StudentService studentService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult<Student> login(String name,String password){
			Student student=studentService.login(name, password);
			/*Cookie cookie = new Cookie("studentToken", student.getStudentToken());
		    cookie.setPath("/"); 
		    response.addCookie(cookie);*/
			return new JsonResult<Student>(student);
	}
	
	//JSON: {state:0,data:{id:...},message:null}--map
	//JSON: {state:1,data:null,message:名字空}--map
	//临时性的用map,反复重用的用对象
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult<Student> regist(String name,String password,String confirm){
			Student student=studentService.regist(name, password, confirm);
			return  new JsonResult<Student>(student);
	}
	
	@RequestMapping("/checkinfo.do")
	@ResponseBody
	public JsonResult<Student> checkInfo(String studentId, String oldPwd){
		   Student student=studentService.checkInfo(studentId,oldPwd);
		   return  new JsonResult<Student>(student);
	}
	
	@RequestMapping("/updateinfo.do")
	@ResponseBody
	public JsonResult<Student> updateInfo(String studentId,String newPwd){
		    Student student=new Student();
			try {
				student = studentService.updateInfo(studentId,newPwd);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<Student>(student);
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
	
	@RequestMapping("/lookinfo.do")
	@ResponseBody
	public JsonResult<Student> lookInfo(String studentId){
			Student student=new Student();
			try {
				student = studentService.lookStudentInfo(studentId);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<Student>(student);
	}
	
	@RequestMapping("/addinfo.do")
	@ResponseBody
	public JsonResult<Student> updateInfo(String studentId,String studentNo,String studentRealName,String studentSex,String studentMajor,
    		String studentTell,String studentBirth){
			Student student=new Student();
			try {
				student = studentService.addStudentInfo(studentId,studentNo,studentRealName,studentSex,studentMajor,
						studentTell,studentBirth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<Student>(student);
	}
	
	@RequestMapping("/lookStudentInfo.do")
	@ResponseBody
	public JsonResult<ArrayList> lookTeacherInfo(){
			ArrayList studentList=new ArrayList();
			try {
				studentList=studentService.lookStudentInfo();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<ArrayList>(studentList);
	}
	
	@RequestMapping("/deleteStudentInfo.do")
	@ResponseBody
	public JsonResult<ArrayList> deleteStudentInfo(String studentNos){
		String studentno1;
		int start=studentNos.indexOf("[")+1;
		int end=studentNos.indexOf("]");
		studentno1=studentNos.substring(start,end);
		List studentNoList=new ArrayList();
	    String[] studentNo2=studentno1.split(",");
	    studentNoList=Arrays.asList(studentNo2);
		try {
			studentService.deleteStudentInfo(studentNoList);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<ArrayList>();
	}

}
