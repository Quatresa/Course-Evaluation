package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import cn.just.course.entity.Course;


public interface CourseService {

	/**
	 * ��ӿγ���Ϣ
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
     * �鿴���еĿγ���Ϣ
     * @return
     * @throws ParseException
     */
    public ArrayList<Course> lookCourseInfo() throws  ParseException;
    /**
     * ɾ���γ���Ϣ
     * @param courseNos
     * @throws ParseException
     */
    public void deleteCourseInfo(List<String> courseNos) throws  ParseException;
    /**
     * �鿴ָ���γ���Ϣ
     * @return
     * @throws ParseException
     */
    public Course lookOneCourseInfo(String courseNo) throws  ParseException;
    /**
     * ����ָ���γ���Ϣ
     * @param courseNo
     * @return
     * @throws ParseException
     */
    public Course updateCourseInfo(String courseNo,String courseName,String courseProperties,String courseHour,Float courseScore) throws  ParseException;
	
}
