package com.dao.homework;

import java.util.List;

import com.bean.homework.Course;
import com.bean.homework.Student;

public interface CourseDao 
{
	public List<Course> getAllCourseInfo(String student_id) throws Exception;
	public int courseRegister(String studentid,String courseid,String teacherid) throws Exception;
	public List<Course> getAllHaveCourseInfo(String student_id) throws Exception;
	public void courseDelete(String studentid,String courseid) throws Exception;
	public int courseTeacherRegister(String courseid,String coursename,String teacherid,String teachername) throws Exception;
	public List<Course> getAllTeacherHaveCourseInfo(String teacher_id) throws Exception;
	public void courseTeacherDelete(String teacherid,String courseid) throws Exception;
}