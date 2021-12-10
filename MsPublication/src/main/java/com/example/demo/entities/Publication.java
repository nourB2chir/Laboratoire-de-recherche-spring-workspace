package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publication implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String titre;
	Date dateapparition;
	String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateapparition() {
		return dateapparition;
	}

	public void setDateapparition(Date dateapparition) {
		this.dateapparition = dateapparition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Publication(String titre, Date dateapparition, String type) {
		super();
		this.titre = titre;
		this.dateapparition = dateapparition;
		this.type = type;
	}

	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}

}
