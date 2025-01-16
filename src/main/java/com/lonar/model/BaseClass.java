package com.lonar.model;

import java.util.Date;

import javax.persistence.Basic;

import javax.persistence.Column;

import javax.persistence.MappedSuperclass;

import javax.persistence.Temporal;

import javax.persistence.TemporalType;

import javax.persistence.Transient;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class BaseClass {

	private Date startDate;
	private Date endDate;
	private Long createdBy;
	private Date creationDate;
	private Long lastUpdateLogin;
	private Long lastUpdatedBy;
	private Date lastUpdateDate;
	private Long draw;

	private Long start;
	private Long length;
	private String stDate;
	private String enDate;
	private int columnNo;
	private String sort;

	public Date getStartDate() {

		return startDate;

	}

	public void setStartDate(Date startDate) {

		this.startDate = startDate;

	}

	public Date getEndDate() {

		return endDate;

	}

	public void setEndDate(Date endDate) {

		this.endDate = endDate;

	}

	public Long getCreatedBy() {

		return createdBy;

	}

	public void setCreatedBy(long createdBy) {

		this.createdBy = createdBy;

	}

	public Date getCreationDate() {

		return creationDate;

	}

	public void setCreationDate(Date creationDate) {

		this.creationDate = creationDate;

	}

	public Long getLastUpdateLogin() {

		return lastUpdateLogin;

	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {

		this.lastUpdateLogin = lastUpdateLogin;

	}

	public Long getLastUpdatedBy() {

		return lastUpdatedBy;

	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {

		this.lastUpdatedBy = lastUpdatedBy;

	}

	public Date getLastUpdateDate() {

		return lastUpdateDate;

	}

	public void setLastUpdateDate(Date lastUpdateDate) {

		this.lastUpdateDate = lastUpdateDate;

	}

	public Long getDraw() {

		return draw;

	}

	public void setDraw(Long draw) {

		this.draw = draw;

	}

	public Long getStart() {

		return start;

	}

	public void setStart(Long start) {

		this.start = start;

	}

	public Long getLength() {

		return length;

	}

	public void setLength(Long length) {

		this.length = length;

	}

	public String getStDate() {

		return stDate;

	}

	public void setStDate(String stDate) {

		this.stDate = stDate;

	}

	public String getEnDate() {

		return enDate;

	}

	public void setEnDate(String enDate) {

		this.enDate = enDate;

	}

	public int getColumnNo() {

		return columnNo;

	}

	public void setColumnNo(int columnNo) {

		this.columnNo = columnNo;

	}

	public String getSort() {

		return sort;

	}

	public void setSort(String sort) {

		this.sort = sort;

	}

	public void setCreatedBy(Long createdBy) {

		this.createdBy = createdBy;

	}

	@Override

	public String toString() {

		return "BaseClass [startDate=" + startDate + ", endDate=" + endDate + ", createdBy=" + createdBy

				+ ", creationDate=" + creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy="

				+ lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + ", draw=" + draw + ", start=" + start

				+ ", length=" + length + ", stDate=" + stDate + ", enDate=" + enDate + ", columnNo=" + columnNo

				+ ", sort=" + sort + "]";

	}

}
