package com.action.homework;

import com.bean.homework.Student;
import com.bean.homework.Teacher;
import com.dao.DaoManager;
import com.dao.homework.BaseCourseDao;
import com.dao.homework.CourseDao;
import com.dao.homework.StudentDao;
import com.dao.homework.TeacherDao;

public class RegisterAction 
{
	public int studentRegister(Student tempStudent)
	{
		DaoManager dm = DaoManager.getInstance();
		StudentDao studentDao = dm.getDao(StudentDao.class);
		//Student student = null;
		int x=0;
		
		try
		{
			dm.begin();
			//student = studentDao.studentRegisterInfo(tempStudent);
			x = studentDao.studentRegisterInfo(tempStudent);
			dm.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			dm.end();
		}
		return x;
	}
	
	public int teacherRegister(Teacher tempTeacher)
	{
		DaoManager dm = DaoManager.getInstance();
		TeacherDao teacherDao = dm.getDao(TeacherDao.class);
		//Student student = null;
		int x=0;
		
		try
		{
			dm.begin();
			//student = studentDao.studentRegisterInfo(tempStudent);
			x = teacherDao.teacherRegisterInfo(tempTeacher);
			dm.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			dm.end();
		}
		return x;
	}
	
	public int courseRegister(String studentid,String courseid,String teacherid)
	{
		DaoManager dm = DaoManager.getInstance();
		CourseDao courseDao = dm.getDao(CourseDao.class);
		//Student student = null;
		int x=0;
		
		try
		{
			dm.begin();
			x = courseDao.courseRegister(studentid,courseid,teacherid);
			dm.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			dm.end();
		}
		return x;
	}
 
	public int courseTeacherRegister(String courseid,String coursename,String teacherid,String teachername)
	{
		DaoManager dm = DaoManager.getInstance();
		CourseDao courseDao = dm.getDao(CourseDao.class);
		//Student student = null;
		int x=0;
		
		try
		{
			dm.begin();
			x = courseDao.courseTeacherRegister(courseid,coursename,teacherid,teachername);
			dm.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			dm.end();
		}
		return x;
	}
}
