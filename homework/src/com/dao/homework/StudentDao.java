package com.dao.homework;

import java.util.List;

import com.bean.homework.Student;
import com.bean.homework.Team;


public interface StudentDao 
{
	public Student getMemberByMemberNoAndPassword(String studentId, String password) throws Exception;
	public List<Student> getStudentAllInfo(String student_id) throws Exception;
	public int studentRegisterInfo(Student temp) throws Exception;
	public List<Team> getStudentTeamInfo(String student_id) throws Exception;
	public List<Student> getStudentOnCourse(String course_id,String teacher_id) throws Exception;
	public Team studentIsMonitor(String studentid,String courseid,String teacherid)throws Exception;
	public List<Student> getTeamMember(String teamid,String monitorid) throws Exception;

}
