package cn.just.course.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;*/

import cn.just.course.entity.Course;
public interface CourseDao {
	void saveCourse(Course course);
	ArrayList<Course> lookCourseInfo();
	void deleteCourseInfo(List<String> courseNos);
	Course findCourseById(String courseNo);
	int updateCourse(Map<String, Object> course);
}
