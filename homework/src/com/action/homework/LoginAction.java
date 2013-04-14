package com.action.homework;

import com.bean.homework.Student;
import com.bean.homework.Teacher;
import com.dao.DaoManager;
import com.dao.homework.StudentDao;
import com.dao.homework.TeacherDao;

public class LoginAction 
{
	public Student studentLogin(String studentId, String password)
	{
		DaoManager dm = DaoManager.getInstance();
		StudentDao studentDao = dm.getDao(StudentDao.class);
		Student student = null;
		
		try
		{
			dm.begin();
			System.out.println(studentId);
			student = studentDao.getMemberByMemberNoAndPassword(studentId, password);
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
		return student;
	}
	
	public Teacher teacherLogin(String teacherId, String passwords)
	{
		DaoManager dm = DaoManager.getInstance();
		TeacherDao teacherDao = dm.getDao(TeacherDao.class);
		Teacher teacher = null;
		
		try
		{
			dm.begin();
			System.out.println(teacherId);
			teacher = teacherDao.getTeacherByIdAndPassword(teacherId, passwords);
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
		return teacher;
	}
}
