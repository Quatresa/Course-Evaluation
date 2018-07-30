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
			//������������ĺ�����
			if(name==null||name.trim().isEmpty()){
				throw new UserNameException("���ֲ���Ϊ��");
			}
			String reg="^\\w{3,10}$";
			if(!name.matches(reg)){
				throw new UserNameException("���ֲ����Ϲ淶");
			}
			if(password==null||password.trim().isEmpty()){
				throw new PasswordException("���벻��Ϊ��");
			}
			if(!password.matches(reg)){
				throw new PasswordException("���벻���Ϲ淶");
			}
			//��ѯ�û�����
			Admin admin=adminDao.findAdminByName(name);
			if(admin==null){
				throw new UserNameException("�û�������");
			}
			if(admin.getAdminPassword().equals(password)){
				//ҵ����
				//��¼�ɹ��������û���Ϣ
				return admin;
			}
			throw new PasswordException("�������");
	}

	public Admin regist(String name,String password, String confirm)
			throws UserNameException, PasswordException {
		if(name==null||name.trim().isEmpty()){
			throw new UserNameException("�û�������Ϊ��");
		}
		String reg="^\\w{3,10}$";
		if(!name.matches(reg)){
			throw new UserNameException("�û������Ϲ���");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("���벻��Ϊ��");
		}
		password=password.trim();
		if(!password.matches(reg)){
			throw new PasswordException("���벻�Ϲ���");
		}
		
		if(!password.equals(confirm)){
			throw new PasswordException("ȷ�����벻һ��");
		}
		name=name.trim();
		//�����û����Ƿ��ظ���
		Admin one=adminDao.findAdminByName(name);
		if(one!=null){
			throw new UserNameException("��ע��");
		}
		//name,password
		//UUID����������Զ���ظ���ID
		String id=UUID.randomUUID().toString();
		Admin admin=new Admin(id,name,password);
		System.out.println(admin);
		adminDao.saveAdmin(admin);
		return admin;
	}
	
	public Admin checkInfo(String adminId, String oldPwd) throws PasswordException {
		//��ѯ�û�����
		Admin admin=adminDao.findAdminById(adminId);
		if(admin.getAdminPassword().equals(oldPwd)){
			//ҵ����
			//��¼�ɹ��������û���Ϣ
			return admin;
		}
		throw new PasswordException("�������");
}

	public Admin updateInfo(String adminId, String newPwd) throws ParseException {
        //��ѯ�û�����
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
