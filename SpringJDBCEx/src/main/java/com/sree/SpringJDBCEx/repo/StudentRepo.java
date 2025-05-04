package com.sree.SpringJDBCEx.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.sree.SpringJDBCEx.model.Student;

@Repository
public class StudentRepo {

	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void save(Student s) {
		String str = "INSERT INTO student(rollNo,name,marks) VALUES (?,?,?)";
		int rows = jdbc.update(str,s.getRollNo(),s.getName(),s.getMarks());
		System.out.println("Student added::"+rows+" rows effected...");
	}

	public List<Student> findAll() {
//		List<Student> students = new ArrayList<>();
//		return students;
		String qry = "select * from student";
//		RowMapper<Student> mapper = new RowMapper<Student>() {
//			
//			@Override
//			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student st = new Student();
//				st.setRollNo(rs.getInt(1));
//				st.setName(rs.getString(2));
//				st.setMarks(rs.getInt(3));
//				return st;
//			} };
		
		
		return jdbc.query(qry, (rs, rowNum)-> {
			Student st = new Student();
			st.setRollNo(rs.getInt("rollno"));
			st.setName(rs.getString("name"));
			st.setMarks(rs.getInt("marks"));
			return st;
		});
		
	}
	public Student getAStudent(int rn) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbc).withProcedureName("getAstudent");
		Map<String,Integer> inParams = new HashMap();
		
		inParams.put("rn",rn);
		
       // Optional result = Optional.empty();
		Student result = new Student();
        try {
            Map out = simpleJdbcCall.execute(inParams);
            System.out.println("out::"+out.entrySet());
            			
			  if (out != null) { Student st = new Student(); st.setRollNo(rn);
			  st.setMarks((Integer) out.get("smarks")); 
			  st.setName((String)out.get("sname")); 
			  result = st; }
			 
           

        } catch (Exception e) {
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.println(e.getMessage());
        }

        return result;
		
	}
	
	public List<Student> getAllStudentsProc() {
			jdbc.setResultsMapCaseInsensitive(true);
			
			 SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbc).withProcedureName("getAllStudents")
					 .returningResultSet("studs",BeanPropertyRowMapper.newInstance(Student.class));
			
			 Map m = simpleJdbcCall.execute(new HashMap<String, Object>(0));
				return (List) m.get("studs");
		
	}

}
