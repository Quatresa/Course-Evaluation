package cn.just.course.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cn.just.course.entity.Student;
import cn.just.course.entity.Teacher;

public interface TeacherService {

	/**
	 * 用户登录功能
	 * @param name
	 * @param password
	 * @return
	 * @throws UserNameException
	 * @throws PasswordException
	 */
    Teacher login(String name,String password) throws UserNameException,PasswordException;
    
    /**
     * 用户注册功能
     * @throws UserNameException 用户名空，或者已经注册
     * @throws PasswordException 密码不一致
     */
    public Teacher regist(String name,String password,String confirm) throws UserNameException,PasswordException;
    /**
     * 检查是否登录
     * @param teacherId
     * @return
     */
    boolean checkId(String teacherId);
    /**
     * 查看教师信息
     * @param teacherId
     * @return
     * @throws ParseException
     */
    public Teacher lookTeacherInfo(String teacherId) throws  ParseException;
    /**
     * 完善教师信息
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
     * 检查密码
     * @param teacherId
     * @param oldPwd
     * @return
     * @throws PasswordException
     */
    public Teacher checkInfo(String teacherId, String oldPwd) throws PasswordException;
    /**
     * 更新密码
     * @param teacherId
     * @param newPwd
     * @return
     * @throws ParseException
     */
    public Teacher updateInfo(String teacherId,String newPwd)throws  ParseException;
    /**
     * 查看所有的老师信息
     * @return
     */
    public ArrayList<Teacher> lookTeacherInfo() throws  ParseException;
    /**
     * 删除老师信息
     * @throws ParseException
     */
    public void deleteTeacherInfo(List<String> teacherNos) throws  ParseException;
}
