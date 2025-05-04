package com.sreelatha.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@Entity
public class Seekers {

	@Id
	@Column(name="students_id")
	private Integer id;
	private String name;
	private String city;
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Courses> courses;
	public void Seekers() {
		System.out.println("Seekers()......");
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Set<Courses> getCourses() {
		return courses;
	}
	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		return "Seekers [id=" + id + ", name=" + name + ", city=" + city + ", courses="
				+ (courses != null ? toString(courses, maxLen) : null) + "]";
	}
	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0) {
				builder.append(", ");
			}
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
