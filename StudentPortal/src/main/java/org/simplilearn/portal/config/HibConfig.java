package org.simplilearn.portal.config;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.simplilearn.portal.entities.AcdemicClass;
import org.simplilearn.portal.entities.Student;
import org.simplilearn.portal.entities.Subject;
import org.simplilearn.portal.entities.Teacher;
import org.simplilearn.portal.entities.User;

public class HibConfig {
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/portaldb");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "roots");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		properties.put(Environment.HBM2DDL_AUTO, "update");
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(AcdemicClass.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(Teacher.class);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(User.class);
		SessionFactory factory = configuration.buildSessionFactory();
		return factory;
	}
}

