package com.action.homework;

import java.util.List;

import com.bean.homework.Student;
import com.bean.homework.Team;
import com.dao.DaoManager;
import com.dao.homework.StudentDao;

public class SearchStudentInfo
{
	public List<Student> searchStudentInfo(String student_id)
	{
		DaoManager dm = DaoManager.getInstance();
		StudentDao studentDao = dm.getDao(StudentDao.class);
		List<Student> list = null;
		
		try
		{
			dm.begin();
			list = studentDao.getStudentAllInfo(student_id);
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

	public List<Team> searchStudentTeamInfo(String student_id)
	{
		DaoManager dm = DaoManager.getInstance();
		StudentDao studentDao = dm.getDao(StudentDao.class);
		List<Team> list = null;
		
		try
		{
			dm.begin();
			list = studentDao.getStudentTeamInfo(student_id);
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
		
	       /*Iterator it = list.iterator();
	   	while (it.hasNext())
	   	{
	   		Team teams = (Team)it.next();	
	   		
	   		System.out.println(teams.getTeamId()+"haha");
	   	}
	   	*/
		return list;
	}
	
	public List<Student> searchStudentOnCourse(String course_id,String teacher_id)
	{
		DaoManager dm = DaoManager.getInstance();
		StudentDao studentDao = dm.getDao(StudentDao.class);
		List<Student> list = null;
		
		try
		{
			dm.begin();
			list = studentDao.getStudentOnCourse(course_id,teacher_id);
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
	
	public Team studentIsMonitor(String studentid,String courseid,String teacherid)
	{
		DaoManager dm = DaoManager.getInstance();
		StudentDao studentDao = dm.getDao(StudentDao.class);
		//Student student = null;
		int x=0;
		Team temp=null;
		try
		{
			dm.begin();
			//student = studentDao.studentRegisterInfo(tempStudent);
			 temp=studentDao.studentIsMonitor(studentid,courseid,teacherid);
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
		return temp;
	}
	
	public List<Student> searchTeamInfo(String teamid,String monitorid)
	{
		DaoManager dm = DaoManager.getInstance();
		StudentDao studentDao = dm.getDao(StudentDao.class);
		List<Student> list = null;
		
		try
		{
			dm.begin();
			list = studentDao.getTeamMember(teamid,monitorid);
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
