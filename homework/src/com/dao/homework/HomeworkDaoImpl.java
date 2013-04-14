package com.dao.homework;

import java.util.List;

import com.bean.homework.Course;
import com.bean.homework.Student;
import com.bean.homework.Homework;
import com.bean.homework.StudentHomework;
import com.bean.homework.TeamHomework;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class HomeworkDaoImpl extends BaseDao implements HomeworkDao, PostgreSQL 
{			
		public List<Homework> getCourseHomeworkInfo(String course_id,String teacher_id) throws Exception  
		{
			String sql = "select * from homework where course_id=? and teacher_id =?";
		//System.out.println(student_id+"hello!");
	       return esql.list(Homework.class, sql, course_id,teacher_id);
		}
		
		public int addNewHomework(String homeworkid,String courseid,String teacherid) throws Exception
		{
			String sql = "insert into homework(homework_id,course_id,teacher_id)"
				       +" values(?,?,?)";
			return esql.update(sql,homeworkid,courseid,teacherid);

		}
		
		public List<StudentHomework> getHomeworkInfoByPerson(String courseid,String teacherid,String homeworkid)throws Exception
		{
			String sql = "select homework_student.student_id,student.student_name"
				        +",homework_student.submit_date from student join homework_student on student.student_id="
				        +" homework_student.student_id where course_id=? and teacher_id=? and homework_id=?";
			
			//可以优化这个查询吧！！！！！！！！
		       return esql.list(StudentHomework.class, sql, courseid,teacherid,homeworkid);
		}
		
		public List<TeamHomework> getHomeworkInfoByTeam(String courseid,String teacherid,String homeworkid)throws Exception
		{
			String sql = "select homework_team.team_id,team.team_name,team.team_monitor"
				        +",homework_team.submit_date from team join homework_team on team.team_id="
				        +" homework_team.team_id where course_id=? and teacher_id=? and homework_id=?";
			
			//可以优化这个查询吧！！！！！！！！
		       return esql.list(TeamHomework.class, sql, courseid,teacherid,homeworkid);
		}

		public void upLoadHomeworkFilename(String homeworkid, String courseid,
				String teacherid, String fileName) throws Exception {
			String sql = "update homework set homework_filename = ? where homework_id = ? and course_id=? and teacher_id=?";
			
			esql.update(sql, fileName, homeworkid,courseid,teacherid);
			
		}
		public void upLoadHomeworkFilenameByPerson(String studentid,String homeworkid, String courseid,
				String teacherid, String fileName) throws Exception {
			//String sql = "update homework_student set work_filename = ? and student_id=? where  homework_id = ? and course_id=? and teacher_id=?";
			 String sql = "insert into homework_student(student_id,homework_id,course_id,teacher_id,work_filename)"
			       +" values(?,?,?,?,?)";
			esql.update(sql,studentid,homeworkid,courseid,teacherid,fileName);
			
		}
		
		public void upLoadHomeworkFilenameByTeam(String teamid,String homeworkid, String courseid,
				String teacherid, String fileName) throws Exception {

			//String sql = "update homework set homework_filename = ? where homework_id = ? and course_id=? and teacher_id=?";

			String sql = "update homework_team set work_filename = ? where team_id=? and homework_id=? and course_id=?"
			       +" and teacher_id=?";
			esql.update(sql,fileName,teamid,homeworkid,courseid,teacherid);
			
		}
		
}