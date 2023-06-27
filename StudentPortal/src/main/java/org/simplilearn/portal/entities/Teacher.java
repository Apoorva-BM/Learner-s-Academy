package org.simplilearn.portal.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String qual;
	@ManyToMany(mappedBy = "teachers")
	private Set<AcdemicClass> acdemicClasses = new HashSet<>();
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

	public Set<AcdemicClass> getAcdemicClasses() {
		return acdemicClasses;
	}

	public void setAcdemicClasses(Set<AcdemicClass> acdemicClasses) {
		this.acdemicClasses = acdemicClasses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// helper methods
	public void addClass(AcdemicClass acdemicClass) {
		acdemicClasses.add(acdemicClass);
	}
	
	public void removeClass(AcdemicClass acdemicClass) {
		this.acdemicClasses.remove(acdemicClass);
		acdemicClass.setUser(null);
    }
}

