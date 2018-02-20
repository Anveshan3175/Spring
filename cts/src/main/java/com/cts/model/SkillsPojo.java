package com.cts.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_skills")
public class SkillsPojo implements Serializable {

	private static final long serialVersionUID = 8321170129964089275L;

	public SkillsPojo() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "name", unique = true)
	private String name;
	@Column(name = "description")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
