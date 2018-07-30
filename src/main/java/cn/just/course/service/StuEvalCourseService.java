package cn.just.course.service;

import java.text.ParseException;
import java.util.List;

import cn.just.course.entity.Course;
import cn.just.course.entity.StudentEvaluate;

public interface StuEvalCourseService {
	/**
	 * 
	 * @param courseNo
	 * @return
	 * @throws ParseException
	 */
	public List<StudentEvaluate> lookStuEvaluateInfo(String courseNo) throws  ParseException;
	/**
	 * ����������Ϣ
	 * @param studentEvalId
	 * @param courseNo
	 * @param options
	 * @return
	 * @throws ParseException
	 */
	public StudentEvaluate updateEvalInfo(Integer studentEvalId,String courseNo,String options) throws  ParseException;
	/**
	 * ����ѧ�����������Ϣ
	 * @param studentEvalId
	 * @param courseNo
	 * @param options
	 * @return
	 * @throws ParseException
	 */
	public StudentEvaluate updateEvalResultInfo(Integer studentEvalId,String courseNo,Integer optionValue,
			String suggestions) throws  ParseException;
}
