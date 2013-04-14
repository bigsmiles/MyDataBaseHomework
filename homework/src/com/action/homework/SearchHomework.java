package com.action.homework;

import java.util.List;

import com.bean.homework.Homework;
import com.bean.homework.StudentHomework;
import com.bean.homework.TeamHomework;
import com.dao.DaoManager;
import com.dao.homework.HomeworkDao;

public class SearchHomework
{
	public static List<Homework> SearchHomework(String courseid,String teacherid)
	{
		DaoManager dm = DaoManager.getInstance();
		HomeworkDao homeworkDao = dm.getDao(HomeworkDao.class);
		List<Homework> list = null;
		
		try
		{
			dm.begin();
			list = homeworkDao.getCourseHomeworkInfo(courseid,teacherid);
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
   
	public static List<StudentHomework> SearchHomeworkByPerson(String courseid,String teacherid,String homeworkid)
	{
		DaoManager dm = DaoManager.getInstance();
		HomeworkDao homeworkDao = dm.getDao(HomeworkDao.class);
		List<StudentHomework> list = null;
		
		try
		{
			dm.begin();
			list = homeworkDao.getHomeworkInfoByPerson(courseid,teacherid,homeworkid);
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
	
	public static List<TeamHomework> SearchHomeworkByTeam(String courseid,String teacherid,String homeworkid)
	{
		DaoManager dm = DaoManager.getInstance();
		HomeworkDao homeworkDao = dm.getDao(HomeworkDao.class);
		List<TeamHomework> list = null;
		
		try
		{
			dm.begin();
			list = homeworkDao.getHomeworkInfoByTeam(courseid,teacherid,homeworkid);
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
