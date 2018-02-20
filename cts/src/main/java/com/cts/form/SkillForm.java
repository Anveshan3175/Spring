package com.cts.form;

import java.io.Serializable;


public class SkillForm implements Serializable{

	private static final long serialVersionUID = 3498721239294378156L;


	public SkillForm() {
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	private String name;
	private String description;
	
	
	public Integer getId() {
		return id;
	}
	public SkillForm(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillForm other = (SkillForm) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SkillForm [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
