package com.bean.homework;

import java.util.Date;


public class Homework
{
	private String homeworkId;
	private Date submitDate;
	private Double score;
	private String courseId;
	private String teacherId;
	private String homeworkFilename;
	
	public Homework(){}

	public String getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(String homeworkId) {
		this.homeworkId = homeworkId;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getHomeworkFilename() {
		return homeworkFilename;
	}

	public void setHomeworkFilename(String homeworkFilename) {
		this.homeworkFilename = homeworkFilename;
	}
  
	
	
	
	
	
}