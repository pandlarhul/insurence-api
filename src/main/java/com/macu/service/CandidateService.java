package com.macu.service;

import java.util.List;

import com.macu.entity.Candidate;

public interface CandidateService {
	public Candidate add(Candidate newCandidate);
	
	public List<Candidate> findAll();
	
	public Candidate findById(int candidateId);

	public String deleteById(int candidateId);

	public Candidate update(Candidate newCandidate);
}
