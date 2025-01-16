package com.lonar.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
//import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

public class ExpenseApprovalV 
{
	private Long expenseApprovalId;
	private Long moduleApprovalId;
	private Long approvalId;
	private String approvalLevel;
	private String currentApprovalLevel;
	private Long expenseHeaderId;
	private String status;
	private Long delegationId;
	private Date startDate;
	private Date endDate;
	private Long createdBy;
	private Date creationDate;
	private Date lastUpdateDate;
	private String lstDate;
	private Long lastUpdateLogin;
	private Long lastUpdatedBy;
	private Long employeeId;
	private String title;
	private String firstName;
	private String lastName;
	private String employeeNumber;
	private String expenseNumber;
	private String expenseAmount;
	private Long divisionId;
	private String initiatorName;
	private String expenseCategory;
	private Long draw;
	private Long start;
	private Long length;
	private int columnNo;
	private String sort;
	private String action;

	public String getAction() {
		return action;
	}
 
	public void setAction(String action) {
		this.action = action;
	}
 
	public Long getExpenseApprovalId() {
		return expenseApprovalId;
	}
	public void setExpenseApprovalId(Long expenseApprovalId) {
		this.expenseApprovalId = expenseApprovalId;
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
	public Long getExpenseHeaderId() {
		return expenseHeaderId;
	}
	public void setExpenseHeaderId(Long expenseHeaderId) {
		this.expenseHeaderId = expenseHeaderId;
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
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getExpenseNumber() {
		return expenseNumber;
	}
	public void setExpenseNumber(String expenseNumber) {
		this.expenseNumber = expenseNumber;
	}

	public String getExpenseAmount() {
		return expenseAmount;
	}
	public void setExpenseAmount(String expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
	public Long getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}
	public String getInitiatorName() {
		return initiatorName;
	}
	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	public String getLstDate() {
		return lstDate;
	}
	public void setLstDate(String lstDate) {
		this.lstDate = lstDate;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
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
	public String getExpenseCategory() {
		return expenseCategory;
	}
	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}
	@Override
	public String toString() {
		return "ExpenseApprovalV [expenseApprovalId=" + expenseApprovalId + ", moduleApprovalId=" + moduleApprovalId
				+ ", approvalId=" + approvalId + ", approvalLevel=" + approvalLevel + ", currentApprovalLevel="
				+ currentApprovalLevel + ", expenseHeaderId=" + expenseHeaderId + ", status=" + status
				+ ", delegationId=" + delegationId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate
				+ ", lstDate=" + lstDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", employeeId=" + employeeId + ", title=" + title + ", firstName=" + firstName + ", lastName="
				+ lastName + ", employeeNumber=" + employeeNumber + ", expenseNumber=" + expenseNumber
				+ ", expenseAmount=" + expenseAmount + ", divisionId=" + divisionId + ", initiatorName=" + initiatorName
				+ ", expenseCategory=" + expenseCategory + ", draw=" + draw + ", start=" + start + ", length=" + length
				+ ", columnNo=" + columnNo + ", sort=" + sort + "]";
	}

}