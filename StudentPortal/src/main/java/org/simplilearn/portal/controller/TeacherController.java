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
import org.simplilearn.portal.dao.models.TeacherModel;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.TeacherService;
import org.simplilearn.portal.services.impl.TeacherServiceImpl;


@WebServlet("/addTeacher")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService service=new TeacherServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		String actionProperty = request.getParameter("action");
		if(actionProperty.equalsIgnoreCase("delete")) {
			String name=request.getParameter("name1");
			TeacherModel teacherModel=new TeacherModel();
			teacherModel.setName(name);
			service.deleteTeacher(user,teacherModel.getName());
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}else {
			String name=request.getParameter("name");
			String qual=request.getParameter("qual");
			TeacherModel teacherModel=new TeacherModel();
			teacherModel.setName(name);
			teacherModel.setQualification(qual);
			service.addTeacher(user, teacherModel);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		
	}

}
