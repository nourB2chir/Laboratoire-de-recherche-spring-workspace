package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MembreRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.proxies.PublicationProxyService;
import com.example.demo.service.IMemberService;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsMembre2021Application implements CommandLineRunner{
	@Autowired
	MembreRepository membreRepository;
	@Autowired
	EtudiantRepository etudiantrepository;
	
	@Autowired
	IMemberService iMemberService;
	@Autowired
	PublicationProxyService publicationProxyService;

	public static void main(String[] args) {
		SpringApplication.run(MsMembre2021Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		
	
	}
	
	

}
