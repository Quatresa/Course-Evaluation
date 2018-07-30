package cn.just.course.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import cn.just.course.service.TeacherService;

public class TeaACLFilter implements Filter{
	
	private ServletContext sc;
	private ApplicationContext ctx;
	private TeacherService teacherService;
	
	/**
	 * 过滤器初始化代码
	 */
	public void init(FilterConfig cfg)
		throws ServletException {
		sc=	cfg.getServletContext();
		//获取Spring容器
		ctx=WebApplicationContextUtils.getWebApplicationContext(sc);
		//从容器中获取 UserService 对象
		teacherService=ctx.getBean("teacherService",
				TeacherService.class);
		
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response =(HttpServletResponse) res;
		String path=request.getRequestURI();
		path = path.substring(
			path.indexOf('/', 1));
		
		//System.out.println("trim path:"+path);
		
		if(path.matches(".*/tea_evaluate\\.html$")||path.matches(".*/tea_look_evaluate\\.html$")||path.matches
				(".*/teacher_look_evaluate\\.html$")||path.matches(".*/teacher_manage\\.html$")||
				path.matches(".*/add_tea_info\\.html$")){
			checkLogin(request,response,chain);
			return;
		}
		
		if(path.matches(".(checkinfo).*\\.do$")||path.matches(".(updateinfo).*\\.do$")){
			checkDotDo(request,response,chain);
			return;
		}
		
		chain.doFilter(request, response); 
	}
	private void checkDotDo(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		String teacherId= getCookie(request,"teacherId");
		//System.out.println("userId:"+userId); 
		
		if(teacherService.checkId(teacherId)){
			chain.doFilter(request, response);
			return;
		}
		
		//没有登录时候，返回JSON错误消息
		String json="{\"state\":1,\"message\":\"必须登录！\"}";;
		response.setCharacterEncoding("utf-8");
		response.setContentType(
			"application/json;charset=UTF-8");
		response.getWriter().println(json);
	}
	private String getCookie(HttpServletRequest request, 
			String cookieName) {
		Cookie[] cookies=request.getCookies();
		//如果客户端没有cookie，就会返回null
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookieName.equals(
						cookie.getName())){
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	private void checkLogin(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		//System.out.println("checkLogin");
		//检查是否有cookie 
		//如果没有， 就重定向到log_in.html
		String teacherId= getCookie(request,"teacherId");
		if(teacherService.checkId(teacherId)){
			chain.doFilter(request, response);
			return;
		}
		//重定向到 login.html
		String path=request.getContextPath()+
			"/login.html";
		response.sendRedirect(path);
	}
	
	public void destroy() {
	}
}
