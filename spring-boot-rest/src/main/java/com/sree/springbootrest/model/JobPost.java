package com.sree.springbootrest.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class JobPost {

	@Id
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

}
