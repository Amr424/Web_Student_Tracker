package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDbUtil studentdbutil = new StudentDbUtil();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		try {

			String command = request.getParameter("command");
			if (command == null) {
				command = "LIST";
			}

			switch (command) {
			case "LIST":
				listStudents(request, response);
				break;

			case "ADD":
				addStudent(request, response);
				break;

			case "LOAD":
				loadStudent(request, response);
				break;

			case "UPDATE":
				updateStudent(request, response);
				break;

			case "DELETE":
				deleteStudent(request, response);
				break;

			default:
				listStudents(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String studentId = request.getParameter("studentId");
		studentdbutil.deleteStudent(studentId);
		listStudents(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		Student thestudent = new Student(id, firstName, lastName, email);

		studentdbutil.updateStudent(thestudent);
		listStudents(request, response);

	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String theStudentId = request.getParameter("studentId");
		Student students = studentdbutil.getStudent(theStudentId);
		request.setAttribute("Students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);

	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");

		Student thestudent = new Student(firstname, lastname, email);
		studentdbutil.addStudent(thestudent);
		listStudents(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Student> students = studentdbutil.getStudent();
		request.setAttribute("STUDENT_LIST", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);

	}

}
