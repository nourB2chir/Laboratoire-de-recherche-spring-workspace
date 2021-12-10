package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Member_Outil_Ids implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long outil_id;
	private Long memeber_id;

	public Member_Outil_Ids() {
		super();
	}

	public Member_Outil_Ids(Long outil_id, Long memeber_id) {
		super();
		this.outil_id = outil_id;
		this.memeber_id = memeber_id;
	}

	public Long getOutil_id() {
		return outil_id;
	}

	public void setOutil_id(Long outil_id) {
		this.outil_id = outil_id;
	}

	public Long getMemeber_id() {
		return memeber_id;
	}

	public void setMemeber_id(Long memeber_id) {
		this.memeber_id = memeber_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(memeber_id, outil_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member_Outil_Ids other = (Member_Outil_Ids) obj;
		return Objects.equals(memeber_id, other.memeber_id) && Objects.equals(outil_id, other.outil_id);
	}

}
