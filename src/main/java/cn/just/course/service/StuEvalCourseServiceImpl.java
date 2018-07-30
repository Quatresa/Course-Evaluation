package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.just.course.dao.StudentEvalCourseDao;
import cn.just.course.entity.StudentEvaluate;
@Service("stuEvalCourseService")
public class StuEvalCourseServiceImpl implements StuEvalCourseService{

	@Autowired
	private StudentEvalCourseDao studentEvalCourseDao;
	public List<StudentEvaluate> lookStuEvaluateInfo(String courseNo) throws ParseException {
		List<StudentEvaluate> studentEvaluate=new ArrayList<StudentEvaluate>();
		studentEvaluate=studentEvalCourseDao.findEvaluateInfoById(courseNo);
		return studentEvaluate;
	}
	public StudentEvaluate updateEvalInfo(Integer studentEvalId,String courseNo, String options) throws ParseException {
		StudentEvaluate studentEvaluate=new StudentEvaluate();
		studentEvaluate.setStudentEvalId(studentEvalId);
		studentEvaluate.setCourseNo(courseNo);
		studentEvaluate.setOptions(options);
	    Map<String, Object> data=new HashMap<String, Object>();
	    data.put("studentEvalId", studentEvalId);
	    data.put("courseNo", courseNo);
	    data.put("options", options);
	    studentEvalCourseDao.updateEvalInfo(data);
		return studentEvaluate;
	}
	public StudentEvaluate updateEvalResultInfo(Integer studentEvalId, String courseNo, Integer optionValue,
			String suggestions)throws ParseException {
		StudentEvaluate studentEvaluate=new StudentEvaluate();
		studentEvaluate.setStudentEvalId(studentEvalId);
		studentEvaluate.setCourseNo(courseNo);
		studentEvaluate.setOptionValue(optionValue);
		studentEvaluate.setSuggestions(suggestions);
	    Map<String, Object> data=new HashMap<String, Object>();
	    data.put("studentEvalId", studentEvalId);
	    data.put("courseNo", courseNo);
	    data.put("optionValue", optionValue);
	    data.put("suggestions", suggestions);
	    studentEvalCourseDao.updateEvalResultInfo(data);
		return studentEvaluate;
	}

}
