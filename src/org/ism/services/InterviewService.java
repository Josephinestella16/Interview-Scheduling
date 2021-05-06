package org.ism.services;

import java.util.List;
import org.ism.model.Candidate;
import org.ism.model.Interview;
import org.ism.model.Requirement;

public interface InterviewService {

	boolean checkReqId(int id);
	
	Requirement getReq(int id);
	
	List<Candidate> getCandidates(String domain,int exp,int vac);
	
	boolean saveInterview(Interview interview);
	
	void change(int Id);
	
	boolean isPresent(int id);
	
	boolean isChecked(String id);
	
	Candidate getCandidateDetails(int id);
	
	void changeToFalse(int id);
	
	void updateInterview(String result,String interviewId);
	
	void reduce(int id);
}
