package com.macu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "current_health")
public class CurrentHealth {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id; 
	
	@Column(name = "hyper_tension")
	private boolean hypertension;
	
	@Column(name = "blood_pressure")
	private boolean bloodPressure;
	
	@Column(name = "blood_sugar")
	private boolean bloodSugar;
	
	@Column(name = "over_weight")
	private boolean overWeight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isHypertension() {
		return hypertension;
	}

	public void setHypertension(boolean hypertension) {
		this.hypertension = hypertension;
	}

	public boolean isBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(boolean bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public boolean isBloodSugar() {
		return bloodSugar;
	}

	public void setBloodSugar(boolean bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	public boolean isOverWeight() {
		return overWeight;
	}

	public void setOverWeight(boolean overWeight) {
		this.overWeight = overWeight;
	}

	@Override
	public String toString() {
		return "CurrentHealth [id=" + id + ", hypertension=" + hypertension + ", bloodPressure=" + bloodPressure
				+ ", bloodSugar=" + bloodSugar + ", overWeight=" + overWeight + "]";
	}



}
