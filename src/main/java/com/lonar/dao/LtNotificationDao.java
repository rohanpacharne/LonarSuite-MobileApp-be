package com.lonar.dao;

import java.util.List;

import com.lonar.model.LtMastLogins;
import com.lonar.model.LtMastNotifications;

public interface LtNotificationDao {
	
	List<LtMastNotifications> getAllPendingNotifications();
	
	List<LtMastLogins> getAllLoginDetails(Long userId);
	
	int updateNotificationStatus(Long notificationId,String status);
	
	int updateReadFlag(Long id,String module);


}
