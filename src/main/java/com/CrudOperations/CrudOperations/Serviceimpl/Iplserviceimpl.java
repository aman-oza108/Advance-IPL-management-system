package com.CrudOperations.CrudOperations.Serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CrudOperations.CrudOperations.Service.IplService;
import com.CrudOperations.CrudOperations.entity.IplTeam;
import com.CrudOperations.CrudOperations.repository.IplRepository;

@Service
public class Iplserviceimpl implements IplService {

	IplRepository repo;
	
	
	
	
	public Iplserviceimpl(IplRepository repo) {
		super();
		this.repo = repo;
	}




	@Override
	public IplTeam insertdata(IplTeam iplteam) {
		
		return  repo.save(iplteam);
	}




	@Override
	public List<IplTeam> getallteams() {
		
		return repo.findAll();
	}




	@Override
	public IplTeam updateteam(int id, IplTeam iplteam) {
		
		IplTeam existingteam=repo.findById(id).get();
		
		
		existingteam.setName(iplteam.getName());
		existingteam.setTrophies(iplteam.getTrophies());
		existingteam.setCaptainname(iplteam.getCaptainname());
		
		return repo.save(existingteam);
		
	}




	@Override
	public void delete(int id) {
		
		IplTeam existingteam=repo.findById(id).get();
		
		repo.delete(existingteam);
		
		
		
	}




	@Override
	public IplTeam getbyid(int id) {
		
		return repo.findById(id).orElseThrow(()->new RuntimeException("Team not found with this id:"+id));
	}

}
