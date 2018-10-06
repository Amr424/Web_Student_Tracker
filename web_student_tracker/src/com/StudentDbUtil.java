package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentDbUtil {
	LoginDb login = new LoginDb();
	public List<Student> getStudent() throws Exception {

		List<Student> students = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;database=web_student_tracker;username=sa;password=hhhhh");
			String sql = "select * from student";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");

				Student temp = new Student(id, firstName, lastName, email);
				students.add(temp);
			}

			return students;
		} finally {
			close(conn, stmt, rs);
		}
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void addStudent(Student thestudent) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;database=web_student_tracker;username=sa;password=hhhhh");
			String sql = "insert into student(first_name,last_name,email)values(?,?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, thestudent.getFirstName());
			stmt.setString(2, thestudent.getLastName());
			stmt.setString(3, thestudent.getEmail());
			stmt.execute();
		} finally {
			close(conn, stmt, null);
		}

	}

	public Student getStudent(String theStudentId) throws Exception {

		Student thestudent = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int studentId;

		try {

			studentId = Integer.parseInt(theStudentId);
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;database=web_student_tracker;username=sa;password=hhhhh");
			String sql = "select * from student where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, studentId);

			rs = stmt.executeQuery();

			if (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				thestudent = new Student(studentId, firstName, lastName, email);
			} else {
				throw new Exception("could not find student id: " + studentId);
			}

			return thestudent;
		} finally {
			close(conn, stmt, rs);
		}
	}

	public void updateStudent(Student thestudent) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;database=web_student_tracker;username=sa;password=hhhhh");
			String sql = "update student set first_name=?,last_name=?,email=? where id=?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, thestudent.getFirstName());
			stmt.setString(2, thestudent.getLastName());
			stmt.setString(3, thestudent.getEmail());
			stmt.setInt(4, thestudent.getId());
			stmt.execute();
		} finally {
			close(conn, stmt, null);
		}
	}

	public void deleteStudent(String studentId) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;

		int id = Integer.parseInt(studentId);

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;database=web_student_tracker;username=sa;password=hhhhh");
			String sql = "delete from student where id=?";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.execute();
		} finally {
			close(conn, stmt, null);
		}

	}

	public LoginDb login() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("web_student_tracker");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		

		login = (LoginDb) em.find(LoginDb.class, 1);

		em.getTransaction().commit();

		em.close();
		emf.close();
return login;
	}
}
