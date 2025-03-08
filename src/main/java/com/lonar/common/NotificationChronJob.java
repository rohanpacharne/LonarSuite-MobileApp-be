package com.lonar.common;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lonar.model.LtMastLogins;
import com.lonar.model.LtMastNotifications;
import com.lonar.service.LtNotificationService;
import com.lonar.service.LtNotificationServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@EnableScheduling
public class NotificationChronJob {
	
    private static final Logger logger = LoggerFactory.getLogger(NotificationChronJob.class);
    
    @Autowired
    LtNotificationService ltNotificationService;
	
	// The scheduled job runs every 30 seconds
    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
        sendNotificationException();
    }

    // Method to send a notification and handle any exceptions
    private void sendNotificationException() {
        try {
            logger.info("Notification Chron Job called at {}", LocalDateTime.now());
            
            List<LtMastNotifications> list = ltNotificationService.getAllPendingNotifications();
            
            System.out.println("list = "+list);
            
            if(list!=null && !list.isEmpty()) {
            	for(LtMastNotifications ltMastNotifications:list) {
            		if(ltMastNotifications.getUserId()!=null) {
            			
            			List<LtMastLogins> loginList = ltNotificationService.getAllLoginDetails(ltMastNotifications.getUserId());
            			
            			if(loginList!=null && !loginList.isEmpty()) {
            				
            				for(LtMastLogins ltMastLogins:loginList) {
            					System.out.println("ltMastLogins - "+ltMastLogins);
            					int response = LtNotificationServiceImpl.sendNotification(
            							ltMastLogins.getDeviceToken(),
            							ltMastNotifications.getNotificationTitle(),
            							ltMastNotifications.getNotificationBody());
            					
            					if(response==1) {
            						ltNotificationService.updateNotificationStatus(ltMastNotifications.getNotificationId(), "SEND");
            					}
            					else {
            						ltNotificationService.updateNotificationStatus(ltMastNotifications.getNotificationId(), "FAIL TO SEND");
            					}
            				}
            			}
            		}
            		
            	}
//            	
            }
            
        } catch (Exception ex) {
            logger.error("Error occurred while sending notification at {}: {}", LocalDateTime.now(), ex.getMessage(), ex);
        }
    }

}
