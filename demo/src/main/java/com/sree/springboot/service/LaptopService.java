package com.sree.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sree.springboot.model.Laptop;
import com.sree.springboot.repo.laptopRepository;

@Service
public class LaptopService {
	@Autowired
	private laptopRepository lapRep;
	
	public void addToRegister(Laptop lap) {
		lapRep.save(lap);
	}
	public boolean isGoodForProg(Laptop lap) {
		 return true;
		 }

}
