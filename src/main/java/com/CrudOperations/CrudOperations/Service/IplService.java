package com.CrudOperations.CrudOperations.Service;



import java.util.List;

import com.CrudOperations.CrudOperations.entity.IplTeam;


public interface IplService {

	public IplTeam insertdata(IplTeam iplteam);
	
	public List<IplTeam> getallteams();

	public IplTeam updateteam(int id, IplTeam Iplteam);
	
	public void delete(int id);
	
	public IplTeam getbyid(int id);
}
