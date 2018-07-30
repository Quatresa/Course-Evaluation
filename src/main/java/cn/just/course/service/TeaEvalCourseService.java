package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import cn.just.course.entity.TeacherEvaluate;
public interface TeaEvalCourseService {
	/**
	 * �鿴������Ϣ
	 * @param courseNo
	 * @return
	 * @throws ParseException
	 */
	public List <TeacherEvaluate> findEvaluateInfoById(String courseNo) throws  ParseException;
	/**
	 * ����������Ϣ
	 * @param courseNo
	 * @param indexNo
	 * @param weight
	 * @return
	 * @throws ParseException
	 */
	public TeacherEvaluate updateEvalInfo(String courseNo,String indexNo,Float weight,Integer indexId) throws  ParseException;

	/**
	 * �������������Ϣ
	 * @param courseNo
	 * @param indexId
	 * @param score
	 * @return
	 * @throws ParseException
	 */
	public TeacherEvaluate updateEvalResult(String courseNo,Integer indexId,Integer score) throws  ParseException;
	/**
	 * �鿴ָ�����Ϣ
	 * @return
	 * @throws ParseException
	 */
	public ArrayList <TeacherEvaluate> findIndexInfo() throws  ParseException;
	/**
	 * �鿴ָ���������Ϣ
	 * @param indexId
	 * @return
	 * @throws ParseException
	 */
	public ArrayList <TeacherEvaluate> findEvalInfo(Integer indexId) throws  ParseException;
	/**
	 * ����ָ������
	 * @return
	 */
	int countIndexId()throws  ParseException;
	/**
	 * ����ָ�����Ϣ
	 * @param indexNo
	 * @return
	 * @throws ParseException
	 */
	public TeacherEvaluate addIndexNoInfo(String indexNo)throws  ParseException;
	/**
	 * ����γ�����ָ�����Ϣ
	 * @param teacherEvaluate
	 * @return
	 * @throws ParseException
	 */
	public TeacherEvaluate saveIndexInfoNo(TeacherEvaluate teacherEvaluate)throws  ParseException;
	/**
	 * �鿴ָ���Id
	 * @param indexNo
	 * @return
	 * @throws ParseException
	 */
	public TeacherEvaluate findIndexInfoByNo(String indexNo)throws  ParseException;
	/**
	 * ɾ���γ�ָ����Ϣ
	 * @param indexId
	 * @param courseNo
	 * @throws ParseException
	 */
	public void deleteEvalInfo(Integer indexId,String courseNo)throws  ParseException;
	
}
