package org.ism.services;

import org.ism.dao.CandidateDao;
import org.ism.dao.CandidateDaoImpl;
import org.ism.model.Candidate;

public class CandidateServiceImpl  implements CandidateService{
	CandidateDao dao = new CandidateDaoImpl();
	@Override
	public boolean registerCandidate(Candidate candidate) {
		boolean flag = dao.register(candidate);
		return flag;
	}
	@Override
	public boolean checkEmail(String email) {
		boolean flag=dao.isMailPresent(email);
		return flag;
	}
}
