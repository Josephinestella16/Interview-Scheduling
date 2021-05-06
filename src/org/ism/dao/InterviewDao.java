package org.ism.dao;


import java.util.List;

import org.ism.model.Candidate;
import org.ism.model.Interview;
import org.ism.model.Requirement;

public interface InterviewDao {

	boolean checkReq(int id);
	List<Candidate> getCandidates(String domain,int exp,int vac);
//	Requirement 
	Requirement getRequirement(int id);
	
	
	boolean saveInterview(Interview interview);
	
	void changeStatus(int id);
	
	
	//5th requirement
	boolean isPresent(int id);
	
	//Checking the mark is entered already for the interview
	boolean isChecked(String id);
	
	
	Candidate getCandidateDetail(int id);
	
	void changeStatusToFalse(int id);
	
	void updateInterview(String result,String interviewId);
	
	void reduceVacancy(int reqId);
}
