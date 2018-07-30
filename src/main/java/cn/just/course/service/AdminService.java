package cn.just.course.service;

import java.text.ParseException;
import cn.just.course.entity.Admin;


public interface AdminService {

	/**
	 * �û���¼����
	 * @param name
	 * @param password
	 * @return
	 * @throws UserNameException
	 * @throws PasswordException
	 */
    Admin login(String name,String password) throws UserNameException,PasswordException;
    
    /**
     * �û�ע�Ṧ��
     * @throws UserNameException �û����գ������Ѿ�ע��
     * @throws PasswordException ���벻һ��
     */
    public  Admin regist(String name,String password,String confirm) throws UserNameException,PasswordException;
    /**
     * �������
     * @param adminId
     * @param oldPwd
     * @return
     * @throws PasswordException
     */
    public Admin checkInfo(String adminId, String oldPwd) throws PasswordException;
    /**
     * ��������
     * @param adminId
     * @param newPwd
     * @return
     * @throws ParseException
     */
    public Admin updateInfo(String adminId,String newPwd)throws  ParseException;
    /**
     * ����Ƿ��¼
     * @param adminId
     * @return
     */
    boolean checkId(String adminId);
}

