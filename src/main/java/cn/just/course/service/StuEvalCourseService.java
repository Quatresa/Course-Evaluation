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
	 * 更新评估信息
	 * @param studentEvalId
	 * @param courseNo
	 * @param options
	 * @return
	 * @throws ParseException
	 */
	public StudentEvaluate updateEvalInfo(Integer studentEvalId,String courseNo,String options) throws  ParseException;
	/**
	 * 更新学生评估结果信息
	 * @param studentEvalId
	 * @param courseNo
	 * @param options
	 * @return
	 * @throws ParseException
	 */
	public StudentEvaluate updateEvalResultInfo(Integer studentEvalId,String courseNo,Integer optionValue,
			String suggestions) throws  ParseException;
}
