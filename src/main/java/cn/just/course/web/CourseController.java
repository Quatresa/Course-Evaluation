package cn.just.course.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/*import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;*/
import cn.just.course.entity.Course;
import cn.just.course.service.CourseService;
import cn.just.course.util.JsonResult;

@Controller 
@RequestMapping("/course")
public class CourseController extends AbstractController{
	@Resource
	private CourseService courseService;
	
	@RequestMapping("/addinfo.do")
	@ResponseBody
	public JsonResult<Course> addInfo(String courseNo,String courseName,String courseProperties,
			String courseHour,Float courseScore){
		    Course course=new Course();
			try {
				course = courseService.addCourseInfo(courseNo, courseName, courseProperties,
						courseHour, courseScore);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<Course>(course);
	}
	@RequestMapping("/prepareCourseInfo.do")
	@ResponseBody
	public JsonResult<PageInfo<List>> prepareCourseInfo(@RequestParam(required=true,defaultValue="1") Integer page,
         @RequestParam(required=false,defaultValue="12") Integer pageSize){
		    PageHelper.startPage(page, pageSize);
		    ArrayList list=new ArrayList();
		    PageInfo<List> courseList=new PageInfo<List>();
			try {
				 list=courseService.lookCourseInfo();
				 courseList=new PageInfo<List>(list);
				 
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<PageInfo<List>>(courseList);
	}
	@RequestMapping("/lookCourseInfo.do")
	@ResponseBody
	public JsonResult<List> lookCourseInfo(@RequestParam(required=true,defaultValue="1") Integer page,
         @RequestParam(required=false,defaultValue="10") Integer pageSize){
		    PageHelper.startPage(page, pageSize);
		    ArrayList list=new ArrayList();
			try {
				 list=courseService.lookCourseInfo();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<List>(list);
	}
	
	@RequestMapping("/deleteCourseInfo.do")
	@ResponseBody
	public JsonResult<ArrayList> deleteCourseInfo(String courseNos){
		String courseno1;
		int start=courseNos.indexOf("[")+1;
		int end=courseNos.indexOf("]");
		courseno1=courseNos.substring(start,end);
		List courseNoList=new ArrayList();
	    String[] courseNo2=courseno1.split(",");
	    courseNoList=Arrays.asList(courseNo2);
		try {
			courseService.deleteCourseInfo(courseNoList);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<ArrayList>();
	}
	@RequestMapping("/lookinfo.do")
	@ResponseBody
	public JsonResult<Course> lookInfo(String courseNo){
		Course course=new Course();
		try {
			course = courseService.lookOneCourseInfo(courseNo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new JsonResult<Course>(course);
	}
	@RequestMapping("/updateinfo.do")
	@ResponseBody
	public JsonResult<Course> updateInfo(String courseNo,String courseName,String courseProperties,String courseHour,
			Float courseScore){
		    Course course=new Course();
			try {
				course = courseService.updateCourseInfo(courseNo,courseName,courseProperties,courseHour,courseScore);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new JsonResult<Course>(course);
	}

}
