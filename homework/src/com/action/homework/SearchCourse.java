package com.action.homework;

import java.util.List;

import com.bean.homework.BaseCourse;
import com.bean.homework.Course;
import com.dao.DaoManager;
import com.dao.homework.BaseCourseDao;
import com.dao.homework.CourseDao;

public class SearchCourse
{
	public static List<Course> SearchCourse(String student_id)
	{
		DaoManager dm = DaoManager.getInstance();
		CourseDao courseDao = dm.getDao(CourseDao.class);
		List<Course> list = null;
		
		try
		{
			dm.begin();
			System.out.println("001");
			list = courseDao.getAllCourseInfo(student_id);
			System.out.println("002");
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
		return list;
	}
   
	public static List<BaseCourse> TeacherSearchCourse(String teacher_id)
	{
		DaoManager dm = DaoManager.getInstance();
		BaseCourseDao basecourseDao = dm.getDao(BaseCourseDao.class);
		List<BaseCourse> list = null;
		
		try
		{
			dm.begin();
			//System.out.println("001");
			list = basecourseDao.getTeacherAllCourseInfo(teacher_id);
			System.out.println("002");
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
		return list;
	}
	
	public static List<Course> SearchHaveCourse(String student_id)
	{
		DaoManager dm = DaoManager.getInstance();
		CourseDao courseDao = dm.getDao(CourseDao.class);
		List<Course> list = null;
		
		try
		{
			dm.begin();
			list = courseDao.getAllHaveCourseInfo(student_id);
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
		return list;
	}
	
	
	public static List<Course> TeacherSearchHaveCourse(String teacher_id)
	{
		DaoManager dm = DaoManager.getInstance();
		CourseDao courseDao = dm.getDao(CourseDao.class);
		List<Course> list = null;
		
		try
		{
			dm.begin();
			list = courseDao.getAllTeacherHaveCourseInfo(teacher_id);
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
		return list;
	}

}
