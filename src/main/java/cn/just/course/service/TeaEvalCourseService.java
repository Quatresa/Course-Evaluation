package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import cn.just.course.entity.TeacherEvaluate;
public interface TeaEvalCourseService {
	/**
	 * 查看评估信息
	 * @param courseNo
	 * @return
	 * @throws ParseException
	 */
	public List <TeacherEvaluate> findEvaluateInfoById(String courseNo) throws  ParseException;
	/**
	 * 更新评估信息
	 * @param courseNo
	 * @param indexNo
	 * @param weight
	 * @return
	 * @throws ParseException
	 */
	public TeacherEvaluate updateEvalInfo(String courseNo,String indexNo,Float weight,Integer indexId) throws  ParseException;

	/**
	 * 更新评估结果信息
	 * @param courseNo
	 * @param indexId
	 * @param score
	 * @return
	 * @throws ParseException
	 */
	public TeacherEvaluate updateEvalResult(String courseNo,Integer indexId,Integer score) throws  ParseException;
	/**
	 * 查看指标点信息
	 * @return
	 * @throws ParseException
	 */
	public ArrayList <TeacherEvaluate> findIndexInfo() throws  ParseException;
	/**
	 * 查看指标点评估信息
	 * @param indexId
	 * @return
	 * @throws ParseException
	 */
	public ArrayList <TeacherEvaluate> findEvalInfo(Integer indexId) throws  ParseException;
	/**
	 * 计算指标点个数
	 * @return
	 */
	int countIndexId()throws  ParseException;
	/**
	 * 增加指标点信息
	 * @param indexNo
	 * @return
	 * @throws ParseException
	 */
	public TeacherEvaluate addIndexNoInfo(String indexNo)throws  ParseException;
	/**
	 * 保存课程新增指标点信息
	 * @param teacherEvaluate
	 * @return
	 * @throws ParseException
	 */
	public TeacherEvaluate saveIndexInfoNo(TeacherEvaluate teacherEvaluate)throws  ParseException;
	/**
	 * 查看指标点Id
	 * @param indexNo
	 * @return
	 * @throws ParseException
	 */
	public TeacherEvaluate findIndexInfoByNo(String indexNo)throws  ParseException;
	/**
	 * 删除课程指标信息
	 * @param indexId
	 * @param courseNo
	 * @throws ParseException
	 */
	public void deleteEvalInfo(Integer indexId,String courseNo)throws  ParseException;
	
}
