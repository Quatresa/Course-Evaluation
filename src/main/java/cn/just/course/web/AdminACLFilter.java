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
import cn.just.course.service.AdminService;

public class AdminACLFilter implements Filter{
	
	private ServletContext sc;
	private ApplicationContext ctx;
	private AdminService adminService;
	
	/**
	 * 过滤器初始化代码
	 */
	public void init(FilterConfig cfg)
		throws ServletException {
 
		sc=	cfg.getServletContext();
		//获取Spring容器
		ctx=WebApplicationContextUtils
			.getWebApplicationContext(sc);
		//从容器中获取 UserService 对象
		adminService=ctx.getBean(
				"adminService",
				AdminService.class);
		
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response =(HttpServletResponse) res;
		String path=request.getRequestURI();
		//System.out.println(path);
		path = path.substring(
			path.indexOf('/', 1));
		
		//System.out.println("trim path:"+path);
		if(path.matches(".*/admin_manage\\.html$")||path.matches(".*/admin_add_course\\.html$")||
				path.matches(".*/admin_change_course\\.html$")||path.matches(".*/admin_delete_course\\.html$")
				||path.matches(".*/admin_look_course\\.html$")||path.matches(".*/admin_modify_course\\.html$")
				||path.matches(".*/admin_student_evaluate\\.html$")){
			checkLogin(request,response,chain);
			return;
		}
		
		if(path.matches(".(checkinfo).*\\.do$")||path.matches(".(updateinfo).*\\.do$")||path.matches(".(lookinfo).*\\.do$")
				||path.matches(".(lookCourseInfo).*\\.do$")){
			checkDotDo(request,response,chain);
			return;
		}
		
		chain.doFilter(request, response); 
	}
	private void checkDotDo(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		String adminId= getCookie(request,"adminId");	
		if(adminService.checkId(adminId)){
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
		String adminId= getCookie(request,"adminId");
		
		if(adminService.checkId(adminId)){
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
