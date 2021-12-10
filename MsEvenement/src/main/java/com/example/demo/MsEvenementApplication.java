package com.example.demo;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entity.Evenement;

@SpringBootApplication
public class MsEvenementApplication implements CommandLineRunner {
	@Autowired
	RepositoryRestConfiguration repositoryRestConfig;
	@Autowired
	EvenementRepository evenementRepository;

	public static void main(String[] args) {
		SpringApplication.run(MsEvenementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Calendar calendar = Calendar.getInstance();
		repositoryRestConfig.exposeIdsFor(Evenement.class);
		Evenement ev1 = new Evenement("ch1", calendar.getTime(), "ch2");
		evenementRepository.save(ev1);
		Evenement ev2 = new Evenement("ch3", calendar.getTime(), "ch4");
		evenementRepository.save(ev2);

	}

}
