package com.lonar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lonar.dao.LtNotificationDao;
import com.lonar.model.CodeMaster;
import com.lonar.model.LtMastLogins;
import com.lonar.model.LtMastNotifications;
import com.lonar.model.LtMastVendors;
import com.lonar.model.Status;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class LtNotificationServiceImpl implements LtNotificationService,CodeMaster {
	
	@Autowired
	LtNotificationDao ltNotificationDao;
	
	private final RestTemplate restTemplate = new RestTemplate();
	long currentTimestamp = System.currentTimeMillis();
//	private static String filePath = "D:\\LonarSuite Doc\\lonarsuite-mobile-application-firebase-adminsdk-fbsvc-b771f3037e.json";
	private static String filePath = "C:\\Users\\Admin\\Downloads\\lonarsuite-mobile-application-firebase-adminsdk-fbsvc-b771f3037e.json";


	@Override
	public Status saveLoginDetails(LtMastLogins ltMastLogins) {
		// TODO Auto-generated method stub
		String apiUrl = userMangementIp + "/UserManagement/oauth/saveLoginDetails";

		try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        //headers.set("Authorization", "Bearer " + token); // Added Authorization header
	        headers.set("access_token", ltMastLogins.getToken());
	        headers.set("Content-Type", "application/json");

	        HttpEntity<LtMastLogins> entity = new HttpEntity<>(ltMastLogins,headers); // Added HttpEntity with headers

	        ResponseEntity<Status> response = restTemplate.exchange(
	                apiUrl,
	                HttpMethod.POST, 
	                entity,
	                Status.class
	        );
	        
	        return response.getBody();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
	    }
	}

	@Override
	public Status updateLoginDetails(LtMastLogins ltMastLogins) {
		// TODO Auto-generated method stub
		String apiUrl = userMangementIp + "/UserManagement/oauth/updateLoginDetails";

		try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        //headers.set("Authorization", "Bearer " + token); // Added Authorization header
	        headers.set("access_token", ltMastLogins.getToken());
	        headers.set("Content-Type", "application/json");

	        HttpEntity<LtMastLogins> entity = new HttpEntity<>(ltMastLogins,headers); // Added HttpEntity with headers

	        ResponseEntity<Status> response = restTemplate.exchange(
	                apiUrl,
	                HttpMethod.POST, 
	                entity,
	                Status.class
	        );
	        
	        return response.getBody();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
	    }
	}
	
	 // Initialize Firebase with your service account credentials
    public static void initializeFirebase() throws IOException {
        FileInputStream serviceAccount = 
            new FileInputStream(filePath); // Path to your Firebase JSON credentials

        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();

        FirebaseApp.initializeApp(options);
    }

    @Override
    public List<LtMastNotifications> getAllNotifications(LtMastVendors ltMastVendors,Long start, Long length) {
        String apiUrl = lVendorMasterIp + "/lvendormaster/API/Inbox/getapprovalnotification/" + ltMastVendors.getUserId() + "/" + currentTimestamp + "?start="+start+"&length="+length;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("access_token", ltMastVendors.getToken());
            headers.set("Content-Type", "application/json");

            HttpEntity<LtMastVendors> entity = new HttpEntity<>(ltMastVendors, headers);

            // Use ParameterizedTypeReference to handle List<LtMastVendors> response
            ResponseEntity<List<LtMastNotifications>> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<LtMastNotifications>>() {} // Correct response type
            );

            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
        }
    }


 // Send notification using FCM
    public static int sendNotification(String token, String title, String body) {
        try {
            // Create the notification
            Notification notification = Notification.builder()
                    .setTitle(title)
                    .setBody(body)
                    .build();
            
//          Set up Android-specific options (this will add the sound)
            AndroidConfig androidConfig = AndroidConfig.builder()
                    .setNotification(AndroidNotification.builder()
                            .setSound("default")  // You can specify a custom sound file here
                            .setPriority(AndroidNotification.Priority.HIGH)
                            .build())
                    .build();

            // Create the message
            Message message = Message.builder()
                    .setNotification(notification)
                    .setToken(token)
                    .setAndroidConfig(androidConfig)  // Add Android-specific configuration (sound, etc.)
                    .build();

            // Send the notification and get the response
            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Response - " + response);

            // Return 1 if successful
            return 1;
        } catch (Exception e) {
            // Log the exception if any
        	e.printStackTrace();
            System.out.println("Failed to send notification: " + e.getMessage());
            
            // Return 0 if failed
            return 0;
        }
    }

	@Override
	public List<LtMastNotifications> getAllPendingNotifications() {
		// TODO Auto-generated method stub
		return ltNotificationDao.getAllPendingNotifications();
	}

	@Override
	public List<LtMastLogins> getAllLoginDetails(Long userId) {
		// TODO Auto-generated method stub
		return ltNotificationDao.getAllLoginDetails(userId);
	}

	@Override
	public int updateNotificationStatus(Long notificationId, String status) {
		// TODO Auto-generated method stub
		return ltNotificationDao.updateNotificationStatus(notificationId, status);
	}

	@Override
	public int updateReadFlag(Long id, String module) {
		// TODO Auto-generated method stub
		return ltNotificationDao.updateReadFlag(id, module);
	}

}
