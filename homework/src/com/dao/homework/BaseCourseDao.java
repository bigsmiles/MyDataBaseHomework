package com.dao.homework;

import java.util.List;

import com.bean.homework.BaseCourse;

public interface BaseCourseDao 
{
	public List<BaseCourse> getTeacherAllCourseInfo(String teacher_id) throws Exception;
	//public int courseRegister(String studentid,String courseid,String teacherid) throws Exception;
	//public List<Course> getAllHaveCourseInfo(String student_id) throws Exception;
	//public void courseDelete(String studentid,String courseid) throws Exception;
	
}