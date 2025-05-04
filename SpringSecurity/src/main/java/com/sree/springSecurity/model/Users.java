package com.sree.springSecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

	@Id
	@GeneratedValue(generator = "usrseq_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="usrseq_gen", sequenceName = "usrmy_seq", initialValue = 5,allocationSize = 1 )
	private int id;
	private String name;
	private String password;
	
}
