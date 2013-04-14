package com.action.homework;

import com.dao.DaoManager;
import com.dao.homework.HomeworkDao;
import com.dao.homework.TeamDao;

public class AddAction 
{
	public boolean addNewHomework(String homeworkid,String courseid,String teacherid)
	{
		DaoManager dm = DaoManager.getInstance();
		HomeworkDao homeworkDao = dm.getDao(HomeworkDao.class);
		int insertRows = 0;
		try
		{
			dm.begin();
			insertRows = homeworkDao.addNewHomework(homeworkid,courseid,teacherid);
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
		
		return (insertRows==0?false:true);
	}
	
	public boolean addTeam(String teamid,String teamname,String teamcour,String teamteacherid,String teammonitorid,String teammonitor)
	{
		DaoManager dm = DaoManager.getInstance();
		TeamDao teamDao = dm.getDao(TeamDao.class);
		int insertRows = 0;
		try
		{
			dm.begin();
			insertRows = teamDao.addTeam(teamid,teamname,teamcour,teamteacherid,teammonitorid,teammonitor);
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
		
		return (insertRows==0?false:true);
	}
	public boolean addStudentToMyTeam(String studentid,String myteamid)
	{
		DaoManager dm = DaoManager.getInstance();
		TeamDao teamDao = dm.getDao(TeamDao.class);
		int insertRows = 0;
		try
		{
			dm.begin();
			insertRows = teamDao.addStudentToMyTeam(studentid,myteamid);
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
		
		return (insertRows==0?false:true);
	}
}
