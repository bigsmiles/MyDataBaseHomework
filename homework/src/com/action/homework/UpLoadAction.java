package com.action.homework;

import com.dao.DaoManager;
import com.dao.homework.HomeworkDao;

public class UpLoadAction
{
	public void upLoadHomework(String homeworkid,String courseid,String teacherid, String filename)
	{
		DaoManager dm = DaoManager.getInstance();
		HomeworkDao homeworkDao = dm.getDao(HomeworkDao.class);
		//System.out.println("Callnumber:" + callnumber +", Filename:" + filename);	
		try
		{
			dm.begin();
			homeworkDao.upLoadHomeworkFilename(homeworkid,courseid,teacherid, filename);
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
		return ;
	}
	public void upLoadHomeworkByPerson(String studentid,String homeworkid,String courseid,String teacherid, String filename)
	{
		DaoManager dm = DaoManager.getInstance();
		HomeworkDao homeworkDao = dm.getDao(HomeworkDao.class);
		//System.out.println("Callnumber:" + callnumber +", Filename:" + filename);	
		try
		{
			dm.begin();
			homeworkDao.upLoadHomeworkFilenameByPerson(studentid,homeworkid,courseid,teacherid, filename);
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
		return ;
	}
	
	public void upLoadHomeworkByTeam(String teamid,String homeworkid,String courseid,String teacherid, String filename)
	{
		DaoManager dm = DaoManager.getInstance();
		HomeworkDao homeworkDao = dm.getDao(HomeworkDao.class);
		//System.out.println("Callnumber:" + callnumber +", Filename:" + filename);	
		try
		{
			dm.begin();
			homeworkDao.upLoadHomeworkFilenameByTeam(teamid,homeworkid,courseid,teacherid, filename);
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
		return ;
	}

}
