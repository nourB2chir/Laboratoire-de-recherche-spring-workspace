package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.OutilReository;
import com.example.demo.entities.Outil;

@SpringBootApplication
@EnableDiscoveryClient
public class MsOutilApplication implements CommandLineRunner {
	@Autowired
	RepositoryRestConfiguration repositoryRestConfig;
	@Autowired
	OutilReository outilRepository;

	public static void main(String[] args) {
		SpringApplication.run(MsOutilApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfig.exposeIdsFor(Outil.class);
		Outil o1 = new Outil(null, "source1");
		outilRepository.save(o1);
		Outil o2 = new Outil(null, "source2");
		outilRepository.save(o2);
	}

}
