package cn.just.test;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.just.course.dao.TeacherDao;
import cn.just.course.entity.Admin;
import cn.just.course.entity.Course;
import cn.just.course.entity.StudentEvaluate;
import cn.just.course.entity.TeacherEvaluate;
import cn.just.course.service.AdminService;
import cn.just.course.service.CourseService;
import cn.just.course.service.StuEvalCourseService;
import cn.just.course.service.TeaEvalCourseService;
import cn.just.course.service.TeacherService;

public class AdminServiceTestCase {

	ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	/*
	@Test
	public void testLogin(){
	 
		AdminService service=ctx.getBean("adminService",AdminService.class);
		String name="Tom";
		String password="123";
		Admin admin=service.login(name, password);
		System.out.println(admin);	
	}
	
	@Test
	public void testRegistUser(){
		AdminService service=ctx.getBean("adminService",AdminService.class);
		Admin admin=service.regist("Jack", "123","123");
		System.out.println(admin);
	}
	*/
/*	@Test
	public void testLogin1(){
	 
		AdminService service=ctx.getBean("adminService",AdminService.class);
		String name="Tomn";
		String password="123";
		Admin admin=service.login(name, password);
		System.out.println(admin);
	}*/	
	
	/*@Test
	public void testDelete(){
		TeacherDao dao = ctx.getBean(
		        "teacherDao", TeacherDao.class);
		List teacherNos=new ArrayList<String>();
		for(int i=0;i<1;i++){
			teacherNos.add(i, "2");
		}
		    dao.deleteTeacherInfo(teacherNos);
		
	}*/
	/*@Test
	public void queryByPage(){
		CourseService service=ctx.getBean("courseService",CourseService.class);
		PagedResult<Course>  pagedResult = service.lookCourseInfo1();
	}*/
	/*@Test
	public void findEvalInfo() throws ParseException{
		TeaEvalCourseService service=ctx.getBean("teaEvalCourseService",TeaEvalCourseService.class);
		List<TeacherEvaluate> teacherEvaluate=new ArrayList<TeacherEvaluate>();
		teacherEvaluate= service.findEvaluateInfoById("19040198a");
		//indexNos= service.findEvaluateInfoById("19040198a");
		for(int i=0;i<teacherEvaluate.size();i++){
			System.out.println(teacherEvaluate.get(i));
		}
		
	}*/
	/*@Test
	public void findEvalInfo() throws ParseException{
		TeaEvalCourseService service=ctx.getBean("teaEvalCourseService",TeaEvalCourseService.class);
		List<TeacherEvaluate> teacherEvaluate=new ArrayList<TeacherEvaluate>();
		teacherEvaluate= service.findEvalInfoByIndexId(1);
		//indexNos= service.findEvaluateInfoById("19040198a");
		for(int i=0;i<teacherEvaluate.size();i++){
			System.out.println(teacherEvaluate.get(i));
		}
		
	}*/
	/*@Test
	public void countIndexInfo() throws ParseException{
		TeaEvalCourseService service=ctx.getBean("teaEvalCourseService",TeaEvalCourseService.class);
        int count=service.countIndexId();
        System.out.println(count);
		
	}*/
	@Test
	public void findEvalInfo() throws ParseException{
		StuEvalCourseService service=ctx.getBean("stuEvalCourseService",StuEvalCourseService.class);
		List<StudentEvaluate> studentEvaluate=new ArrayList<StudentEvaluate>();
		studentEvaluate=service.lookStuEvaluateInfo("05020058a");
		for(int i=0;i<studentEvaluate.size();i++){
			System.out.println(studentEvaluate.get(i));
		}
		
	}
	
}
