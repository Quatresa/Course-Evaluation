package cn.just.course.entity;

import java.io.Serializable;

public class StudentEvaluate implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer studentEvalId;
	private String courseNo;
	private String options;
	private Integer optionValue;
	private String suggestions;
	public StudentEvaluate() {
		super();
	}
	

	public StudentEvaluate(Integer studentEvalId, String courseNo, String options, Integer optionValue,
			String suggestions) {
		super();
		this.studentEvalId = studentEvalId;
		this.courseNo = courseNo;
		this.options = options;
		this.optionValue = optionValue;
		this.suggestions = suggestions;
	}
  
	public Integer getStudentEvalId() {
		return studentEvalId;
	}

	public void setStudentEvalId(Integer studentEvalId) {
		this.studentEvalId = studentEvalId;
	}


	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}


	public String getOptions() {
		return options;
	}


	public void setOptions(String options) {
		this.options = options;
	}


	public Integer getOptionValue() {
		return optionValue;
	}


	public void setOptionValue(Integer optionValue) {
		this.optionValue = optionValue;
	}


	public String getSuggestions() {
		return suggestions;
	}


	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseNo == null) ? 0 : courseNo.hashCode());
		result = prime * result + ((optionValue == null) ? 0 : optionValue.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result + ((studentEvalId == null) ? 0 : studentEvalId.hashCode());
		result = prime * result + ((suggestions == null) ? 0 : suggestions.hashCode());
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
		StudentEvaluate other = (StudentEvaluate) obj;
		if (courseNo == null) {
			if (other.courseNo != null)
				return false;
		} else if (!courseNo.equals(other.courseNo))
			return false;
		if (optionValue == null) {
			if (other.optionValue != null)
				return false;
		} else if (!optionValue.equals(other.optionValue))
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (studentEvalId == null) {
			if (other.studentEvalId != null)
				return false;
		} else if (!studentEvalId.equals(other.studentEvalId))
			return false;
		if (suggestions == null) {
			if (other.suggestions != null)
				return false;
		} else if (!suggestions.equals(other.suggestions))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "StudentEvaluate [studentEvalId=" + studentEvalId + ", courseNo=" + courseNo + ", options=" + options
				+ ", optionValue=" + optionValue + ", suggestions=" + suggestions + "]";
	}

    
}
