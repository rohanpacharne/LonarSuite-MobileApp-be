package com.lonar.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

@JsonInclude(Include.NON_NULL)
public class LtVendorApproval {
	
	private Long vendorApprovalId;
	private Long invoiceApprovalId;
	private Long moduleApprovalId;
	private Long approvalId;
	private String approvalLevel;
	private String currentApprovalLevel;
	private Long vendorId;
	private Long invoiceHeaderId;
	private String status;
	private Long delegationId;
	private Date startDate;
	private Date endDate;
	private Long createdBy;
	private Date creationDate;
	private Date lastUpdateDate;
	private Long lastUpdateLogin;
	private Long lastUpdatedBy;
	private String approvalName;
	private String approvalLevelName;
	private String expenseNumber;
	private Double expenseAmount;
	private String initiatorName;
	private Long moduleAppEmployeesId;
	@Transient
	private Long employeesId;

	public Long getInvoiceApprovalId() {
		return invoiceApprovalId;
	}

	public void setInvoiceApprovalId(Long invoiceApprovalId) {
		this.invoiceApprovalId = invoiceApprovalId;
	}

	public Long getInvoiceHeaderId() {
		return invoiceHeaderId;
	}

	public void setInvoiceHeaderId(Long invoiceHeaderId) {
		this.invoiceHeaderId = invoiceHeaderId;
	}

	public Long getVendorApprovalId() {
		return vendorApprovalId;
	}

	public void setVendorApprovalId(Long vendorApprovalId) {
		this.vendorApprovalId = vendorApprovalId;
	}

	public Long getModuleApprovalId() {
		return moduleApprovalId;
	}

	public void setModuleApprovalId(Long moduleApprovalId) {
		this.moduleApprovalId = moduleApprovalId;
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalLevel() {
		return approvalLevel;
	}

	public void setApprovalLevel(String approvalLevel) {
		this.approvalLevel = approvalLevel;
	}

	public String getCurrentApprovalLevel() {
		return currentApprovalLevel;
	}

	public void setCurrentApprovalLevel(String currentApprovalLevel) {
		this.currentApprovalLevel = currentApprovalLevel;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getDelegationId() {
		return delegationId;
	}

	public void setDelegationId(Long delegationId) {
		this.delegationId = delegationId;
	}

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

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
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

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getApprovalLevelName() {
		return approvalLevelName;
	}

	public void setApprovalLevelName(String approvalLevelName) {
		this.approvalLevelName = approvalLevelName;
	}

	public String getExpenseNumber() {
		return expenseNumber;
	}

	public void setExpenseNumber(String expenseNumber) {
		this.expenseNumber = expenseNumber;
	}

	public Double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(Double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public String getInitiatorName() {
		return initiatorName;
	}

	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	public Long getModuleAppEmployeesId() {
		return moduleAppEmployeesId;
	}

	public void setModuleAppEmployeesId(Long moduleAppEmployeesId) {
		this.moduleAppEmployeesId = moduleAppEmployeesId;
	}

	public Long getEmployeesId() {
		return employeesId;
	}

	public void setEmployeesId(Long employeesId) {
		this.employeesId = employeesId;
	}

	@Override
	public String toString() {
		return "LtVendorApproval [vendorApprovalId=" + vendorApprovalId + ", invoiceApprovalId=" + invoiceApprovalId
				+ ", moduleApprovalId=" + moduleApprovalId + ", approvalId=" + approvalId + ", approvalLevel="
				+ approvalLevel + ", currentApprovalLevel=" + currentApprovalLevel + ", vendorId=" + vendorId
				+ ", invoiceHeaderId=" + invoiceHeaderId + ", status=" + status + ", delegationId=" + delegationId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateLogin=" + lastUpdateLogin
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", approvalName=" + approvalName + ", approvalLevelName="
				+ approvalLevelName + ", expenseNumber=" + expenseNumber + ", expenseAmount=" + expenseAmount
				+ ", initiatorName=" + initiatorName + ", moduleAppEmployeesId=" + moduleAppEmployeesId
				+ ", employeesId=" + employeesId + "]";
	}

	
	
	
}
