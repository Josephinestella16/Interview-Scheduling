package org.ism.services;

import java.util.List;

import org.ism.dao.InterviewDao;
import org.ism.dao.InterviewDaoImpl;
import org.ism.model.Candidate;
import org.ism.model.Interview;
import org.ism.model.Requirement;

public class InterviewServiceImpl implements InterviewService{

	InterviewDao dao = new InterviewDaoImpl();
	@Override
	public boolean checkReqId(int id) {
		return dao.checkReq(id);
	}
	@Override
	public Requirement getReq(int id) {
		return dao.getRequirement(id);
	}
	@Override
	public List<Candidate> getCandidates(String domain,int exp,int vac){
		return dao.getCandidates(domain,exp,vac);
	}
	@Override
	public boolean saveInterview(Interview interview) {
		return dao.saveInterview(interview);
	}
	@Override
	public void change(int Id) {
		dao.changeStatus(Id);
	}
	@Override
	public boolean isPresent(int id) {
		InterviewDaoImpl dao = new InterviewDaoImpl();
		return dao.isPresent(id);
	}
	@Override
	public boolean isChecked(String id) {
		InterviewDaoImpl dao = new InterviewDaoImpl();
		return dao.isChecked(id);
	}
	@Override
	public Candidate getCandidateDetails(int id) {
		InterviewDaoImpl dao = new InterviewDaoImpl();
		return dao.getCandidateDetail(id);
	}
	@Override
	public void changeToFalse(int id) {
		InterviewDaoImpl dao = new InterviewDaoImpl();
		dao.changeStatusToFalse(id);
	}
	@Override
	public void updateInterview(String result,String interviewId) {
		InterviewDaoImpl dao = new InterviewDaoImpl();
		dao.updateInterview(result, interviewId);
	}
	
	@Override
	public void reduce(int id) {
		InterviewDaoImpl dao = new InterviewDaoImpl();
		dao.reduceVacancy(id);
	}
}

