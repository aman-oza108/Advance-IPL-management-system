package com.CrudOperations.CrudOperations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="IplTeams")
public class IplTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Trophies")
	private int trophies;
	
	@Column(name="CapTainName")
	private String captainname;

	public IplTeam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IplTeam(int id, String name, int trophies, String captainname) {
		super();
		this.id = id;
		this.name = name;
		this.trophies = trophies;
		this.captainname = captainname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTrophies() {
		return trophies;
	}

	public void setTrophies(int trophies) {
		this.trophies = trophies;
	}

	public String getCaptainname() {
		return captainname;
	}

	public void setCaptainname(String captainname) {
		this.captainname = captainname;
	}
	
	
	
}
