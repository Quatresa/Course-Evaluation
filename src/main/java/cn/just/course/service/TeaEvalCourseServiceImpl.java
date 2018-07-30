package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.just.course.dao.TeacherEvalCourseDao;
import cn.just.course.entity.TeacherEvaluate;

@Service("teaEvalCourseService")
public class TeaEvalCourseServiceImpl implements TeaEvalCourseService{
	@Autowired
	private TeacherEvalCourseDao teacherEvalCourseDao;

	public List <TeacherEvaluate> findEvaluateInfoById(String courseNo) throws ParseException {
		List<TeacherEvaluate> teacherEvaluate=new ArrayList<TeacherEvaluate>();
		teacherEvaluate=teacherEvalCourseDao.findEvaluateInfoById(courseNo);
		return teacherEvaluate;
	}

	public TeacherEvaluate updateEvalInfo(String courseNo, String indexNo, Float weight,Integer indexId) throws ParseException {
		TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
		teacherEvaluate.setIndexNo(indexNo);
		teacherEvaluate.setWeight(weight);
	    Map<String, Object> data=new HashMap<String, Object>();
	    data.put("courseNo", courseNo);
	    data.put("indexNo", indexNo);
	    data.put("weight", weight);
	    data.put("indexId", indexId);
	    teacherEvalCourseDao.updateEvaluateInfo(data);
		return teacherEvaluate;
	}

	public TeacherEvaluate updateEvalResult(String courseNo, Integer indexId, Integer score) throws ParseException {
		TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
		teacherEvaluate.setIndexId(indexId);
		teacherEvaluate.setScore(score);
	    Map<String, Object> data=new HashMap<String, Object>();
	    data.put("courseNo", courseNo);
	    data.put("indexId", indexId);
	    data.put("score", score);
	    teacherEvalCourseDao.updateEvalResult(data);
		return teacherEvaluate;
	}

	public ArrayList<TeacherEvaluate> findIndexInfo() throws ParseException {
		ArrayList<TeacherEvaluate> teacherEvaluate=new ArrayList<TeacherEvaluate>();
		teacherEvaluate=teacherEvalCourseDao.findIndexInfo();
		return teacherEvaluate;
	}  
	
	public ArrayList<TeacherEvaluate> findEvalInfo(Integer indexId) throws ParseException {
		ArrayList<TeacherEvaluate> teacherEvaluate=new ArrayList<TeacherEvaluate>();
		teacherEvaluate=teacherEvalCourseDao.findEvalInfoById(indexId);
		return teacherEvaluate;
	}

	public int countIndexId() throws ParseException {
		int count=0;
		count=teacherEvalCourseDao.countIndexId();
		return count;
	}

	public TeacherEvaluate addIndexNoInfo(String indexNo) throws ParseException {
		TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
		teacherEvaluate.setIndexNo(indexNo);
		teacherEvalCourseDao.saveIndexInfo(indexNo);
		return teacherEvaluate;
	}

	public TeacherEvaluate saveIndexInfoNo(TeacherEvaluate teacherEvaluate) throws ParseException {
		teacherEvalCourseDao.saveIndexInfoNo(teacherEvaluate);
		return teacherEvaluate;
	}

	public TeacherEvaluate findIndexInfoByNo(String indexNo) throws ParseException {
		TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
		teacherEvaluate.setIndexNo(indexNo);
		teacherEvaluate=teacherEvalCourseDao.findIndexInfoByNo(indexNo);
		return teacherEvaluate;
	}

	public void deleteEvalInfo(Integer indexId, String courseNo) throws ParseException {
		TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
		teacherEvaluate.setIndexId(indexId);
		teacherEvaluate.setCourseNo(courseNo);
		teacherEvalCourseDao.deleteIndexNoInfo(indexId, courseNo);
	}

	
}
