package cn.just.test;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.javafx.collections.MappingChange.Map;

import cn.just.course.dao.AdminDao;
import cn.just.course.dao.StudentDao;
import cn.just.course.dao.TeacherDao;
import cn.just.course.entity.Admin;
import cn.just.course.entity.Course;
import cn.just.course.entity.Student;
import cn.just.course.entity.Teacher;
import cn.just.course.service.AdminService;

public class MyBatisTestCase {

	ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml");
	}
	
	/*@Test
	public void testDataSource(){
		DataSource ds=ctx.getBean("dataSource",DataSource.class);
		System.out.println(ds);
	}
	
	@Test
	public void testSqlSessionFactory(){
		SqlSessionFactory factory=ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(factory);
	}
	
	@Test
	public void testMapperScanner(){
		MapperScannerConfigurer scanner=ctx.getBean("mapperScanner",MapperScannerConfigurer.class);
		System.out.println(scanner);
	}*/
	
	/*@Test
	public void testSaveAdmin(){
	    AdminDao dao = ctx.getBean(
	        "AdminDao", adminDao.class);
	    Admin admin=new Admin(1, "Tom","123");
	    dao.saveAdmin(admin);	   
	}*/
	
	
	/*@Test
	public void testFindAdminById(){
		AdminDao dao = ctx.getBean(
			        "adminDao", AdminDao.class);
	    int id=1;
	    Admin admin=dao.findAdminById(id);
	    System.out.println(admin); 
	}
	
	@Test
	public void testFindAdminByName(){
		AdminDao dao=ctx.getBean("adminDao",AdminDao.class);
		String name="Tom";
		Admin admin=dao.findAdminByName(name);
		System.out.println(admin);
	}*/
	/*@Test
	public void testSaveStudent(){
	    StudentDao dao = ctx.getBean(
	        "studentDao", StudentDao.class);
	   // Student student=new Student("1", "Mike","123");
	   // dao.saveStudent(student);	   
	}*/
	
	/*@Test
	public void testFindStudentById(){
		StudentDao dao = ctx.getBean(
			        "studentDao", StudentDao.class);
	    int id=1;
	    Student student=dao.findStudentById(id);
	    System.out.println(student); 
	}*/
	
	/*@Test
	public void testFindStudentByName(){
		StudentDao dao=ctx.getBean("studentDao",StudentDao.class);
		String name="Mike";
		Student student=dao.findStudentByName(name);
		System.out.println(student);
	}*/
	
	/*@Test
	public void testSaveTeacher(){
	    TeacherDao dao = ctx.getBean(
	        "teacherDao", TeacherDao.class);
	    Teacher teacher=new Teacher(1, "Maria","123");
	    dao.saveTeacher(teacher);	
	    System.out.println(teacher);
	}
*/
	
	/*@Test
	public void testFindTeacherById(){
		TeacherDao dao = ctx.getBean(
			        "teacherDao", TeacherDao.class);
	    int id=1;
	    Teacher teacher=dao.findTeacherById(id);
	    System.out.println(teacher); 
	}*/
	
	/*@Test
	public void testFindStudentByName(){
		TeacherDao dao=ctx.getBean("teacherDao",TeacherDao.class);
		String name="Maria";
		Teacher teacher=dao.findTeacherByName(name);
		System.out.println(teacher);
	}*/
	/*@Test
	public void testUpdate(){
		StudentDao dao=ctx.getBean("studentDao", StudentDao.class);
		String name="Tomn";
		String password="123";
		Student studen1=new Student();
		studen1.setStudentTell("123456");
		Map map1=(Map) dao.updateStudent(studen1);
		System.out.println(map1);
	}*/

	
	
}
