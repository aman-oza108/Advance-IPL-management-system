package com.CrudOperations.CrudOperations.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CrudOperations.CrudOperations.Service.IplService;
import com.CrudOperations.CrudOperations.entity.IplTeam;

@RestController
public class IplController {

	IplService service;
	
	
	
	public IplController(IplService service) {
		super();
		this.service = service;
	}


     @PostMapping("/insert")
	public ResponseEntity<IplTeam> insertdata(@RequestBody IplTeam iplteam)
	{
	      IplTeam saved=service.insertdata(iplteam);
		 
		 return new ResponseEntity<IplTeam>(saved, HttpStatus.CREATED);
	}
     
     
     @GetMapping("/all")
     public ResponseEntity<List<IplTeam>> getall(){
    	 
    	List<IplTeam> all=service.getallteams();
    	
          return  ResponseEntity.ok(all);
     }
     
     @PutMapping("/put/{id}")
     public IplTeam updateTeam(@PathVariable int id, @RequestBody IplTeam iplteam)
     {
    	 return service.updateteam(id, iplteam);
     }
     
     
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<Map<String, Boolean>>delete(@PathVariable int id)
     {
    	 service.delete(id);
    	 
    	 Map<String, Boolean> response=new HashMap<>();
    	 
    	 response.put("Deleted", Boolean.TRUE);
    	 
    	return  ResponseEntity.ok(response);
     }
     
     @GetMapping("get/{id}")
     public IplTeam getbyid(@PathVariable int id){
    	 
    	 return service.getbyid(id);
     }
}
