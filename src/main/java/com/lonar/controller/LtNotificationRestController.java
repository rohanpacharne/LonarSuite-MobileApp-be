package com.lonar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.model.LtInvoiceHeaders;
import com.lonar.model.LtMastLogins;
import com.lonar.model.LtMastNotifications;
import com.lonar.model.LtMastVendors;
import com.lonar.model.Status;
import com.lonar.model.VendorApproval;
import com.lonar.service.LtInvoiceService;
import com.lonar.service.LtNotificationService;
import com.lonar.service.LtNotificationServiceImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/notification")
public class LtNotificationRestController {
	
	@Autowired
	LtNotificationService ltNotificationService;
	
	@PostMapping("/saveLoginDetails")
    public Status saveLoginDetails(@RequestBody LtMastLogins ltMastLogins) {
        return ltNotificationService.saveLoginDetails(ltMastLogins);
	}
	
	@PostMapping("/updateLoginDetails")
    public Status updateLoginDetails(@RequestBody LtMastLogins ltMastLogins) {
        return ltNotificationService.updateLoginDetails(ltMastLogins);
	}
	
	@PostMapping("/getAllNotifications")
    public List<LtMastNotifications> getAllNotifications(@RequestBody LtMastVendors ltMastVendors,
    		@RequestParam Long start, @RequestParam Long length) {
        return ltNotificationService.getAllNotifications(ltMastVendors,start,length);
	}
	
	 // Initialize Firebase once when the application starts
    static {
        try {
        	LtNotificationServiceImpl.initializeFirebase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//  Endpoint to send notifications
    @PostMapping("/send")
    public String sendNotification(@RequestParam String token, 
                                   @RequestParam String title, 
                                   @RequestParam String body) {
        try {
            int response = LtNotificationServiceImpl.sendNotification(token, title, body);
            return "Notification sent successfully. Response: " + response;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send notification: " + e.getMessage();
        }
    }

}
