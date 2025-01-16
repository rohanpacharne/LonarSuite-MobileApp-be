package com.lonar.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
 
@JsonInclude(Include.NON_NULL )
public class LtExpExpenseHeaders extends WhoColumns implements Serializable
{
 
	private Long expHeaderId;
	
	private String expenseNumber;
	
	private Date expenseSubmissionDate;
	
	private Long employeeId;
	
	
	private String currencyCode;
	
	private Double exchangeRate;
	
	private Double expenseAmount;
	
	private Long divisionId;
	
	private Long locationId;
	
	private Long costCenterId;
	
	
	private String expenseCategory;
	
	private String purpose;
	
	private Long vendorId;
	
	private Long vendorAddId;
	
	private String requestId;
	
	private String source;
	
	private String sourceRefNo;
	
	private String invoiceNum;
	
	private Date invoiceDate;
	
	private String voucherNum;
	
	private Date voucherDate;
	
	private Date approvedDate;
	
	private Long setOfBooksId;
	
	private Long orgId;
	
	private String status;
	
	private String statusMessage;
	
	private Long companyId;
	
	
	private long initiatorId;
	
	private String locationCode;
	
	private String divisionName;
	
	private String costCenterName;
	
	private String locationName;
	
	private String employeeName;
	
	private String vendorName;
	
	private String expenseStatus;
	
	private String email;
	private String deptName;
	private String stDate;
	private String enDate;
	private String subDate;
	private Long draw;
	
	private Long start;
	
	private Long length;
	
	
	private int columnNo;
 
	
	private String sort;
	
	
	private String valueCode;
	
	
	private String valueName;
	private String token;

	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getStDate() {
		return stDate;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
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
 
	public String getSubDate() {
		return subDate;
	}
 
	public void setSubDate(String subDate) {
		this.subDate = subDate;
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
 
	public String getExpenseStatus() {
		return expenseStatus;
	}
 
	public void setExpenseStatus(String expenseStatus) {
		this.expenseStatus = expenseStatus;
	}
 
	public Double getExpenseAmount() {
		return expenseAmount;
	}
 
	public void setExpenseAmount(Double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
 
	private String currency;
	
	private String currencyCodeWithName;
	
	
	
	private String vendorAddr;
	
	public LtExpExpenseHeaders()
	{
		super();
	}
	
	public long getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(long initiatorId) {
		this.initiatorId = initiatorId;
	}

	public Long getExpHeaderId() {
		return expHeaderId;
	}
 
	public void setExpHeaderId(Long expHeaderId) {
		this.expHeaderId = expHeaderId;
	}
 
	public String getExpenseNumber() {
		return expenseNumber;
	}
 
	public void setExpenseNumber(String expenseNumber) {
		this.expenseNumber = expenseNumber;
	}
 
	public Date getExpenseSubmissionDate() {
		return expenseSubmissionDate;
	}
 
	public void setExpenseSubmissionDate(Date expenseSubmissionDate) {
		this.expenseSubmissionDate = expenseSubmissionDate;
	}
 
	public Long getEmployeeId() {
		return employeeId;
	}
 
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
 
	public String getCurrencyCode() {
		return currencyCode;
	}
 
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
 
	public Double getExchangeRate() {
		return exchangeRate;
	}
 
	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
 
	public Long getDivisionId() {
		return divisionId;
	}
 
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}
 
	public Long getLocationId() {
		return locationId;
	}
 
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
 
	public Long getCostCenterId() {
		return costCenterId;
	}
 
	public void setCostCenterId(Long costCenterId) {
		this.costCenterId = costCenterId;
	}
 
	public String getPurpose() {
		return purpose;
	}
 
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
 
	public Long getVendorId() {
		return vendorId;
	}
 
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
 
	public Long getVendorAddId() {
		return vendorAddId;
	}
 
	public void setVendorAddId(Long vendorAddId) {
		this.vendorAddId = vendorAddId;
	}
 
	public String getRequestId() {
		return requestId;
	}
 
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
 
	public String getSource() {
		return source;
	}
 
	public void setSource(String source) {
		this.source = source;
	}
 
	public String getSourceRefNo() {
		return sourceRefNo;
	}
 
	public void setSourceRefNo(String sourceRefNo) {
		this.sourceRefNo = sourceRefNo;
	}
 
	public String getInvoiceNum() {
		return invoiceNum;
	}
 
	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
 
	public Date getInvoiceDate() {
		return invoiceDate;
	}
 
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
 
	public String getVoucherNum() {
		return voucherNum;
	}
 
	public void setVoucherNum(String voucherNum) {
		this.voucherNum = voucherNum;
	}
 
	public Date getVoucherDate() {
		return voucherDate;
	}
 
	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = voucherDate;
	}
 
	public Date getApprovedDate() {
		return approvedDate;
	}
 
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
 
	public Long getSetOfBooksId() {
		return setOfBooksId;
	}
 
	public void setSetOfBooksId(Long setOfBooksId) {
		this.setOfBooksId = setOfBooksId;
	}
 
	public Long getOrgId() {
		return orgId;
	}
 
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
 
	public String getStatus() {
		return status;
	}
 
	public void setStatus(String status) {
		this.status = status;
	}
 
	public String getStatusMessage() {
		return statusMessage;
	}
 
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
 
	public String getLocationCode() {
		return locationCode;
	}
 
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
 
	public String getDivisionName() {
		return divisionName;
	}
 
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
 
	public String getCostCenterName() {
		return costCenterName;
	}
 
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}
 
