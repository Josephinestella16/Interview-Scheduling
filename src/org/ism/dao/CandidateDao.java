package org.ism.dao;

import org.ism.model.Candidate;

public interface CandidateDao {
	boolean register(Candidate candidate);
	boolean isMailPresent(String email);
}
