package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;

@FeignClient(name = "EVENEMENT-SERVICE")
public interface EvenementProxyService {
	@GetMapping("/evenements/{id}")
	public EvenementBean findEventById(@PathVariable(name = "id") Long id);

}
