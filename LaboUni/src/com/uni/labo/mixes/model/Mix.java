package com.uni.labo.mixes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TableMix")
public class Mix implements java.io.Serializable {

	private int id;
	private Date date;
	private String recipe;
	private String description;
	private String descriptionAdditional;
	private String shift;
	private String batch;
	
	
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Date")
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "Recipe")
	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	@Column(name = "Opis")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Opis2")
	public String getDescriptionAdditional() {
		return descriptionAdditional;
	}

	public void setDescriptionAdditional(String descriptionAdditional) {
		this.descriptionAdditional = descriptionAdditional;
	}
	@Column(name = "Shift")
	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}
	@Column(name = "Batch")
	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}
	
	
}
