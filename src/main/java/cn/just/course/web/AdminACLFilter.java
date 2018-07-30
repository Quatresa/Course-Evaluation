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
	 * ��������ʼ������
	 */
	public void init(FilterConfig cfg)
		throws ServletException {
 
		sc=	cfg.getServletContext();
		//��ȡSpring����
		ctx=WebApplicationContextUtils
			.getWebApplicationContext(sc);
		//�������л�ȡ UserService ����
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
		
		//û�е�¼ʱ�򣬷���JSON������Ϣ
		String json="{\"state\":1,\"message\":\"�����¼��\"}";;
		response.setCharacterEncoding("utf-8");
		response.setContentType(
			"application/json;charset=UTF-8");
		response.getWriter().println(json);
	}
	private String getCookie(HttpServletRequest request, 
			String cookieName) {
		Cookie[] cookies=request.getCookies();
		//����ͻ���û��cookie���ͻ᷵��null
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
		//����Ƿ���cookie 
		//���û�У� ���ض���log_in.html
		String adminId= getCookie(request,"adminId");
		
		if(adminService.checkId(adminId)){
			chain.doFilter(request, response);
			return;
		}
		//�ض��� login.html
		String path=request.getContextPath()+
			"/login.html";
		response.sendRedirect(path);
	}
	
	public void destroy() {
	}
}
