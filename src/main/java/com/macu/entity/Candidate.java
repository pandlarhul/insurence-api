package com.macu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "age")
	private int age;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "current_health_id")
	private CurrentHealth currentHealth;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "")
	private Habits habits;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public CurrentHealth getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(CurrentHealth currentHealth) {
		this.currentHealth = currentHealth;
	}

	public Habits getHabits() {
		return habits;
	}

	public void setHabits(Habits habits) {
		this.habits = habits;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", currentHealth="
				+ currentHealth + ", habits=" + habits + "]";
	}
	
	
	
}


/*
 * 
 * "currentHealth":{ "hypertension":"true", "bloodPressure":"false",
 * "bloodSugar":"true", "overWeight":"true" },
 * 
 * "habits":{ "smoking":"true", "alcohol":"false", "dailyExercise":"false",
 * "drugs":"true" }
 */