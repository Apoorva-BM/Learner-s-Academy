package org.simplilearn.portal.services;


import org.simplilearn.portal.dao.models.ReportModel;
import org.simplilearn.portal.entities.User;

public interface ReportService {
	ReportModel generateClassReport(User user);
}
