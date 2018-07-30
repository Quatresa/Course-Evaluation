package cn.just.course.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.just.course.entity.TeacherEvaluate;
import cn.just.course.service.TeaEvalCourseService;
import cn.just.course.util.JsonResult;

@Controller 
@RequestMapping("/teacherEval")
public class TeacherEvalController {

	@Resource
	private TeaEvalCourseService teaEvalCourseService;
	@RequestMapping("/evalInfo.do")
	@ResponseBody
	public JsonResult<List <TeacherEvaluate>> lookEvalInfo(String courseNo){
		List<TeacherEvaluate> teacherEvaluate=new ArrayList<TeacherEvaluate>();
		try {
			teacherEvaluate= teaEvalCourseService.findEvaluateInfoById(courseNo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<List <TeacherEvaluate>>(teacherEvaluate);
	}
	@RequestMapping("/updateEvalInfo.do")
	@ResponseBody
	public JsonResult<TeacherEvaluate> updateInfo(String courseNo, String indexNo, Float weight,Integer indexId){
		   TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
			try {
				teacherEvaluate = teaEvalCourseService.updateEvalInfo(courseNo, indexNo, weight,indexId);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<TeacherEvaluate>(teacherEvaluate);
	}
	
	@RequestMapping("/updateEvalResult.do")	
	@ResponseBody
	public JsonResult<TeacherEvaluate> updateInfo(String courseNo, Integer indexId,Integer score){
		   TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
			try {
				teacherEvaluate = teaEvalCourseService.updateEvalResult(courseNo, indexId, score);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<TeacherEvaluate>(teacherEvaluate);
	}
	@RequestMapping("/preLookIndexInfo.do")	
	@ResponseBody
	public JsonResult<PageInfo<List>> findIndexInfo(@RequestParam(required=true,defaultValue="1") Integer page,
	         @RequestParam(required=false,defaultValue="10") Integer pageSize) throws ParseException {
		PageHelper.startPage(page, pageSize);
	    ArrayList list=new ArrayList();
	    PageInfo<List> indexList=new PageInfo<List>();
		try {
			list=teaEvalCourseService.findIndexInfo();
			indexList=new PageInfo<List>(list);
			//System.out.println(list);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<PageInfo<List>>(indexList);
	}
	@RequestMapping("/lookIndex.do")
	@ResponseBody
	public JsonResult<List> lookIndexInfo(@RequestParam(required=true,defaultValue="1") Integer page,
         @RequestParam(required=false,defaultValue="10") Integer pageSize){
		    PageHelper.startPage(page, pageSize);
		    ArrayList list=new ArrayList();
			try {
				list=teaEvalCourseService.findIndexInfo();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<List>(list);
	}
	@RequestMapping("/prepareLookIndexInfo.do")	
	@ResponseBody
	public JsonResult<PageInfo<List>> findEvalInfoByIndexId(Integer indexId,@RequestParam(required=true,defaultValue="1") Integer page,
	         @RequestParam(required=false,defaultValue="8") Integer pageSize) throws ParseException {
		PageHelper.startPage(page, pageSize);
	    ArrayList list=new ArrayList();
	    PageInfo<List> indexList=new PageInfo<List>();
		try {
			list=teaEvalCourseService.findEvalInfo(indexId);
			indexList=new PageInfo<List>(list);
			//System.out.println(list);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<PageInfo<List>>(indexList);
	}
	@RequestMapping("/lookIndexInfo.do")
	@ResponseBody
	public JsonResult<List> lookIndexDetailInfo(Integer indexId,@RequestParam(required=true,defaultValue="1") Integer page,
         @RequestParam(required=false,defaultValue="8") Integer pageSize){
		    PageHelper.startPage(page, pageSize);
		    ArrayList list=new ArrayList();
			try {
				list=teaEvalCourseService.findEvalInfo(indexId);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<List>(list);
	}
	@RequestMapping("/countIndex.do")	
	@ResponseBody
	public JsonResult<Integer> countIndex() throws ParseException {
		int count=0;
		try {
			count= teaEvalCourseService.countIndexId();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<Integer>(count);
	}
	
	@RequestMapping("/addIndexNoInfo.do")	
	@ResponseBody
	public JsonResult<TeacherEvaluate> addIndexNoInfo(String indexNo){
		   TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
			try {
				teacherEvaluate = teaEvalCourseService.addIndexNoInfo(indexNo);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<TeacherEvaluate>(teacherEvaluate);
	}
	@RequestMapping("/addCourseIndexNoInfo.do")	
	@ResponseBody
	public JsonResult<TeacherEvaluate> saveIndexNoInfo(Integer indexId,String courseNo){
		    TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
		    teacherEvaluate.setIndexId(indexId);
		    teacherEvaluate.setCourseNo(courseNo);
			try {
				teacherEvaluate = teaEvalCourseService.saveIndexInfoNo(teacherEvaluate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<TeacherEvaluate>(teacherEvaluate);
	}
	@RequestMapping("/findIndexIdByNo.do")	
	@ResponseBody
	public JsonResult<TeacherEvaluate>  findIndexInfoByNo(String indexNo) throws ParseException {
		TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
		teacherEvaluate.setIndexNo(indexNo);
		try {
			teacherEvaluate = teaEvalCourseService.findIndexInfoByNo(indexNo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<TeacherEvaluate>(teacherEvaluate);
	}

	@RequestMapping("/deleteIndexInfo.do")	
	@ResponseBody
	public JsonResult<TeacherEvaluate> deleteEvalInfo(Integer indexId, String courseNo) throws ParseException {
		TeacherEvaluate teacherEvaluate=new TeacherEvaluate();
		teacherEvaluate.setIndexId(indexId);
		teacherEvaluate.setCourseNo(courseNo);
		try {
			teaEvalCourseService.deleteEvalInfo(indexId, courseNo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<TeacherEvaluate>(teacherEvaluate);
	}
}