	public String getLocationName() {
		return locationName;
	}
 
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
 
	public String getEmployeeName() {
		return employeeName;
	}
 
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
 
	public String getCurrency() {
		return currency;
	}
 
	public void setCurrency(String currency) {
		this.currency = currency;
	}
 
	public String getCurrencyCodeWithName() {
		return currencyCodeWithName;
	}
 
	public void setCurrencyCodeWithName(String currencyCodeWithName) {
		this.currencyCodeWithName = currencyCodeWithName;
	}
 
	public String getVendorName() {
		return vendorName;
	}
 
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
 
	public String getVendorAddr() {
		return vendorAddr;
	}
 
	public void setVendorAddr(String vendorAddr) {
		this.vendorAddr = vendorAddr;
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
 
//	public String getDeptId() {
//		return deptId;
//	}
// 
//	public void setDeptId(String deptId) {
//		this.deptId = deptId;
//	}
 
	
 
	public String getExpenseCategory() {
		return expenseCategory;
	}
 
	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}
 
	
	public String getDeptName() {
		return deptName;
	}
 
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

	public String getValueCode() {
		return valueCode;
	}

	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	
	@Override
	public String toString() {
		return "LtExpExpenseHeaders [expHeaderId=" + expHeaderId + ", expenseNumber=" + expenseNumber
				+ ", expenseSubmissionDate=" + expenseSubmissionDate + ", employeeId=" + employeeId + ", currencyCode="
				+ currencyCode + ", exchangeRate=" + exchangeRate + ", expenseAmount=" + expenseAmount + ", divisionId="
				+ divisionId + ", locationId=" + locationId + ", costCenterId=" + costCenterId + ", expenseCategory="
				+ expenseCategory + ", purpose=" + purpose + ", vendorId=" + vendorId + ", vendorAddId=" + vendorAddId
				+ ", requestId=" + requestId + ", source=" + source + ", sourceRefNo=" + sourceRefNo + ", invoiceNum="
				+ invoiceNum + ", invoiceDate=" + invoiceDate + ", voucherNum=" + voucherNum + ", voucherDate="
				+ voucherDate + ", approvedDate=" + approvedDate + ", setOfBooksId=" + setOfBooksId + ", orgId=" + orgId
				+ ", status=" + status + ", statusMessage=" + statusMessage + ", companyId=" + companyId
				+ ", initiatorId=" + initiatorId + ", locationCode=" + locationCode + ", divisionName=" + divisionName
				+ ", costCenterName=" + costCenterName + ", locationName=" + locationName + ", employeeName="
				+ employeeName + ", vendorName=" + vendorName + ", expenseStatus=" + expenseStatus + ", email=" + email
				+ ", deptName=" + deptName + ", stDate=" + stDate + ", enDate=" + enDate + ", subDate=" + subDate
				+ ", draw=" + draw + ", start=" + start + ", length=" + length + ", columnNo=" + columnNo + ", sort="
				+ sort + ", valueCode=" + valueCode + ", valueName=" + valueName + ", token=" + token
				+ ", currency=" + currency + ", currencyCodeWithName=" + currencyCodeWithName + ", vendorAddr="
				+ vendorAddr + "]";
	}

	
	
}

