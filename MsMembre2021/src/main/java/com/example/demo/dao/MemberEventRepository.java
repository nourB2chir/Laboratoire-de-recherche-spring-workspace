package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Member_Event;
import com.example.demo.entities.Membre_Event_Ids;

public interface MemberEventRepository extends JpaRepository<Member_Event, Membre_Event_Ids> {
	@Query("select m from Member_Event m where membar_id=:x")
	List<Member_Event> findEventId(@Param("x") Long member_id);
	
	@Transactional
	@Modifying
	@Query("delete from Member_Event m where event_id=:y")
	void desaffecterMembreDeEvent(@Param("y") Long pub_id);

}
