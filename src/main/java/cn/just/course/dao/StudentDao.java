package cn.just.course.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import cn.just.course.entity.Student;
public interface StudentDao {
	void saveStudent(Student student);
    Student findStudentById(String id);
	Student findStudentByName(String name);
	int updateStudent(Map<String, Object> student);
	int updateStudentPwd(Map<String, Object> student);
	ArrayList<Student> lookStudentInfo();
	void deleteStudentInfo(List<String> studentNos);
		
}
