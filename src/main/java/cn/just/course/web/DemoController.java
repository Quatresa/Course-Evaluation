package cn.just.course.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
	@RequestMapping("/hello.do")
	@ResponseBody
	public Object hello(){
        return 
            new String[]{"Hello", "World!"};
    }
}
