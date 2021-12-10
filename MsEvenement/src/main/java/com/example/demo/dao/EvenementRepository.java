package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.Evenement;

@RepositoryRestController
public interface EvenementRepository extends JpaRepository<Evenement, Long>{

}
