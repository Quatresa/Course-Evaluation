package cn.just.course.web;

import java.text.ParseException;
import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.just.course.entity.Admin;
import cn.just.course.service.AdminService;
import cn.just.course.service.PasswordException;
import cn.just.course.service.UserNameException;
import cn.just.course.util.JsonResult;

@Controller 
@RequestMapping("/admin")
public class AdminController extends AbstractController{

	@Resource
	private AdminService adminService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult<Admin> login(String name,String password){
			Admin admin=adminService.login(name, password);
			return new JsonResult<Admin>(admin);
	}
	
	//JSON: {state:0,data:{id:...},message:null}--map
	//JSON: {state:1,data:null,message:名字空}--map
	//临时性的用map,反复重用的用对象
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult<Admin> regist(String name,String password,String confirm){
			Admin admin=adminService.regist(name, password, confirm);
			return  new JsonResult<Admin>(admin);
	}
	
	@RequestMapping("/checkinfo.do")
	@ResponseBody
	public JsonResult<Admin> checkInfo(String adminId, String oldPwd){
			Admin admin=adminService.checkInfo(adminId,oldPwd);
			return  new JsonResult<Admin>(admin);
	}
	
	@RequestMapping("/updateinfo.do")
	@ResponseBody
	public JsonResult<Admin> updateInfo(String adminId,String newPwd){
			Admin admin=new Admin();
			try {
				admin = adminService.updateInfo(adminId,newPwd);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<Admin>(admin);
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

}
