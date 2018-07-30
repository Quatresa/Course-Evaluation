package cn.just.course.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.just.course.entity.Course;
import cn.just.course.entity.StudentEvaluate;
import cn.just.course.service.StuEvalCourseService;
import cn.just.course.util.JsonResult;

@Controller 
@RequestMapping("/studentEval")
public class StudentEvalController {

	@Resource
	private StuEvalCourseService stuEvalCourseService;	
	@RequestMapping("/lookinfo.do")
	@ResponseBody
	public JsonResult<List<StudentEvaluate>> lookStuEvaluateInfo(String courseNo){
		List<StudentEvaluate> studentEvaluate=new ArrayList<StudentEvaluate>();
		try {
			studentEvaluate = stuEvalCourseService.lookStuEvaluateInfo(courseNo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<List<StudentEvaluate>>(studentEvaluate);
	}
	@RequestMapping("/updateEvalInfo.do")
	@ResponseBody
	public JsonResult<StudentEvaluate> updateEvalInfo(Integer studentEvalId,String courseNo,String options){
		    StudentEvaluate studentEvaluate=new StudentEvaluate();
			try {
				studentEvaluate = stuEvalCourseService.updateEvalInfo(studentEvalId,courseNo, options);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<StudentEvaluate>(studentEvaluate);
	}
	@RequestMapping("/updateEvalResultInfo.do")
	@ResponseBody
	public JsonResult<StudentEvaluate> updateEvalResultInfo(Integer studentEvalId,String courseNo,Integer optionValue,
			String suggestions){
		    StudentEvaluate studentEvaluate=new StudentEvaluate();
			try {
				studentEvaluate = stuEvalCourseService.updateEvalResultInfo(studentEvalId,courseNo,optionValue,suggestions);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<StudentEvaluate>(studentEvaluate);
	}
}
