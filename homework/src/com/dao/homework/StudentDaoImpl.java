package com.dao.homework;

import java.util.Iterator;
import java.util.List;

import com.bean.homework.Student;
import com.bean.homework.Team;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class StudentDaoImpl extends BaseDao implements StudentDao, PostgreSQL 
{
	public Student getMemberByMemberNoAndPassword(String studentId, String password) throws Exception 
	{
		String sql = "select * from student where student_id =? and password=?";
		//System.out.println(studentId + " " + password);
		return esql.query(Student.class, sql, studentId, password);
	}
	
	public List<Student> getStudentAllInfo(String student_id) throws Exception 
	{
		/*String sql = "select t.callnumber, t.isbn, t.name, t.author, t.publisher, t.price, t.cover_filename, count(b.book_id) as amount "
					+ "from title t left outer join book b on t.callnumber = b.callnumber "
					+ "group by t.callnumber, t.isbn, t.name, t.author, t.publisher, t.price, t.cover_filename";
					*/
		
		 String sql = "select student_id,student_name,student_gender,grade,classes,student_sdept,mail"
			          +" from student"
			          +" where student_id=?";
			//System.out.println(student_id+"hello!");
		return esql.list(Student.class, sql, student_id);
	}
	
	public int studentRegisterInfo(Student temp) throws Exception
	{
		String sql = "insert into student(student_id, student_name, student_gender, grade, classes,student_sdept,mail,password)"
		             +" values (?,?,?,?,?,?,?,?)";
		//System.out.println(studentId + " " + password);
		return esql.update(sql, temp.getStudentId(),temp.getStudentName(), temp.getStudentGender(), temp.getGrade(), temp.getClasses(), temp.getStudentSdept(),temp.getMail(),temp.getPassword());
	}
	
	public List<Team> getStudentTeamInfo(String student_id) throws Exception
	{
		String sql = "select * from team where team_id in (select team_student.team_id from team_student"
			         +" where team_student.student_id =?) or team_monitorid =?";
	       System.out.println(student_id+"!!!");
	      
           return esql.list(Team.class, sql, student_id,student_id);
	}
	
	public List<Student> getStudentOnCourse(String course_id,String teacher_id) throws Exception
	{
		 String sql = "select *"
	          +" from student where student_id in (select student_course.student_id"
	          +" from student_course where student_course.course_id=? and student_course.teacher_id=?)";
	//System.out.println(student_id+"hello!");
              return esql.list(Student.class, sql, course_id,teacher_id);
	}
	

	@Override
	public Team studentIsMonitor(String studentid, String courseid,
			String teacherid) throws Exception {
		
		String sql = "select * from team where team_Monitorid =? and team_cour=? and team_teacherid=?";
		
		Team r=esql.query(Team.class, sql, studentid, courseid,teacherid);
		
		   return esql.query(Team.class, sql, studentid, courseid,teacherid);
	}
	public List<Student> getTeamMember(String teamid,String monitorid) throws Exception
	{
		

		String sql ="select * from student where student_id in " +
				   " (select student_id from team_student where team_id =?)" ;
			 System.out.println("teamid="+teamid);      
	      
           return esql.list(Student.class, sql, teamid);
	}


}
