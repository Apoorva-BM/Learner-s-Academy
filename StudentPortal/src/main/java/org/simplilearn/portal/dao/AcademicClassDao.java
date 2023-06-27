package org.simplilearn.portal.dao;


import java.util.List;

import org.simplilearn.portal.entities.AcdemicClass;

public interface AcademicClassDao {
	void add(AcdemicClass acdemicClass);
	void delete(String name);
	List<AcdemicClass> getAll();
}
