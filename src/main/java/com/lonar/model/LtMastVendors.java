package com.lonar.model;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LtMastVendors extends WhoColumns 
{
	
	private Long vendorId;
	private String vendorCode;
	private String vendorName;
	private String status;
	private String panNo;
	private String vendorType;
	private String proprietorName;
	private Long divisionId;
	private Long initiatorId;
	private String remark;
	private String primaryEmail;
	private String registrationEmail;
	private String msmSupplier;
	private String asnApprovalRequired;
	private String msmRegisterationNo;
	private String msmeCategory;
	private String vendorLocationType;
	private Long companyId;
	private String companyCategory;
	private String imagePath;
	private String businessNatureCode;
	private String token;
	
	@Transient
	private String divisionName;

	@Transient
	private String initiatorName;
	
	@Transient
	private String message;
	
	@Transient
	private String CompanyName;

	@Transient
	private String vendorStatus;
	
	@Transient
	private String vendorStatusCode;
	
	@Transient
	private String businessNature;
	
	@Transient
	private String msmeCategoryValue;
	
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getVendorStatusCode() {
		return vendorStatusCode;
	}

	public void setVendorStatusCode(String vendorStatusCode) {
		this.vendorStatusCode = vendorStatusCode;
	}

	public String getBusinessNatureCode() {
		return businessNatureCode;
	}

	public void setBusinessNatureCode(String businessNatureCode) {
		this.businessNatureCode = businessNatureCode;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getProprietorName() {
		return proprietorName;
	}

	public void setProprietorName(String proprietorName) {
		this.proprietorName = proprietorName;
	}

//	public Long getBusinessNatureId() {
//		return businessNatureId;
//	}
//
//	public void setBusinessNatureId(Long businessNatureId) {
//		this.businessNatureId = businessNatureId;
//	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public Long getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(Long initiatorId) {
		this.initiatorId = initiatorId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getInitiatorName() {
		return initiatorName;
	}

	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	public String getMsmSupplier() {
		return msmSupplier;
	}

	public void setMsmSupplier(String msmSupplier) {
		this.msmSupplier = msmSupplier;
	}

	public String getMsmRegisterationNo() {
		return msmRegisterationNo;
	}

	public void setMsmRegisterationNo(String msmRegisterationNo) {
		this.msmRegisterationNo = msmRegisterationNo;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	public String getCompanyCategory() {
		return companyCategory;
	}

	public void setCompanyCategory(String companyCategory) {
		this.companyCategory = companyCategory;
	}

	public String getBusinessNature() {
		return businessNature;
	}

	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}

	public String getAsnApprovalRequired() {
		return asnApprovalRequired;
	}

	public void setAsnApprovalRequired(String asnApprovalRequired) {
		this.asnApprovalRequired = asnApprovalRequired;
	}

	public String getMsmeCategory() {
		return msmeCategory;
	}

	public void setMsmeCategory(String msmeCategory) {
		this.msmeCategory = msmeCategory;
	}

	public String getVendorLocationType() {
		return vendorLocationType;
	}

	public void setVendorLocationType(String vendorLocationType) {
		this.vendorLocationType = vendorLocationType;
	}

	public String getMsmeCategoryValue() {
		return msmeCategoryValue;
	}

	public void setMsmeCategoryValue(String msmeCategoryValue) {
		this.msmeCategoryValue = msmeCategoryValue;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	

	public String getRegistrationEmail() {
		return registrationEmail;
	}

	public void setRegistrationEmail(String registrationEmail) {
		this.registrationEmail = registrationEmail;
	}

	@Override
	public String toString() {
		return "LtMastVendors [vendorId=" + vendorId + ", vendorCode=" + vendorCode + ", vendorName=" + vendorName
				+ ", status=" + status + ", panNo=" + panNo + ", vendorType=" + vendorType + ", proprietorName="
				+ proprietorName + ", divisionId=" + divisionId + ", initiatorId=" + initiatorId + ", remark=" + remark
				+ ", primaryEmail=" + primaryEmail + ", registrationEmail=" + registrationEmail + ", msmSupplier="
				+ msmSupplier + ", asnApprovalRequired=" + asnApprovalRequired + ", msmRegisterationNo="
				+ msmRegisterationNo + ", msmeCategory=" + msmeCategory + ", vendorLocationType=" + vendorLocationType
				+ ", companyId=" + companyId + ", companyCategory=" + companyCategory + ", imagePath=" + imagePath
				+ ", businessNatureCode=" + businessNatureCode + ", token=" + token + ", divisionName=" + divisionName
				+ ", initiatorName=" + initiatorName + ", message=" + message + ", CompanyName=" + CompanyName
				+ ", vendorStatus=" + vendorStatus + ", vendorStatusCode=" + vendorStatusCode + ", businessNature="
				+ businessNature + ", msmeCategoryValue=" + msmeCategoryValue + "]";
	}
	


}

