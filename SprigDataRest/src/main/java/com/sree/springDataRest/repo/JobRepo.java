package com.sree.springDataRest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sree.springDataRest.model.JobPost;

public interface JobRepo extends JpaRepository<JobPost, Integer>{

public 	List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);

	
}
