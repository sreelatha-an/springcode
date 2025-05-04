package com.sree.springbootrest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sree.springbootrest.model.JobPost;

public interface JobRepo extends JpaRepository<JobPost, Integer>{

public 	List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);

	
}
