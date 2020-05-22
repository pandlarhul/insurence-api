package com.macu.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.macu.entity.Candidate;
import com.macu.entity.CurrentHealth;
import com.macu.entity.Habits;


@Repository
public class CandidateServiceImpl implements CandidateService {
	private EntityManager entityManager;
	
	public CandidateServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	@Override
	@Transactional
	public Candidate add(Candidate newCandidate) {
		Session session = entityManager.unwrap(Session.class);
		
		session.save(newCandidate);
		return newCandidate;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Candidate> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Candidate> allCandidates = session.createQuery("from Candidate").getResultList();
			return allCandidates;
	}



	@Override
	@Transactional
	public Candidate findById(int candidateId) {
		Session session = entityManager.unwrap(Session.class);
		
		//Query query = session.createQuery("from Candidate where id=:candidateId");
		
		//query.setParameter("candidateId", candidateId)
		
		Candidate candidate = session.get(Candidate.class, candidateId);
		
		return candidate;
	}



	@Override
	@Transactional
	public String deleteById(int candidateId) {
		Session session = entityManager.unwrap(Session.class);
		
		Candidate candidate = session.get(Candidate.class, candidateId);
		
		if(candidate == null) {
			throw new RuntimeException("candidate id is not present");
		}else
			{
			//"delete Emlpoyee where id=:employeeId"
				Query query = session.createQuery(" delete Candidate where id=:candidateId");
				query.setParameter("candidateId", candidateId);
				query.executeUpdate();
			}
		
		return "deleted successfully id "+candidateId;
	}



	@Override
	@Transactional
	public Candidate update(Candidate updateCandidate) {
		Session session = entityManager.unwrap(Session.class);
		
		Candidate oldCandidate ;
		
		oldCandidate = session.get(Candidate.class, updateCandidate.getId());
		
		if(oldCandidate == null) {
			throw new RuntimeException("updating id is not available");
		}else {
			
			// old health status and habits status
			Habits oldHabits = oldCandidate.getHabits();
			CurrentHealth oldCurrentHealth = oldCandidate.getCurrentHealth();
			
			// update health status and habits
			Habits updateHabits = updateCandidate.getHabits();
			CurrentHealth updateCurrentHealth = updateCandidate.getCurrentHealth();
			
			
			if(updateCandidate.getName() != null) {
				oldCandidate.setName(updateCandidate.getName());
			}
			
			
			if(updateCandidate.getAge() != 0) {
				oldCandidate.setAge(updateCandidate.getAge());
			}
			
			
			if(updateCandidate.getGender() != null) {
				oldCandidate.setGender(updateCandidate.getGender());
			}
			
			if(updateHabits != null) {
				oldCandidate.setHabits(updateHabits);
			}
			
			if(updateCurrentHealth != null) {
				oldCandidate.setCurrentHealth(updateCurrentHealth);
			}
		}
		
		
		
		return updateCandidate;
	}
	
	
	
	
	

}
