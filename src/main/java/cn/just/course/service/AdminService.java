package cn.just.course.service;

import java.text.ParseException;
import cn.just.course.entity.Admin;


public interface AdminService {

	/**
	 * 用户登录功能
	 * @param name
	 * @param password
	 * @return
	 * @throws UserNameException
	 * @throws PasswordException
	 */
    Admin login(String name,String password) throws UserNameException,PasswordException;
    
    /**
     * 用户注册功能
     * @throws UserNameException 用户名空，或者已经注册
     * @throws PasswordException 密码不一致
     */
    public  Admin regist(String name,String password,String confirm) throws UserNameException,PasswordException;
    /**
     * 检查密码
     * @param adminId
     * @param oldPwd
     * @return
     * @throws PasswordException
     */
    public Admin checkInfo(String adminId, String oldPwd) throws PasswordException;
    /**
     * 更新密码
     * @param adminId
     * @param newPwd
     * @return
     * @throws ParseException
     */
    public Admin updateInfo(String adminId,String newPwd)throws  ParseException;
    /**
     * 检查是否登录
     * @param adminId
     * @return
     */
    boolean checkId(String adminId);
}

