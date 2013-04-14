package com.action.homework;

import com.bean.homework.Student;
import com.dao.DaoManager;
import com.dao.homework.CourseDao;
import com.dao.homework.StudentDao;
import com.dao.homework.TeamDao;

public class DeleteAction 
{
	public void courseDelete(String studentid,String courseid)
	{
		DaoManager dm = DaoManager.getInstance();
		CourseDao courseDao = dm.getDao(CourseDao.class);
		//Student student = null;
		int x=0;
		
		try
		{
			dm.begin();
			//student = studentDao.studentRegisterInfo(tempStudent);
			 courseDao.courseDelete(studentid,courseid);
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
		//return x;
	}
   
	public void courseTeacherDelete(String teacherid,String courseid)
	{
		DaoManager dm = DaoManager.getInstance();
		CourseDao courseDao = dm.getDao(CourseDao.class);
		//Student student = null;
		int x=0;
		
		try
		{
			dm.begin();
			//student = studentDao.studentRegisterInfo(tempStudent);
			 courseDao.courseTeacherDelete(teacherid,courseid);
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
		//return x;
	}
	public void teamMemberDelete(String teamid,String studentid)
	{
		DaoManager dm = DaoManager.getInstance();
		TeamDao teamDao = dm.getDao(TeamDao.class);
		//Student student = null;
		int x=0;
		
		try
		{
			dm.begin();
			//student = studentDao.studentRegisterInfo(tempStudent);
			 teamDao.teamMemberDelete(teamid,studentid);
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
		//return x;
	}
	
	public void teamAllDelete1(String teamid)
	{
		DaoManager dm = DaoManager.getInstance();
		TeamDao teamDao = dm.getDao(TeamDao.class);
		//Student student = null;
		int x=0;
		
		try
		{
			dm.begin();
			//student = studentDao.studentRegisterInfo(tempStudent);
			 teamDao.teamAllDelete1(teamid);
			 //teamDao.teamAllDelete2(teamid);
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
		//return x;
	}


  public void teamAllDelete2(String teamid)
{
	DaoManager dm = DaoManager.getInstance();
	TeamDao teamDao = dm.getDao(TeamDao.class);
	//Student student = null;
	int x=0;
	
	try
	{
		dm.begin();
		//student = studentDao.studentRegisterInfo(tempStudent);
		 //teamDao.teamAllDelete1(teamid);
		 teamDao.teamAllDelete2(teamid);
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
	//return x;
}
  
}
