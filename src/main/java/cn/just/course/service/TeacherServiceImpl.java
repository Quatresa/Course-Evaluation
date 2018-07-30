package cn.just.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.just.course.dao.TeacherDao;
import cn.just.course.entity.Student;
import cn.just.course.entity.Teacher;
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDao teacherDao;
	public Teacher login(String name, String password) throws UserNameException, PasswordException {
			//检验输入参数的合理性
			if(name==null||name.trim().isEmpty()){
				throw new UserNameException("名字不能为空");
			}
			String reg="^\\w{3,10}$";
			if(!name.matches(reg)){
				throw new UserNameException("名字不符合规范");
			}
			if(password==null||password.trim().isEmpty()){
				throw new PasswordException("密码不能为空");
			}
			if(!password.matches(reg)){
				throw new PasswordException("密码不符合规范");
			}
			//查询用户数据
			Teacher teacher=teacherDao.findTeacherByName(name);
			if(teacher==null){
				throw new UserNameException("用户名错误");
			}
			if(teacher.getTeacherPassword().equals(password)){
				//业务处理
				//登录成功，返回用户信息
				return teacher;
			}
			throw new PasswordException("密码错误");
	}

	public Teacher regist(String name,String password, String confirm)
			throws UserNameException, PasswordException {
		if(name==null||name.trim().isEmpty()){
			throw new UserNameException("用户名不能为空");
		}
		String reg="^\\w{3,10}$";
		if(!name.matches(reg)){
			throw new UserNameException("用户名不合规则");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		password=password.trim();
		if(!password.matches(reg)){
			throw new PasswordException("密码不合规则");
		}
		
		if(!password.equals(confirm)){
			throw new PasswordException("确认密码不一致");
		}
		name=name.trim();
		//检验用户名是否重复？
		Teacher one=teacherDao.findTeacherByName(name);
		if(one!=null){
			throw new UserNameException("已注册");
		}
		//name,password
		//UUID用于生产永远不重复的ID
		String id=UUID.randomUUID().toString();
		Teacher teacher=new Teacher(id,name,password);
		teacherDao.saveTeacher(teacher);
		return teacher;
	}

	public Teacher addTeacherInfo(String teacherId, String teacherNo, String teacherRealName, String teacherSex,
			String teacherJob, String teacherTell, String teacherBirth) throws ParseException {
       //查询用户数据
		Teacher teacher=new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setTeacherNo(teacherNo);
		teacher.setTeacherRealName(teacherRealName);;
		teacher.setTeacherSex(teacherSex);
		teacher.setTeacherJob(teacherJob);
		teacher.setTeacherTell(teacherTell);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date birthDate = sdf.parse(teacherBirth);
		teacher.setTeacherBirth(birthDate);
	    Map<String, Object> data=new HashMap<String, Object>();
	    data.put("teacherId", teacher.getTeacherId());
	    data.put("teacherNo", teacher.getTeacherNo());
	    data.put("teacherRealName", teacher.getTeacherRealName());
	    data.put("teacherSex", teacher.getTeacherSex());
	    data.put("teacherJob", teacher.getTeacherJob());
	    data.put("teacherTell", teacher.getTeacherTell());
	    data.put("teacherBirth", teacher.getTeacherBirth());
	    teacherDao.updateTeacher(data);
		return teacher;
	}

	public Teacher checkInfo(String teacherId, String oldPwd) throws PasswordException {
		//查询用户数据
		Teacher teacher=teacherDao.findTeacherById(teacherId);
		if(teacher.getTeacherPassword().equals(oldPwd)){
			//业务处理
			//登录成功，返回用户信息
			return teacher;
		}
		throw new PasswordException("密码错误");
	}

	public Teacher updateInfo(String teacherId, String newPwd) throws ParseException {
		 //查询用户数据
		Teacher teacher=new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPassword(newPwd);
	    Map<String, Object> data=new HashMap<String, Object>();
	    data.put("teacherId", teacher.getTeacherId());
	    data.put("teacherPassword", teacher.getTeacherPassword());
	    teacherDao.updateTeacherPwd(data);
		return teacher;
	}

	public Teacher lookTeacherInfo(String teacherId) throws ParseException {
		//查询用户数据
		Teacher teacher=new  Teacher();
		teacher.setTeacherId(teacherId);
		teacher=teacherDao.findTeacherById(teacherId);
		return teacher;
	}

	public ArrayList<Teacher> lookTeacherInfo() {
		ArrayList<Teacher> teacherList=new ArrayList<Teacher>();
		teacherList=teacherDao.lookTeacherInfo();
		return teacherList;
	}

	public void deleteTeacherInfo(List teacherNos) throws ParseException {	
		List<String> teacherNos1=new ArrayList<String>(); 
		for(int i=0;i<teacherNos.size();i++){
			//teacherNos1.add(i, teacherNos.get(i));
			int end= teacherNos.get(i).toString().lastIndexOf('"');
			teacherNos1.add(teacherNos.get(i).toString().substring(1,end));
		}
		teacherDao.deleteTeacherInfo(teacherNos1);
	}

	public boolean checkId(String teacherId) {
		if(teacherId==null || teacherId.trim().isEmpty()){
			return false;
		}
		Teacher teacher=teacherDao.findTeacherById(teacherId);
		if(teacher==null){
			return false; 
		}
		return true;
	}

}
