package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entities.Publication;

@RepositoryRestController
public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
