package com.sree.JobApp.model;

import java.util.List;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {

	private int postId;
	private String postProfile; 
	private String postDesc;
	private Integer reqExperience;
	private List<String> postTechStack;
		@Override
	public String toString() {
		final int maxLen = 10;
		return "JobPost [postId=" + postId + ", postProfile=" + postProfile + ", postDesc=" + postDesc
				+ ", reqExperience=" + reqExperience + ", postTechStack="
				+ (postTechStack != null ? postTechStack.subList(0, Math.min(postTechStack.size(), maxLen)) : null)
				+ "]";
	}
	public JobPost(int postId, String postProfile, String postDesc, Integer reqExperience, List<String> postTechStack) {
		super();
		this.postId = postId;
		this.postProfile = postProfile;
		this.postDesc = postDesc;
		this.reqExperience = reqExperience;
		this.postTechStack = postTechStack;
	}
	public JobPost() {
		
	}
	
	

}
