package com.lonar.model;

import java.util.Date;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LtInvoiceHeaders {
	
	private Long invoiceHeaderId;
	private String internalInvoiceNumber;
	private String invoiceType;
	private String invoiceNum;
	private Date invoiceDate;
	private Date invoiceReceivedDate;
	private Long poHeaderId;
	private Long buyerId;
	private Long vendorId;
	private Long vendorAddId;
	private String description;
	private Double invoiceAmount;
	private Long billingAddId;
	private Long shippingAddId;
	private String status;
	private Double amountPaid;
	private String voucherNum;
	private Date voucherDate;
	private String invoiceCurrency;
	private String source;
	private String sourceRefNo;
	private Long createdBy;
	private Date creationDate;
	private Long lastUpdateLogin;
	private Long lastUpdatedBy;
	private Date lastUpdateDate;
	private Double exchangeRate;
	private Double baseAmount;
	private Long initiatorId;
	private Long divisionId;
	private Long paytermId;
	private Long companyId;
	private String token;
	
	
	
	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;

	@Transient
	private String iDate;
	
	@Transient
	private String revDate;
	
	@Transient
	private int columnNo;
	
	@Transient
	private String sort;

	@Transient
	private String buyer;
	
	@Transient
	private String invoiceStatus;
	
	@Transient
	private String type;
	
	@Transient
	private String vendorName;
	
	@Transient
	private String initiatorName;
	
	@Transient
	private String divisionName;
	
	@Transient
	private String poNumber;
	
	@Transient
	private Double poAmount;
	
	@Transient
	private String valueCode;
	
	@Transient
	private String valueName;
	
	@Transient
	private Long approvalId;
	
	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

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

	public Long getInvoiceHeaderId() {
		return invoiceHeaderId;
	}

	public void setInvoiceHeaderId(Long invoiceHeaderId) {
		this.invoiceHeaderId = invoiceHeaderId;
	}

	public String getInternalInvoiceNumber() {
		return internalInvoiceNumber;
	}

	public void setInternalInvoiceNumber(String internalInvoiceNumber) {
		this.internalInvoiceNumber = internalInvoiceNumber;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
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

	public Date getInvoiceReceivedDate() {
		return invoiceReceivedDate;
	}

	public void setInvoiceReceivedDate(Date invoiceReceivedDate) {
		this.invoiceReceivedDate = invoiceReceivedDate;
	}

	public Long getPoHeaderId() {
		return poHeaderId;
	}

	public void setPoHeaderId(Long poHeaderId) {
		this.poHeaderId = poHeaderId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Long getBillingAddId() {
		return billingAddId;
	}

	public void setBillingAddId(Long billingAddId) {
		this.billingAddId = billingAddId;
	}

	public Long getShippingAddId() {
		return shippingAddId;
	}

	public void setShippingAddId(Long shippingAddId) {
		this.shippingAddId = shippingAddId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
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

	public String getInvoiceCurrency() {
		return invoiceCurrency;
	}

	public void setInvoiceCurrency(String invoiceCurrency) {
		this.invoiceCurrency = invoiceCurrency;
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

	public String getiDate() {
		return iDate;
	}

	public void setiDate(String iDate) {
		this.iDate = iDate;
	}

	public String getRevDate() {
		return revDate;
	}

	public void setRevDate(String revDate) {
		this.revDate = revDate;
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

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(Double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public Long getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(Long initiatorId) {
		this.initiatorId = initiatorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public Long getPaytermId() {
		return paytermId;
	}

	public void setPaytermId(Long paytermId) {
		this.paytermId = paytermId;
	}

	public String getInitiatorName() {
		return initiatorName;
	}

	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public Double getPoAmount() {
		return poAmount;
	}

	public void setPoAmount(Double poAmount) {
		this.poAmount = poAmount;
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
		return "LtInvoiceHeaders [invoiceHeaderId=" + invoiceHeaderId + ", internalInvoiceNumber="
				+ internalInvoiceNumber + ", invoiceType=" + invoiceType + ", invoiceNum=" + invoiceNum
				+ ", invoiceDate=" + invoiceDate + ", invoiceReceivedDate=" + invoiceReceivedDate + ", poHeaderId="
				+ poHeaderId + ", buyerId=" + buyerId + ", vendorId=" + vendorId + ", vendorAddId=" + vendorAddId
				+ ", description=" + description + ", invoiceAmount=" + invoiceAmount + ", billingAddId=" + billingAddId
				+ ", shippingAddId=" + shippingAddId + ", status=" + status + ", amountPaid=" + amountPaid
				+ ", voucherNum=" + voucherNum + ", voucherDate=" + voucherDate + ", invoiceCurrency=" + invoiceCurrency
				+ ", source=" + source + ", sourceRefNo=" + sourceRefNo + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", exchangeRate=" + exchangeRate + ", baseAmount=" + baseAmount
				+ ", initiatorId=" + initiatorId + ", divisionId=" + divisionId + ", paytermId=" + paytermId
				+ ", companyId=" + companyId + ", token=" + token + ", approvalId=" + approvalId + ", draw=" + draw
				+ ", start=" + start + ", length=" + length + ", iDate=" + iDate + ", revDate=" + revDate
				+ ", columnNo=" + columnNo + ", sort=" + sort + ", buyer=" + buyer + ", invoiceStatus=" + invoiceStatus
				+ ", type=" + type + ", vendorName=" + vendorName + ", initiatorName=" + initiatorName
				+ ", divisionName=" + divisionName + ", poNumber=" + poNumber + ", poAmount=" + poAmount
				+ ", valueCode=" + valueCode + ", valueName=" + valueName + "]";
	}
	
}
