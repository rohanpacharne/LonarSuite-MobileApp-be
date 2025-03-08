package com.lonar.model;

import java.util.Date;

public class LtMastLogins {

    private int loginId;

    private Integer userId;

    private String deviceToken;

    private String deviceType;

    private String ipAddress;

    private Date loginDate;

    private Date logoutDate;

    private String status;

    private Date creationDate;
    
    private Integer createdBy;

    private Date lastUpdateDate;

    private Integer lastUpdateLogin;

    private Integer lastUpdatedBy;
    
    private String token;

    // Getters and Setters
    
    

    public int getLoginId() {
        return loginId;
    }

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(Integer lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

	@Override
	public String toString() {
		return "LtMastLogins [loginId=" + loginId + ", userId=" + userId + ", deviceToken=" + deviceToken
				+ ", deviceType=" + deviceType + ", ipAddress=" + ipAddress + ", loginDate=" + loginDate
				+ ", logoutDate=" + logoutDate + ", status=" + status + ", creationDate=" + creationDate
				+ ", createdBy=" + createdBy + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateLogin="
				+ lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy + ", token=" + token + "]";
	}
}

