package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cn.just.course.entity.Student;
import cn.just.course.entity.Teacher;

public interface StudentService {

	/**
	 * 用户登录功能
	 * @param name
	 * @param password
	 * @return
	 * @throws UserNameException
	 * @throws PasswordException
	 */
    Student login(String name,String password) throws UserNameException,PasswordException;
    
    /**
     * 用户注册功能
     * @throws UserNameException 用户名空，或者已经注册
     * @throws PasswordException 密码不一致
     */
    public Student regist(String name,String password,String confirm) throws UserNameException,PasswordException;
    /**
     * 检查是否登录
     * @param studentId
     * @return
     */
    boolean checkId(String studentId);
    /**
     * 查看学生信息
     * @param studentId
     * @return
     * @throws ParseException
     */
    public Student lookStudentInfo(String studentId) throws  ParseException;
    /**
     * 完善学生信息
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
     * 检查密码
     * @param studentId
     * @param oldPwd
     * @return
     * @throws PasswordException
     */
    public Student checkInfo(String studentId, String oldPwd) throws PasswordException;
    /**
     * 更新密码
     * @param studentId
     * @param newPwd
     * @return
     * @throws ParseException
     */
    public Student updateInfo(String studentId,String newPwd)throws  ParseException;
    /**
     * 查看所有的学生信息
     * @return
     * @throws ParseException
     */
    public ArrayList<Student> lookStudentInfo() throws  ParseException;
    /**
     * 删除学生信息
     * @param studentNos
     * @throws ParseException
     */
    public void deleteStudentInfo(List<String> studentNos) throws  ParseException;
}
