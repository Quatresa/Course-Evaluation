package cn.just.course.dao;

import java.util.Map;

import cn.just.course.entity.Admin;
public interface AdminDao {
	void saveAdmin(Admin admin);
	Admin findAdminById(String id);
	Admin findAdminByName(String name);
	int updateAdmin(Map<String, Object> admin);

}
