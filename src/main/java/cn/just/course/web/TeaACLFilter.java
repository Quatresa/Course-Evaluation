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
	 * ��������ʼ������
	 */
	public void init(FilterConfig cfg)
		throws ServletException {
		sc=	cfg.getServletContext();
		//��ȡSpring����
		ctx=WebApplicationContextUtils.getWebApplicationContext(sc);
		//�������л�ȡ UserService ����
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
		String teacherId= getCookie(request,"teacherId");
		if(teacherService.checkId(teacherId)){
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
