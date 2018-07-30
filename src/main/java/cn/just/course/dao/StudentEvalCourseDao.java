package cn.just.course.dao;

import java.util.List;
import java.util.Map;

import cn.just.course.entity.StudentEvaluate;
public interface StudentEvalCourseDao {
	void saveEvaluateInfo(StudentEvaluate studentEvaluate);
	List<StudentEvaluate> findEvaluateInfoById(String courseNo);
	int updateEvalInfo(Map<String, Object> studentEvaluate);
	int updateEvalResultInfo(Map<String, Object> studentEvaluate);
}
