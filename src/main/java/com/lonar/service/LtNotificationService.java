package com.lonar.service;

import java.util.List;

import com.lonar.model.LtMastLogins;
import com.lonar.model.LtMastNotifications;
import com.lonar.model.LtMastVendors;
import com.lonar.model.Status;
import com.lonar.model.VendorApproval;

public interface LtNotificationService {
	
	public Status saveLoginDetails(LtMastLogins ltMastLogins);
	
	public Status updateLoginDetails(LtMastLogins ltMastLogins);
	
	public List<LtMastNotifications> getAllNotifications(LtMastVendors ltMastVendors,Long start, Long length);
	
	List<LtMastNotifications> getAllPendingNotifications();
	
	List<LtMastLogins> getAllLoginDetails(Long userId);
	
	int updateNotificationStatus(Long notificationId,String status);
	
	int updateReadFlag(Long id,String module);





}
