package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Member_Outil;
import com.example.demo.entities.Member_Outil_Ids;

public interface MemberOutilRepository extends JpaRepository<Member_Outil, Member_Outil_Ids> {
	@Query("select m from Member_Outil m where memeber_id=:x")
	List<Member_Outil> findOutilId(@Param("x") Long member_id);

}
