package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import cn.just.course.entity.Course;


public interface CourseService {

	/**
	 * 添加课程信息
	 * @param courseNo
	 * @param courseName
	 * @param courseProperties
	 * @param courseHour
	 * @param courseScore
	 * @return
	 * @throws ParseException
	 */
    public Course addCourseInfo(String courseNo,String courseName,String courseProperties,String courseHour,Float courseScore)
    		throws  ParseException;
    /**
     * 查看所有的课程信息
     * @return
     * @throws ParseException
     */
    public ArrayList<Course> lookCourseInfo() throws  ParseException;
    /**
     * 删除课程信息
     * @param courseNos
     * @throws ParseException
     */
    public void deleteCourseInfo(List<String> courseNos) throws  ParseException;
    /**
     * 查看指定课程信息
     * @return
     * @throws ParseException
     */
    public Course lookOneCourseInfo(String courseNo) throws  ParseException;
    /**
     * 更新指定课程信息
     * @param courseNo
     * @return
     * @throws ParseException
     */
    public Course updateCourseInfo(String courseNo,String courseName,String courseProperties,String courseHour,Float courseScore) throws  ParseException;
	
}
