package cn.just.course.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String studentNo;
	private String studentTell;
	private String studentSex;
	private Date studentBirth;
	private String studentMajor;
	private String studentRealName;
	private String studentId;
    private String studentName;
    private String studentPassword;
    
    
	public Student() {
		
	}
	
	public Student(String studentId, String studentName, String studentPassword) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPassword = studentPassword;
	}

	public Student(String studentNo, String studentTell, String studentSex, Date studentBirth, String studentMajor,
			String studentRealName, String studentId, String studentName, String studentPassword) {
		super();
		this.studentNo = studentNo;
		this.studentTell = studentTell;
		this.studentSex = studentSex;
		this.studentBirth = studentBirth;
		this.studentMajor = studentMajor;
		this.studentRealName = studentRealName;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPassword = studentPassword;
	}

	public String getStudentTell() {
		return studentTell;
	}

	public void setStudentTell(String studentTell) {
		this.studentTell = studentTell;
	}

	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getStudentSex() {
		return studentSex;
	}


	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}


	public Date getStudentBirth() {
		return studentBirth;
	}


	public void setStudentBirth(Date studentBirth) {
		this.studentBirth = studentBirth;
	}


	public String getStudentMajor() {
		return studentMajor;
	}


	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}


	public String getStudentRealName() {
		return studentRealName;
	}


	public void setStudentRealName(String studentRealName) {
		this.studentRealName = studentRealName;
	}


	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentBirth == null) ? 0 : studentBirth.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((studentMajor == null) ? 0 : studentMajor.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + ((studentNo == null) ? 0 : studentNo.hashCode());
		result = prime * result + ((studentPassword == null) ? 0 : studentPassword.hashCode());
		result = prime * result + ((studentRealName == null) ? 0 : studentRealName.hashCode());
		result = prime * result + ((studentSex == null) ? 0 : studentSex.hashCode());
		result = prime * result + ((studentTell == null) ? 0 : studentTell.hashCode());
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
		Student other = (Student) obj;
		if (studentBirth == null) {
			if (other.studentBirth != null)
				return false;
		} else if (!studentBirth.equals(other.studentBirth))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (studentMajor == null) {
			if (other.studentMajor != null)
				return false;
		} else if (!studentMajor.equals(other.studentMajor))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (studentNo == null) {
			if (other.studentNo != null)
				return false;
		} else if (!studentNo.equals(other.studentNo))
			return false;
		if (studentPassword == null) {
			if (other.studentPassword != null)
				return false;
		} else if (!studentPassword.equals(other.studentPassword))
			return false;
		if (studentRealName == null) {
			if (other.studentRealName != null)
				return false;
		} else if (!studentRealName.equals(other.studentRealName))
			return false;
		if (studentSex == null) {
			if (other.studentSex != null)
				return false;
		} else if (!studentSex.equals(other.studentSex))
			return false;
		if (studentTell == null) {
			if (other.studentTell != null)
				return false;
		} else if (!studentTell.equals(other.studentTell))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentTell=" + studentTell + ", studentSex=" + studentSex
				+ ", studentBirth=" + studentBirth + ", studentMajor=" + studentMajor + ", studentRealName="
				+ studentRealName + ", studentId=" + studentId + ", studentName=" + studentName + ", studentPassword="
				+ studentPassword + "]";
	}

    
}
