package com.macu.util;

import com.macu.entity.Candidate;
import com.macu.entity.CurrentHealth;
import com.macu.entity.Habits;

public class CalculatePremium {
	public static double calculatePremium(Candidate candidate) {
		double total = 0 ;
		CurrentHealth currentHealth = candidate.getCurrentHealth();
		Habits habits = candidate.getHabits();
		
		total = 5000;
		
		int age = candidate.getAge();
		
		
		
		System.out.println("age :"+age);
		if(age >= 18) {
			System.out.println("total : 18:  before == "+total);
			
			total += (total*10)/100;
			
			System.out.println("total : 18: after ==== "+total);
			
		}
		
		
		if(age >= 25 ) {
			total += (total*10)/100;	
		}
		if(age >= 30) {
			total += (total*10)/100;;	
		}
		if(age >= 35) {
			total += (total*10)/100;;	
		}
		
		int tempAge = 40;
		while(tempAge <= age) {
			
			total += (total*20)/100;;
			tempAge += 5;
		}
		
		
		if(candidate.getGender().equals("male")) {
			total += (total*2)/100;
		}
		
		
		// 1% increase for every conditions
		if(currentHealth.isBloodPressure() == true) {
			total += (total)/100;
		}
		
		if(currentHealth.isBloodSugar() == true) {
			total += (total)/(100);
		}
		if(currentHealth.isHypertension() == true) {
			total += (total)/(100);
		}
		if(currentHealth.isOverWeight() == true) {
			total += (total)/(100);
		}
		
		
		// increase for bad habits by 3% and decrease for good habits by 3%
		if(habits.isDailyExercise() == true) {
			total -= (total*3)/(100);
		}

		if(habits.isAlcohol() == true) {
			total += (total*3)/(100);
		}

		if(habits.isSmoking() == true) {
			total += (total*3)/(100);
		}

		if(habits.isDrugs() == true) {
			total += (total*3)/(100);
		}
		System.out.println("total :  "+total);
		return total;
	}

}
