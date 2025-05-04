package com.sree.SpringJDBCEx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sree.SpringJDBCEx.model.Student;
import com.sree.SpringJDBCEx.service.StudentService;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);
		
		Student s1 = context.getBean(Student.class);
		s1.setRollNo(2);
		s1.setName("Sree");
		s1.setMarks(89);
		
		StudentService service = context.getBean(StudentService.class);
		
		// service.addStudent(s1); duplicate entry error
		
//		service.getAllStudents().forEach(s->System.out.println("student["+s.getRollNo()+", "+s.getName()+", "+s.getMarks()+"]"));
/*		List<Student> ss = service.getAllStudents();	
		
		Consumer cons = new Consumer() {

			@Override
			public void accept(Object s) {
				
				System.out.println("student["+s.getRollNo()+", "+s.getName()+", "+s.getMarks()+"]");
				
			}
			
		} ;
		ss.forEach(cons);
*/			
		
		Student s= service.getAstudent(2);
		System.out.println("student["+s.getRollNo()+", "+s.getName()+", "+s.getMarks()+"]");
		
		service.getAllStudentsProc()
		.forEach(ss->System.out.println("student["+ss.getRollNo()+", "+ss.getName()+", "+ss.getMarks()+"]"));
	}

}
