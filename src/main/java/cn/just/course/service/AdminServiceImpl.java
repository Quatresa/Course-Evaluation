package cn.just.course.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.just.course.dao.AdminDao;
import cn.just.course.entity.Admin;
@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	public Admin login(String name, String password) throws UserNameException, PasswordException {
			//检验输入参数的合理性
			if(name==null||name.trim().isEmpty()){
				throw new UserNameException("名字不能为空");
			}
			String reg="^\\w{3,10}$";
			if(!name.matches(reg)){
				throw new UserNameException("名字不符合规范");
			}
			if(password==null||password.trim().isEmpty()){
				throw new PasswordException("密码不能为空");
			}
			if(!password.matches(reg)){
				throw new PasswordException("密码不符合规范");
			}
			//查询用户数据
			Admin admin=adminDao.findAdminByName(name);
			if(admin==null){
				throw new UserNameException("用户名错误");
			}
			if(admin.getAdminPassword().equals(password)){
				//业务处理
				//登录成功，返回用户信息
				return admin;
			}
			throw new PasswordException("密码错误");
	}

	public Admin regist(String name,String password, String confirm)
			throws UserNameException, PasswordException {
		if(name==null||name.trim().isEmpty()){
			throw new UserNameException("用户名不能为空");
		}
		String reg="^\\w{3,10}$";
		if(!name.matches(reg)){
			throw new UserNameException("用户名不合规则");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		password=password.trim();
		if(!password.matches(reg)){
			throw new PasswordException("密码不合规则");
		}
		
		if(!password.equals(confirm)){
			throw new PasswordException("确认密码不一致");
		}
		name=name.trim();
		//检验用户名是否重复？
		Admin one=adminDao.findAdminByName(name);
		if(one!=null){
			throw new UserNameException("已注册");
		}
		//name,password
		//UUID用于生产永远不重复的ID
		String id=UUID.randomUUID().toString();
		Admin admin=new Admin(id,name,password);
		System.out.println(admin);
		adminDao.saveAdmin(admin);
		return admin;
	}
	
	public Admin checkInfo(String adminId, String oldPwd) throws PasswordException {
		//查询用户数据
		Admin admin=adminDao.findAdminById(adminId);
		if(admin.getAdminPassword().equals(oldPwd)){
			//业务处理
			//登录成功，返回用户信息
			return admin;
		}
		throw new PasswordException("密码错误");
}

	public Admin updateInfo(String adminId, String newPwd) throws ParseException {
        //查询用户数据
		Admin admin=new Admin();
		admin.setAdminId(adminId);
		admin.setAdminPassword(newPwd);;
	    Map<String, Object> data=new HashMap<String, Object>();
	    data.put("adminId", admin.getAdminId());
	    data.put("adminPassword", admin.getAdminPassword());
	    adminDao.updateAdmin(data);
		return admin;
	}

	public boolean checkId(String adminId) {
		if(adminId==null || adminId.trim().isEmpty()){
			return false;
		}
		Admin admin=adminDao.findAdminById(adminId);
		if(admin==null){
			return false; 
		}
		return true;
	}

}
