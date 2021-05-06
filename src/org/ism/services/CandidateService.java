package org.ism.services;

import org.ism.model.Candidate;

public interface CandidateService {
	boolean registerCandidate(Candidate candidate);
	boolean checkEmail(String email);
}
