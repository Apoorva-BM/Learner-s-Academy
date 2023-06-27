package org.simplilearn.portal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simplilearn.portal.dao.models.StudentModel;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.StudentService;
import org.simplilearn.portal.services.impl.StudentServiceImpl;


@WebServlet("/addStudent")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService=new StudentServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		String actionProperty = request.getParameter("action");
		if(actionProperty.equalsIgnoreCase("delete")) {
			StudentModel studentModel=new StudentModel();
			String name=request.getParameter("name1");
			studentModel.setName(name);
			studentService.deleteStudent(user,studentModel.getName());
			RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
			request.setAttribute("msg","success");
			dispatcher.forward(request, response);
		}else {
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			StudentModel studentModel=new StudentModel(name, address);
			studentService.addStudent(user, studentModel);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
	}

}
