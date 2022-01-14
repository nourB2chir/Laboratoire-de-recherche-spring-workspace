package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Outil;

@RepositoryRestController
public interface OutilReository extends JpaRepository<Outil, Long> {

}
