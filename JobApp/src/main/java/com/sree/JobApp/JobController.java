package com.sree.JobApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sree.JobApp.model.JobPost;
import com.sree.JobApp.service.JobService;

@Controller
public class JobController {

	@Autowired
	private JobService service;

	
	@RequestMapping({"/","home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("addjob")
	public String addjob() {
		return "addjob";
	}
	//@RequestMapping("handleForm", method="post")
	@PostMapping("handleForm")
	public String handleForm(JobPost jobPost) {
		System.out.println("jobpost in handlForm()=="+jobPost.toString());
		service.addJobPost(jobPost);
		return "success";
	}
	
	// controller method for getting all job posts
		@GetMapping("/viewalljobs")
		public String viewJobs(Model model) {

			List<JobPost> jobPosts = service.returnAllJobPosts();
			model.addAttribute("jobPosts", jobPosts);
			return "viewalljobs";
		}
		

}
