package cn.just.course.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import cn.just.course.entity.Teacher;
public interface TeacherDao {
	void saveTeacher(Teacher teacher);
	Teacher findTeacherById(String id);
	Teacher findTeacherByName(String name);
	int updateTeacher(Map<String, Object> teacher);
	int updateTeacherPwd(Map<String, Object> teacher);
	ArrayList<Teacher> lookTeacherInfo();
	void deleteTeacherInfo(List<String> teacherNos);
}
