package cn.just.course.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.just.course.entity.Course;
import cn.just.course.entity.TeacherEvaluate;
public interface TeacherEvalCourseDao {
	List <TeacherEvaluate> findEvaluateInfoById(String courseNo);
	int updateEvaluateInfo(Map<String, Object> evalInfo);
	int updateEvalResult(Map<String, Object> evalInfo);
	ArrayList <TeacherEvaluate> findIndexInfo();
	ArrayList <TeacherEvaluate> findEvalInfoById(Integer indexId);
	int countIndexId();
	void saveIndexInfo(String indexNo);
	void saveIndexInfoNo(TeacherEvaluate teacherEvaluate);
	TeacherEvaluate findIndexInfoByNo(String indexNo);
	void deleteIndexNoInfo(Integer indexId,String courseNo);
}
