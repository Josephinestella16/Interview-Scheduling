package org.ism.services;
import org.ism.model.Requirement;

public interface RequirementService {
	boolean addRequirement(Requirement req);
	
	boolean editRequirement(int num);
	
	boolean edit(Requirement req,int num);
}
