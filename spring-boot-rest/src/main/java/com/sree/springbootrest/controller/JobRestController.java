package com.sree.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sree.springbootrest.model.JobPost;
import com.sree.springbootrest.service.JobService;

// if all methods are restapis then use @RestController
@RestController 
@CrossOrigin("http://localhost:3000")// enable cross-origin request..
public class JobRestController {

	@Autowired
	JobService service;
	
	//jackson dataformat xml lib to be added to pom.xml to work with xml  
	@GetMapping(path="jobPosts",produces={"application/json"})
	//@ResponseBody to mention as rest apis to return data when it is just @Controller,
	public List<JobPost> returnAllJobPosts() {
		return service.returnAllJobPosts();
	}
	
	@GetMapping("jobPosts/{postId}")
	//@ResponseBody to mention as rest apis to return data when it is just @Controller,
	public JobPost returnJobPostById(@PathVariable int postId) {
		return service.returnJobPostById(postId);
	}
	
	@PostMapping(path="jobPosts", consumes="application/json")
	public JobPost addJobPost(@RequestBody  JobPost jobPost) {
		service.addJobPost(jobPost);
		return service.returnJobPostById(jobPost.getPostId());
	}
	
	@PutMapping("jobPosts")
	public JobPost updateJobPost(@RequestBody  JobPost jobPost) {
		service.updateJobPost(jobPost);
		return service.returnJobPostById(jobPost.getPostId());
	} 
	
	@DeleteMapping("jobPosts/{postId}")
	public String removeJobPostById(@PathVariable int postId) {
		return service.removeJobPostById(postId);
	}
	
	@GetMapping("load")
	public String load() {
		return service.load();
	}
	
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> search(@PathVariable("keyword") String keyword){
		return service.search(keyword);
	}
}
