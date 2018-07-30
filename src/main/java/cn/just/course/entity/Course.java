package cn.just.course.entity;

import java.io.Serializable;

public class Course implements Serializable{

	private static final long serialVersionUID = 1L;

	private String courseNo;
	private String courseName;
	private String courseProperties;
	private Float courseScore;
	private String courseHour;
	
	public Course() {
		super();
	}

	public Course(String courseNo, String courseName, String courseProperties, Float courseScore,
			String courseHour) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.courseProperties = courseProperties;
		this.courseScore = courseScore;
		this.courseHour = courseHour;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseProperties() {
		return courseProperties;
	}

	public void setCourseProperties(String courseProperties) {
		this.courseProperties = courseProperties;
	}

	public Float getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(Float courseScore) {
		this.courseScore = courseScore;
	}

	public String getCourseHour() {
		return courseHour;
	}

	public void setCourseHour(String courseHour) {
		this.courseHour = courseHour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseHour == null) ? 0 : courseHour.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((courseNo == null) ? 0 : courseNo.hashCode());
		result = prime * result + ((courseProperties == null) ? 0 : courseProperties.hashCode());
		result = prime * result + ((courseScore == null) ? 0 : courseScore.hashCode());
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
		Course other = (Course) obj;
		if (courseHour == null) {
			if (other.courseHour != null)
				return false;
		} else if (!courseHour.equals(other.courseHour))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (courseNo == null) {
			if (other.courseNo != null)
				return false;
		} else if (!courseNo.equals(other.courseNo))
			return false;
		if (courseProperties == null) {
			if (other.courseProperties != null)
				return false;
		} else if (!courseProperties.equals(other.courseProperties))
			return false;
		if (courseScore == null) {
			if (other.courseScore != null)
				return false;
		} else if (!courseScore.equals(other.courseScore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", courseName=" + courseName + ", courseProperties=" + courseProperties
				+ ", courseScore=" + courseScore + ", courseHour=" + courseHour + "]";
	}
	
}
