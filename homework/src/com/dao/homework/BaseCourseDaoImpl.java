package com.dao.homework;

import java.util.List;

import com.bean.homework.BaseCourse;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class BaseCourseDaoImpl extends BaseDao implements BaseCourseDao, PostgreSQL 
{

	
	public List<BaseCourse> getTeacherAllCourseInfo(String teacher_id) throws Exception  
	{
		String sql = "select * from basecourse where course_id not in (select course.course_id"
			        +" from course where course.teacher_id=?)";
	   //System.out.println(student_id+"hi!");
       return esql.list(BaseCourse.class, sql, teacher_id);
	}
	
	
}