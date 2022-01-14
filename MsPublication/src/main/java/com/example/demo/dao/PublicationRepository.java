package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Publication;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
