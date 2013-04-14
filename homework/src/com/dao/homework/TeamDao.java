package com.dao.homework;


import com.bean.homework.Team;


public interface TeamDao 
{
	public int addTeam(String teamid,String teamname,String teamcour,String teamteacherid,String teammonitorid,String teammonitor) throws Exception;
	public int addStudentToMyTeam(String studentid,String myteamid) throws Exception;
	public void teamMemberDelete(String teamid, String studentid)throws Exception;
	public void teamAllDelete1(String teamid)throws Exception;
	public void teamAllDelete2(String teamid)throws Exception;

}
