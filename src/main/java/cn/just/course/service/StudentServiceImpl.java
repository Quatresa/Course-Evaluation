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
import cn.just.course.dao.StudentDao;
import cn.just.course.entity.Student;
@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	public Student login(String name, String password) throws UserNameException, PasswordException {
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
			Student student=studentDao.findStudentByName(name);
			if(student==null){
				throw new UserNameException("用户名错误");
			}
			if(student.getStudentPassword().equals(password)){
				//业务处理
				//登录成功，返回用户信息
				/*String token=UUID.randomUUID().toString();
			    student.setStudentToken(token);
			    Map<String, Object> data=new HashMap<String, Object>();
			    data.put("studentId", student.getStudentId());
			    data.put("studentToken", token);
			    studentDao.updateStudent(data);*/
				return student;
			}
			throw new PasswordException("密码错误");
	}

	public Student regist(String name,String password, String confirm)
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
		Student one=studentDao.findStudentByName(name);
		if(one!=null){
			throw new UserNameException("已注册");
		}
		//name,password
		//UUID用于生产永远不重复的ID
		String id=UUID.randomUUID().toString();
		Student student=new Student(id,name,password);
		studentDao.saveStudent(student);
		return student;
	}
	
	public Student lookStudentInfo(String studentId) throws  ParseException {
		//查询用户数据
		Student student=new Student();
		student.setStudentId(studentId);
		student=studentDao.findStudentById(studentId);
		return student;
   }

	
	public Student addStudentInfo(String studentId,String studentNo,String studentRealName,String studentSex,String studentMajor,
    		String studentTell,String studentBirth) throws  ParseException {
		//查询用户数据
		Student student=new Student();
		student.setStudentId(studentId);
		student.setStudentNo(studentNo);
		student.setStudentRealName(studentRealName);;
		student.setStudentSex(studentSex);
		student.setStudentMajor(studentMajor);
		student.setStudentTell(studentTell);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date birthDate = sdf.parse(studentBirth);
		student.setStudentBirth(birthDate);
	    Map<String, Object> data=new HashMap<String, Object>();
	    data.put("studentId", student.getStudentId());
	    data.put("studentNo", student.getStudentNo());
	    data.put("studentRealName", student.getStudentRealName());
	    data.put("studentSex", student.getStudentSex());
	    data.put("studentMajor", student.getStudentMajor());
	    data.put("studentTell", student.getStudentTell());
	    data.put("studentBirth", student.getStudentBirth());
	    studentDao.updateStudent(data);
		return student;
   }

	public Student checkInfo(String studentId, String oldPwd) throws PasswordException {
		//查询用户数据
		Student student=studentDao.findStudentById(studentId);
		if(student.getStudentPassword().equals(oldPwd)){
			//业务处理
			//登录成功，返回用户信息
			return student;
		}
		throw new PasswordException("密码错误");
		
	}

	public Student updateInfo(String studentId, String newPwd) throws ParseException {
		 //查询用户数据
		Student student=new Student();
		student.setStudentId(studentId);
		student.setStudentPassword(newPwd);;
	    Map<String, Object> data=new HashMap<String, Object>();
	    data.put("studentId", student.getStudentId());
	    data.put("studentPassword", student.getStudentPassword());
	    studentDao.updateStudentPwd(data);
		return student;
	}

	public ArrayList<Student> lookStudentInfo() throws ParseException {
		ArrayList<Student> studentList=new ArrayList<Student>();
		studentList=studentDao.lookStudentInfo();
		return studentList;
	}

	public void deleteStudentInfo(List<String> studentNos) throws ParseException {
		List<String> studentNos1=new ArrayList<String>(); 
		for(int i=0;i<studentNos.size();i++){
			int end= studentNos.get(i).toString().lastIndexOf('"');
			studentNos1.add(studentNos.get(i).toString().substring(1,end));
		}
		studentDao.deleteStudentInfo(studentNos1);
	}

	public boolean checkId(String studentId) {
		if(studentId==null || studentId.trim().isEmpty()){
			return false;
		}
		Student student=studentDao.findStudentById(studentId);
		if(student==null){
			return false; 
		}
		return true;
	}

}
