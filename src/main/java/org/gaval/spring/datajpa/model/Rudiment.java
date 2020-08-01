package org.gaval.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name="rudiments")
public class Rudiment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="published")
	private boolean published;

	public Rudiment(){
	}

	public Rudiment(String name, String description, boolean published){
		this.name = name;
		this.description = description;
		this.published = published;
	}

	public long getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public boolean getPublished(){
		return published;
	}

	public void setPublished(boolean published){
		this.published = published;
	}

	@Override
	public String toString(){
		return "Rudiment [id=" + id + ". name=" + name + ", desc=" + description + ", published=" + published +"]";
	}
}



