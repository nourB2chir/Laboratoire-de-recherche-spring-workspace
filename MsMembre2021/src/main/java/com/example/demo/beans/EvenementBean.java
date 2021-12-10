package com.example.demo.beans;

import java.util.Date;

public class EvenementBean {
	Long id;
	String titre;
	Date date;
	String lieu;

	public EvenementBean() {
		super();
	}

	public EvenementBean(Long id, String titre, Date date, String lieu) {
		super();
		this.id = id;
		this.titre = titre;
		this.date = date;
		this.lieu = lieu;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

}
