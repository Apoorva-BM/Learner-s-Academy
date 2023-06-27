package org.simplilearn.portal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simplilearn.portal.dao.models.ReportModel;
import org.simplilearn.portal.entities.AcdemicClass;
import org.simplilearn.portal.entities.Student;
import org.simplilearn.portal.entities.Subject;
import org.simplilearn.portal.entities.Teacher;
import org.simplilearn.portal.entities.User;
import org.simplilearn.portal.services.ReportService;
import org.simplilearn.portal.services.impl.ReportServiceImpl;

@WebServlet("/report")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ReportService reportService = new ReportServiceImpl();
        ReportModel reportData = reportService.generateClassReport(user);
		
		 out.println("<html><head><title>Class Report</title></head><body>");
	        out.println("<h1>Class Report</h1>");
	        out.println("<h2>Students:</h2>");
	        for (Student student : reportData.getStudents()) {
	            out.println("<p>" + student.getSname() + "</p>");
	        }
	        out.println("<h2>Academic Classes:</h2>");
	        for (AcdemicClass academicClass : reportData.getClasses()) {
	            out.println("<p>" + academicClass.getName() + "</p>");
	        }
	        out.println("<h2>Subjects:</h2>");
	        for (Subject subject : reportData.getSubjects()) {
	            out.println("<p>" + subject.getName() + "</p>");
	        }
	        out.println("<h2>Teachers:</h2>");
	        for (Teacher teacher : reportData.getTeachers()) {
	            out.println("<p>" + teacher.getName() + "</p>");
	        }
	        out.println("</body></html>");
	}

}
