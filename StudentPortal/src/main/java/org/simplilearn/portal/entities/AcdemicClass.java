package org.simplilearn.portal.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AcdemicClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "acdemicClass", cascade = CascadeType.ALL)
	private Set<Subject> subjects = new HashSet<>();
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "class_teacher", joinColumns = @JoinColumn(name = "cid"), inverseJoinColumns = @JoinColumn(name = "tid"))
	private Set<Teacher> teachers = new HashSet<>();
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// helper methods
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}

	public void addTeacher(Teacher teacher) {
		this.teachers.add(teacher);
	}
	
	public void removeFromSubject(Subject subjects) {
		this.subjects.remove(subjects);
		subjects.setUser(null);
	}
	
	public void removeFromTeacher(Teacher teachers) {
		this.teachers.remove(teachers);
		teachers.setUser(null);
	}
}
