package com.dao.homework;

import java.util.List;

import com.bean.homework.Homework;
import com.bean.homework.StudentHomework;
import com.bean.homework.TeamHomework;

public interface HomeworkDao 
{
	public List<Homework> getCourseHomeworkInfo(String course_id,String teacher_id) throws Exception;
	public int addNewHomework(String homeworkid,String courseid,String teacherid) throws Exception;
	public  List<StudentHomework> getHomeworkInfoByPerson(String courseid,String teacherid,String homeworkid)throws Exception;
	public  List<TeamHomework> getHomeworkInfoByTeam(String courseid,String teacherid,String homeworkid)throws Exception;
	public void upLoadHomeworkFilename (String homeworkid,String courseid,String teacherid, String fileName) throws Exception;
	public void upLoadHomeworkFilenameByPerson (String studentid,String homeworkid,String courseid,String teacherid, String fileName) throws Exception;
	public void upLoadHomeworkFilenameByTeam (String studentid,String homeworkid,String courseid,String teacherid, String fileName) throws Exception;

}