package cn.just.course.entity;

import java.io.Serializable;

public class TeacherEvaluate implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String courseNo;
	private String indexNo;
	private Float weight;
	private Integer indexId;
	private Integer score;
	private String courseName;
	public TeacherEvaluate() {
		super();
	}

	public TeacherEvaluate(String courseNo, String indexNo, Float weight, Integer indexId,
			Integer score, String courseName) {
		super();
		this.courseNo = courseNo;
		this.indexNo = indexNo;
		this.weight = weight;
		this.indexId = indexId;
		this.score = score;
		this.courseName = courseName;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getIndexNo() {
		return indexNo;
	}
	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	
	public Integer getIndexId() {
		return indexId;
	}

	public void setIndexId(Integer indexId) {
		this.indexId = indexId;
	}
   
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	

	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((courseNo == null) ? 0 : courseNo.hashCode());
		result = prime * result + ((indexId == null) ? 0 : indexId.hashCode());
		result = prime * result + ((indexNo == null) ? 0 : indexNo.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		TeacherEvaluate other = (TeacherEvaluate) obj;
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
		if (indexId == null) {
			if (other.indexId != null)
				return false;
		} else if (!indexId.equals(other.indexId))
			return false;
		if (indexNo == null) {
			if (other.indexNo != null)
				return false;
		} else if (!indexNo.equals(other.indexNo))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeacherEvaluate [courseNo=" + courseNo + ", indexNo=" + indexNo
				+ ", weight=" + weight + ", indexId=" + indexId + ", score=" + score + ", courseName=" + courseName
				+ "]";
	}

}
