package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cn.just.course.entity.Student;
import cn.just.course.entity.Teacher;

public interface TeacherService {

	/**
	 * �û���¼����
	 * @param name
	 * @param password
	 * @return
	 * @throws UserNameException
	 * @throws PasswordException
	 */
    Teacher login(String name,String password) throws UserNameException,PasswordException;
    
    /**
     * �û�ע�Ṧ��
     * @throws UserNameException �û����գ������Ѿ�ע��
     * @throws PasswordException ���벻һ��
     */
    public Teacher regist(String name,String password,String confirm) throws UserNameException,PasswordException;
    /**
     * ����Ƿ��¼
     * @param teacherId
     * @return
     */
    boolean checkId(String teacherId);
    /**
     * �鿴��ʦ��Ϣ
     * @param teacherId
     * @return
     * @throws ParseException
     */
    public Teacher lookTeacherInfo(String teacherId) throws  ParseException;
    /**
     * ���ƽ�ʦ��Ϣ
     * @param teacherId
     * @param teacherNo
     * @param teacherRealName
     * @param teacherSex
     * @param teacherJob
     * @param teacherTell
     * @param teacherBirth
     * @return
     * @throws ParseException
     */
    public Teacher addTeacherInfo(String teacherId,String teacherNo,String teacherRealName,String teacherSex,String teacherJob,
    		String teacherTell,String teacherBirth)throws  ParseException;
    /**
     * �������
     * @param teacherId
     * @param oldPwd
     * @return
     * @throws PasswordException
     */
    public Teacher checkInfo(String teacherId, String oldPwd) throws PasswordException;
    /**
     * ��������
     * @param teacherId
     * @param newPwd
     * @return
     * @throws ParseException
     */
    public Teacher updateInfo(String teacherId,String newPwd)throws  ParseException;
    /**
     * �鿴���е���ʦ��Ϣ
     * @return
     */
    public ArrayList<Teacher> lookTeacherInfo() throws  ParseException;
    /**
     * ɾ����ʦ��Ϣ
     * @throws ParseException
     */
    public void deleteTeacherInfo(List<String> teacherNos) throws  ParseException;
}
