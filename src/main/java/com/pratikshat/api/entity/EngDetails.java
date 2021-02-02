package com.pratikshat.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class EngDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int engid;
	private String engname;
	private String date;
	private String assigned_task;
	private String profile;
	private String status;
	private String reported_to;
	private String project_name;
	private String remark;
	private Date updateDate;
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
	 * @return the engname
	 */
	public String getEngname() {
		return engname;
	}
	/**
	 * @param engname the engname to set
	 */
	public void setEngname(String engname) {
		this.engname = engname;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the project_name
	 */
	public String getProject_name() {
		return project_name;
	}
	/**
	 * @param project_name the project_name to set
	 */
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the updateDate
	 */
	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
