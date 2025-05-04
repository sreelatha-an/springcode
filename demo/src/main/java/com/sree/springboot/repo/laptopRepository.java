package com.sree.springboot.repo;

import org.springframework.stereotype.Repository;

import com.sree.springboot.model.Laptop;

@Repository
public class laptopRepository {
	public void save(Laptop lap) {
		 System.out.println("Saved in Database..");
		 }

}
