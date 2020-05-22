package com.macu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "habits")
public class Habits {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "smoking")
	private boolean smoking;
	
	@Column(name = "alcohol")
	private boolean alcohol;
	
	@Column(name = "daily_exercise")
	private boolean dailyExercise;
	
	@Column(name = "drugs")
	private boolean drugs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public boolean isAlcohol() {
		return alcohol;
	}

	public void setAlcohol(boolean alcohol) {
		this.alcohol = alcohol;
	}

	public boolean isDailyExercise() {
		return dailyExercise;
	}

	public void setDailyExercise(boolean dailyExercise) {
		this.dailyExercise = dailyExercise;
	}

	public boolean isDrugs() {
		return drugs;
	}

	public void setDrugs(boolean drugs) {
		this.drugs = drugs;
	}

	@Override
	public String toString() {
		return "Habits [id=" + id + ", smoking=" + smoking + ", alcohol=" + alcohol + ", dailyExercise=" + dailyExercise
				+ ", drugs=" + drugs + "]";
	}
	
	

}
