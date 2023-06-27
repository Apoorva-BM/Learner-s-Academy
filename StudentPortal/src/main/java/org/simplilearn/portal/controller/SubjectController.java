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

import org.simplilearn.portal.dao.models.ClassModel;
import org.simplilearn.portal.dao.models.SubjectModel;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.SubjectService;
import org.simplilearn.portal.services.impl.SubjectServiceimpl;

@WebServlet("/addSubject")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectService service= new SubjectServiceimpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		HttpSession httpSession = request.getSession();
		User user= (User) httpSession.getAttribute("user");
		String actionParameter =  request.getParameter("action");
		SubjectModel model= new SubjectModel();
		if(actionParameter.equalsIgnoreCase("delete")) {
			String name = request.getParameter("name1");
			model.setName(name);
			service.deleteSubject(user, model.getName());
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}else {
			String names = request.getParameter("name");
			String marks =  request.getParameter("marks");
			String className =  request.getParameter("className");
			int mark = Integer.parseInt(marks);
			ClassModel  classModel = new ClassModel(className);
			model.setMarks(mark);
			model.setName(names);
			service.addSubject(user, model,classModel);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
		}

}
