package com.CrudOperations.CrudOperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CrudOperations.CrudOperations.entity.IplTeam;

public interface IplRepository extends JpaRepository<IplTeam, Integer>{
	

}
