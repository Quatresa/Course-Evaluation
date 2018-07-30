package cn.just.course.entity;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable{

	private static final long serialVersionUID = 1L;
	private String teacherNo;
	private String teacherTell;
	private String teacherSex;
	private Date teacherBirth;
	private String teacherJob;
	private String teacherRealName;
	private String teacherId;
    private String teacherName;
    private String teacherPassword;
	public Teacher() {
	
	}
	  
	public Teacher(String teacherId, String teacherName, String teacherPassword) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherPassword = teacherPassword;
	}

	public Teacher(String teacherNo, String teacherTell, String teacherSex, Date teacherBirth, String teacherJob,
			String teacherRealName, String teacherId, String teacherName, String teacherPassword) {
		super();
		this.teacherNo = teacherNo;
		this.teacherTell = teacherTell;
		this.teacherSex = teacherSex;
		this.teacherBirth = teacherBirth;
		this.teacherJob = teacherJob;
		this.teacherRealName = teacherRealName;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherPassword = teacherPassword;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherTell() {
		return teacherTell;
	}

	public void setTeacherTell(String teacherTell) {
		this.teacherTell = teacherTell;
	}

	public String getTeacherSex() {
		return teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	public Date getTeacherBirth() {
		return teacherBirth;
	}

	public void setTeacherBirth(Date teacherBirth) {
		this.teacherBirth = teacherBirth;
	}

	public String getTeacherJob() {
		return teacherJob;
	}

	public void setTeacherJob(String teacherJob) {
		this.teacherJob = teacherJob;
	}

	public String getTeacherRealName() {
		return teacherRealName;
	}

	public void setTeacherRealName(String teacherRealName) {
		this.teacherRealName = teacherRealName;
	}

	public String getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}


	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherPassword() {
		return teacherPassword;
	}
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teacherJob == null) ? 0 : teacherJob.hashCode());
		result = prime * result + ((teacherBirth == null) ? 0 : teacherBirth.hashCode());
		result = prime * result + ((teacherId == null) ? 0 : teacherId.hashCode());
		result = prime * result + ((teacherName == null) ? 0 : teacherName.hashCode());
		result = prime * result + ((teacherNo == null) ? 0 : teacherNo.hashCode());
		result = prime * result + ((teacherPassword == null) ? 0 : teacherPassword.hashCode());
		result = prime * result + ((teacherRealName == null) ? 0 : teacherRealName.hashCode());
		result = prime * result + ((teacherSex == null) ? 0 : teacherSex.hashCode());
		result = prime * result + ((teacherTell == null) ? 0 : teacherTell.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (teacherJob == null) {
			if (other.teacherJob != null)
				return false;
		} else if (!teacherJob.equals(other.teacherJob))
			return false;
		if (teacherBirth == null) {
			if (other.teacherBirth != null)
				return false;
		} else if (!teacherBirth.equals(other.teacherBirth))
			return false;
		if (teacherId == null) {
			if (other.teacherId != null)
				return false;
		} else if (!teacherId.equals(other.teacherId))
			return false;
		if (teacherName == null) {
			if (other.teacherName != null)
				return false;
		} else if (!teacherName.equals(other.teacherName))
			return false;
		if (teacherNo == null) {
			if (other.teacherNo != null)
				return false;
		} else if (!teacherNo.equals(other.teacherNo))
			return false;
		if (teacherPassword == null) {
			if (other.teacherPassword != null)
				return false;
		} else if (!teacherPassword.equals(other.teacherPassword))
			return false;
		if (teacherRealName == null) {
			if (other.teacherRealName != null)
				return false;
		} else if (!teacherRealName.equals(other.teacherRealName))
			return false;
		if (teacherSex == null) {
			if (other.teacherSex != null)
				return false;
		} else if (!teacherSex.equals(other.teacherSex))
			return false;
		if (teacherTell == null) {
			if (other.teacherTell != null)
				return false;
		} else if (!teacherTell.equals(other.teacherTell))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [teacherNo=" + teacherNo + ", teacherTell=" + teacherTell + ", teacherSex=" + teacherSex
				+ ", teacherBirth=" + teacherBirth + ", studentJob=" + teacherJob + ", teacherRealName="
				+ teacherRealName + ", teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherPassword="
				+ teacherPassword + "]";
	}

}
