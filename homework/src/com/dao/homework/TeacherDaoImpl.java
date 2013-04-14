package com.dao.homework;

import com.bean.homework.Teacher;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class TeacherDaoImpl extends BaseDao implements TeacherDao, PostgreSQL 
{

	public Teacher getTeacherByIdAndPassword(String teacherId, String passwords)
			throws Exception
	{
		String sql = "select * from teacher where teacher_id =? and password=?";
		//System.out.println(studentId + " " + password);
		return esql.query(Teacher.class, sql, teacherId, passwords);	
	}

	public int teacherRegisterInfo(Teacher temp) throws Exception {
		String sql = "insert into teacher(teacher_id, teacher_name, teacher_gender,doamin,mail,password)"
            +" values (?,?,?,?,?,?,?,?)";
//System.out.println(studentId + " " + password);
return esql.update(sql, temp.getTeacherId(),temp.getTeacherName(), temp.getTeacherGender(), temp.getDomain(),temp.getMail(),temp.getPassword());
}
	
	
}