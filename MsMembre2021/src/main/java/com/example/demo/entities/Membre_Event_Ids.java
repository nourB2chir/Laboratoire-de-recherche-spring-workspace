package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Membre_Event_Ids implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long eventId;
	private Long membarId;

	public Membre_Event_Ids() {
		super();
	}

	public Membre_Event_Ids(Long eventId, Long memberId) {
		super();
		this.eventId = eventId;
		this.membarId = memberId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getMemberId() {
		return membarId;
	}

	public void setMemberId(Long memberId) {
		this.membarId = memberId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventId, membarId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membre_Event_Ids other = (Membre_Event_Ids) obj;
		return Objects.equals(eventId, other.eventId) && Objects.equals(membarId, other.membarId);
	}

}
