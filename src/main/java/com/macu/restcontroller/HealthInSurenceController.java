package com.macu.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macu.entity.Candidate;
import com.macu.service.CandidateService;
import com.macu.util.CalculatePremium;

@RestController
@RequestMapping("/insurence")
public class HealthInSurenceController {

	private CandidateService candidateService;

	@Autowired
	public HealthInSurenceController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@PostMapping("/add")
	public Candidate add(@RequestBody Candidate newCandidate) {
		System.out.println(newCandidate);
		candidateService.add(newCandidate);
		return newCandidate;
	}
	

	@GetMapping("/list")
	public List<Candidate> findAll() {
		List<Candidate> allCandidates = candidateService.findAll(); 
		System.out.println(allCandidates);
		return allCandidates;
	}
	
	@GetMapping("/list/{candidateId}")
	public Candidate findById(@PathVariable int candidateId) {
		//System.out.println("id="+candidateId);
		Candidate candidate = candidateService.findById(candidateId);
		return candidate;
	}
	
	@DeleteMapping("/delete/{candidateId}")
	public String delete(@PathVariable int candidateId) {
		//System.out.println("id="+candidateId);
		String deleteMessage = candidateService.deleteById(candidateId);
		return deleteMessage;
	}
	
	@PutMapping("/update")
	public Candidate update(@RequestBody Candidate newCandidate) {
		System.out.println("updating candidate = "+newCandidate);
		Candidate deleteMessage = candidateService.update(newCandidate);
		return newCandidate;
	}
	
	@GetMapping("/calculate/{candidateId}")
	public String calculate(@PathVariable int candidateId) {
		Candidate candidate = candidateService.findById(candidateId);
		System.out.println(candidate);
		double total = CalculatePremium.calculatePremium(candidate);
		return ""+total;
	}
	
	

}
