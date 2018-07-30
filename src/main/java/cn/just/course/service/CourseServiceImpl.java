package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.just.course.dao.CourseDao;
import cn.just.course.entity.Course;
@Service("courseService")
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	public Course addCourseInfo(String courseNo, String courseName, String courseProperties, String courseHour,
			Float courseScore) throws ParseException {
		//查询用户数据
		Course course=new Course();
		course.setCourseNo(courseNo);
		course.setCourseName(courseName);
		course.setCourseProperties(courseProperties);
		course.setCourseHour(courseHour);
		course.setCourseScore(courseScore);
	    courseDao.saveCourse(course);
		return course;

	}
	public ArrayList<Course> lookCourseInfo() throws ParseException {
		ArrayList<Course> courseList=new ArrayList<Course>();
		courseList=courseDao.lookCourseInfo();
		return courseList;
	}
	public void deleteCourseInfo(List<String> courseNos) throws ParseException {
		List<String> courseNos1=new ArrayList<String>(); 
		for(int i=0;i<courseNos.size();i++){
			int end= courseNos.get(i).toString().lastIndexOf('"');
			courseNos1.add(courseNos.get(i).toString().substring(1,end));
		}
		courseDao.deleteCourseInfo(courseNos1);
		
	}
	public Course lookOneCourseInfo(String courseNo) throws ParseException {
		//查询用户数据
		Course course=new Course();
		course.setCourseNo(courseNo);
		course=courseDao.findCourseById(courseNo);
		return course;
	}
	public Course updateCourseInfo(String courseNo,String courseName,String courseProperties,String courseHour,
			Float courseScore) throws ParseException {
		Course course=new Course();
		course.setCourseNo(courseNo);
		course.setCourseName(courseName);
		course.setCourseProperties(courseProperties);
		course.setCourseHour(courseHour);
		course.setCourseScore(courseScore);
	    Map<String, Object> data=new HashMap<String, Object>();
	    data.put("courseNo", courseNo);
	    data.put("courseName", courseName);
	    data.put("courseProperties", courseProperties);
	    data.put("courseHour", courseHour);
	    data.put("courseScore", courseScore);
	    courseDao.updateCourse(data);
		return course;
	}
	/*public PageList<Course> findByPage(PageBounds pageBounds) {
		PageList<Course> courseList=new PageList<Course>();
		courseList=courseDao.lookCourseInfoByPage(pageBounds);
		return courseList;
	}*/

}
