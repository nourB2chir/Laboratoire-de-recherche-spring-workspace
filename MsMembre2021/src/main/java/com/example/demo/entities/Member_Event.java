package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Member_Event {
	@EmbeddedId
	private Membre_Event_Ids id;
	@ManyToOne
	@MapsId("membarId")
	private Member membar;

	public Member_Event() {
		super();
	}

	public Member_Event(Membre_Event_Ids id, Member member) {
		super();
		this.id = id;
		this.membar = member;
	}

	public Membre_Event_Ids getId() {
		return id;
	}

	public void setId(Membre_Event_Ids id) {
		this.id = id;
	}

	public Member getMember() {
		return membar;
	}

	public void setMember(Member member) {
		this.membar = member;
	}

}
