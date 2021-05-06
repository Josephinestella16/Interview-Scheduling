package org.ism.dao;
import java.util.List;

import org.ism.model.Candidate;
import org.ism.model.Interview;
import org.ism.model.Requirement;

public interface InterviewDao {

	boolean checkReq(int id);
	List<Candidate> getCandidates(String domain,int exp,int vac);
	Requirement getRequirement(int id);
	boolean saveInterview(Interview interview);
	void changeStatus(int id);
	boolean isPresent(int id);
	boolean isChecked(String id);
	Candidate getCandidateDetail(int id);
	void changeStatusToFalse(int id);
	void updateInterview(String result,String interviewId);
	void reduceVacancy(int reqId);
}
