package com.dao.homework;

import com.bean.homework.Teacher;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class TeamDaoImpl extends BaseDao implements TeamDao, PostgreSQL 
{

	public int addTeam(String teamid,String teamname,String teamcour,String teamteacherid,String teammonitorid,String teammonitor) throws Exception
	{
		String sql = "insert into team(team_id, team_name, team_cour,team_teacherid, team_monitorid, team_monitor)"
            +" values (?,?,?,?,?,?)";
       return esql.update(sql, teamid,teamname,teamcour,teamteacherid,teammonitorid,teammonitor);

	}
	public int addStudentToMyTeam(String studentid,String myteamid)throws Exception
	{
		String sql = "insert into team_student(student_id,team_id)"
            +" values (?,?)";
       return esql.update(sql, studentid,myteamid);

	}
	@Override
	public void teamMemberDelete(String teamid, String studentid)
			throws Exception {
		String sql = "delete from team_student where student_id = ? and team_id = ?";
		esql.update(sql, studentid,teamid);
		
	}
	
	public void teamAllDelete1(String teamid)throws Exception {
        
		String sql = "delete from team_student where team_id = ?";
		
        esql.update(sql, teamid);
	}
	public void teamAllDelete2(String teamid)throws Exception {
        //System.out.println("KKKKKKKKKKKKKK");
        String sql2 ="delete from team where team_id=?";
        esql.update(sql2, teamid);

}

	
}