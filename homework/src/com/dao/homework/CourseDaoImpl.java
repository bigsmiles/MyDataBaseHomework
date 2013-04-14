package com.dao.homework;

import java.util.List;

import com.bean.homework.Course;
import com.bean.homework.Student;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class CourseDaoImpl extends BaseDao implements CourseDao, PostgreSQL 
{

	
	public List<Course> getAllCourseInfo(String student_id) throws Exception  
	{
		String sql = "select * from course where course_id not in (select student_course.course_id"
			        +" from student_course where student_course.student_id=?)";
	   //System.out.println(student_id+"hi!");
       return esql.list(Course.class, sql, student_id);
	}
	public int courseRegister(String studentid,String courseid,String teacherid) throws Exception 
	{
		
		String sql="insert into student_course(student_id,course_id,teacher_id)"
			       +" values(?,?,?)";
		return esql.update(sql, studentid,courseid,teacherid);

	}
	
	public List<Course> getAllHaveCourseInfo(String student_id) throws Exception
	{
		String sql = "select * from course where course_id in (select student_course.course_id"
	        +" from student_course where student_course.student_id=?)";
                return esql.list(Course.class, sql, student_id);
	}
	
	public void courseDelete(String studentid,String courseid) throws Exception 
	{
		String sql = "delete from student_course where student_id = ? and course_id = ?";
		esql.update(sql, studentid,courseid);

	}
	
	public int courseTeacherRegister(String courseid,String coursename,String teacherid,String teachername) throws Exception 
	{
		String sql="insert into course(course_id,course_name,teacher_id,teacher_name)"
			       +" values(?,?,?,?)";
		return esql.update(sql, courseid,coursename,teacherid,teachername);

	}
	
	public List<Course> getAllTeacherHaveCourseInfo(String teacher_id) throws Exception
	{
		String sql = "select * from course where teacher_id =?";
                return esql.list(Course.class, sql, teacher_id);
	}
	
	public void courseTeacherDelete(String teacherid,String courseid) throws Exception 
	{
		/*需要先删掉作业课程表中的信息，这个表示外码已用了course*/
		String sql1 = "delete from homework where teacher_id = ? and course_id = ?";
		esql.update(sql1, teacherid,courseid);
		
		String sql = "delete from course where teacher_id = ? and course_id = ?";
		esql.update(sql, teacherid,courseid);

	}
	
}