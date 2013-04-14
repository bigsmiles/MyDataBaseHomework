package com.dao.homework;


import com.bean.homework.Student;
import com.bean.homework.Teacher;


public interface TeacherDao 
{
	public Teacher getTeacherByIdAndPassword(String teacherId, String passwords) throws Exception;
	public int teacherRegisterInfo(Teacher temp) throws Exception;

}
