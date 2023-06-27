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
import org.simplilearn.portal.dao.models.TeacherModel;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.ClassService;
import org.simplilearn.portal.services.impl.ClassServiceImpl;

@WebServlet("/addClass")
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassService service = new ClassServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		HttpSession httpSession = request.getSession();
		User user= (User) httpSession.getAttribute("user");
		String actionParameter =  request.getParameter("action");
		ClassModel classModel = new ClassModel();
		if(actionParameter.equalsIgnoreCase("delete")) {
			String name = request.getParameter("name1");
			classModel.setClassName(name);
			service.deleteClass(user, classModel.getClassName());
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}else {
			String className =  request.getParameter("className");
			String subject =  request.getParameter("Subject");
			String teacher = request.getParameter("Teacher");
			TeacherModel teacherModel =  new TeacherModel();
			SubjectModel subjectModel = new SubjectModel();
			classModel.setClassName(className);
			teacherModel.setName(teacher);
			subjectModel.setName(subject);
			service.addClass(user, classModel, teacherModel,subjectModel);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	}

}
