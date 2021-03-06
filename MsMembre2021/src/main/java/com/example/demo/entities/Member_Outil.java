package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Member_Outil {
	@EmbeddedId
	private Member_Outil_Ids id;
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("memeber_id")
	private Member memeber;

	public Member_Outil() {
		super();
	}

	public Member_Outil(Member_Outil_Ids id, Member member) {
		super();
		this.id = id;
		this.memeber = member;
	}

	public Member_Outil_Ids getId() {
		return id;
	}

	public void setId(Member_Outil_Ids id) {
		this.id = id;
	}

	public Member getMember() {
		return memeber;
	}

	public void setMember(Member member) {
		this.memeber = member;
	}

}
