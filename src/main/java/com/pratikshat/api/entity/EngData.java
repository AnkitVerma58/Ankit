package com.pratikshat.api.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class EngData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int engid;
	private String name;
	private String profile;
	private String date;
	private String assigned_task;
	private String reported_to;
	
	@OneToMany( mappedBy = "EngData" )
	private EngDetails engDetails;
	/**
	 * @return the engid
	 */
	public int getEngid() {
		return engid;
	}
	/**
	 * @param engid the engid to set
	 */
	public void setEngid(int engid) {
		this.engid = engid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the assigned_task
	 */
	public String getAssigned_task() {
		return assigned_task;
	}
	/**
	 * @param assigned_task the assigned_task to set
	 */
	public void setAssigned_task(String assigned_task) {
		this.assigned_task = assigned_task;
	}
	/**
	 * @return the reported_to
	 */
	public String getReported_to() {
		return reported_to;
	}
	/**
	 * @param reported_to the reported_to to set
	 */
	public void setReported_to(String reported_to) {
		this.reported_to = reported_to;
	}
	/**
	 * @return the engDetails
	 */
	public EngDetails getEngDetails() {
		return engDetails;
	}
	/**
	 * @param engDetails the engDetails to set
	 */
	public void setEngDetails(EngDetails engDetails) {
		this.engDetails = engDetails;
	}

	
	

	
	
}
