package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cn.just.course.entity.Student;
import cn.just.course.entity.Teacher;

public interface StudentService {

	/**
	 * �û���¼����
	 * @param name
	 * @param password
	 * @return
	 * @throws UserNameException
	 * @throws PasswordException
	 */
    Student login(String name,String password) throws UserNameException,PasswordException;
    
    /**
     * �û�ע�Ṧ��
     * @throws UserNameException �û����գ������Ѿ�ע��
     * @throws PasswordException ���벻һ��
     */
    public Student regist(String name,String password,String confirm) throws UserNameException,PasswordException;
    /**
     * ����Ƿ��¼
     * @param studentId
     * @return
     */
    boolean checkId(String studentId);
    /**
     * �鿴ѧ����Ϣ
     * @param studentId
     * @return
     * @throws ParseException
     */
    public Student lookStudentInfo(String studentId) throws  ParseException;
    /**
     * ����ѧ����Ϣ
     * @param studentNo
     * @param studentName
     * @param studentSex
     * @param studentMajor
     * @param studentTell
     * @param studentBirth
     * @return
     */
    public Student addStudentInfo(String studentId,String studentNo,String studentRealName,String studentSex,String studentMajor,
    		String studentTell,String studentBirth)throws  ParseException;
    /**
     * �������
     * @param studentId
     * @param oldPwd
     * @return
     * @throws PasswordException
     */
    public Student checkInfo(String studentId, String oldPwd) throws PasswordException;
    /**
     * ��������
     * @param studentId
     * @param newPwd
     * @return
     * @throws ParseException
     */
    public Student updateInfo(String studentId,String newPwd)throws  ParseException;
    /**
     * �鿴���е�ѧ����Ϣ
     * @return
     * @throws ParseException
     */
    public ArrayList<Student> lookStudentInfo() throws  ParseException;
    /**
     * ɾ��ѧ����Ϣ
     * @param studentNos
     * @throws ParseException
     */
    public void deleteStudentInfo(List<String> studentNos) throws  ParseException;
}
