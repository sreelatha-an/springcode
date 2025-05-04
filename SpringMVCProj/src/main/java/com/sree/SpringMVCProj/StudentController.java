package com.sree.SpringMVCProj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	
	@RequestMapping("studentForm") //urlname
	public String studentForm() //methodname 
	{ 
		return "studentForm";  // jspname
	}
	@RequestMapping("/") //urlname
	public String indexcall() //methodname 
	{ 
		return "index";  // jspname
	}
	
	@ModelAttribute("marks")
	public int studentMarks(Student student) {
     student.setMarks(40);
	 return 60;
	}
	/*//model view object
	@RequestMapping("addStudents")	 
	public ModelAndView addStudents(@RequestParam() int sid, String sname, ModelAndView mv) {
		
		Student st = new Student();
		st.setRollno(sid);
		st.setName(sname);
		st.setMarks(50);
		mv.addObject("student", st);
		mv.setViewName("addStudentStatus");
		return mv;
	}
	*/
	/* this is to get the request params all together as an object using @ModelAttribute, it is an optional one can skip.*/
	@RequestMapping("addStudents")
	public String addStudents(Student student)  
	//(@ModelAttribute("stud1") Student student) //(@ModelAttribute Student student) 
	{
		
		return "addStudentStatus";
		
	}

}
