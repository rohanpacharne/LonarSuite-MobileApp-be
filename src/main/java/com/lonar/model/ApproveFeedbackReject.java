package com.lonar.model;

public class ApproveFeedbackReject {

	Long employeeId;
	Long expenseApprovalId;
	Long expenseHeaderId;
	String remark;
	String status;
	String token;
	
	Long invoiceApprovalId;
	Long invoiceHeaderId;
	

	Long vendorApprovalId;
	Long vendorId;
	
	
	public Long getVendorApprovalId() {
		return vendorApprovalId;
	}
	public void setVendorApprovalId(Long vendorApprovalId) {
		this.vendorApprovalId = vendorApprovalId;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getExpenseApprovalId() {
		return expenseApprovalId;
	}
	public void setExpenseApprovalId(Long expenseApprovalId) {
		this.expenseApprovalId = expenseApprovalId;
	}
	public Long getExpenseHeaderId() {
		return expenseHeaderId;
	}
	public void setExpenseHeaderId(Long expenseHeaderId) {
		this.expenseHeaderId = expenseHeaderId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ApproveFeedbackReject [employeeId=" + employeeId + ", expenseApprovalId=" + expenseApprovalId
				+ ", expenseHeaderId=" + expenseHeaderId + ", remark=" + remark + ", status=" + status + ", token="
				+ token + ", invoiceApprovalId=" + invoiceApprovalId + ", invoiceHeaderId=" + invoiceHeaderId
				+ ", vendorApprovalId=" + vendorApprovalId + ", vendorId=" + vendorId + "]";
	}
	

	
}
