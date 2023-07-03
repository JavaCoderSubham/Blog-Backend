package com.blog.subscribe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.subscribe.entity.Subscribe;
import com.blog.subscribe.service.EmailSenderServiceImpl;
import com.blog.subscribe.service.SubscribeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/subscribe")
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;
    
    @Autowired
    private EmailSenderServiceImpl emailSenderService;

    //Create Subscriber
    @PostMapping("/create")
    public ResponseEntity<Subscribe> createSubscribe(@RequestBody Subscribe subscribe) {
    	log.info("==========createSubscribe Started=============");
        log.info("create(Subscribe) -> | Subscribe : {}",subscribe);
        Subscribe save = subscribeService.create(subscribe);
        log.info("create(Subscribe) -> | After Service : {}",save);
        emailSenderService.sendSimpleEmail(subscribe.getEmail(), "Congratulations " + subscribe.getName() + ", you have subscribed successfully to our updates. Thankyou for subscribing to our services.", "Blog Subscription");
        log.info("sendSimpleEmail() -> | Registration email sent successfully.");
        log.info("==========createSubscribe Endeded=============");
        return new ResponseEntity<Subscribe>(save, HttpStatus.CREATED);
    }

    //Get All Subscribers
    @GetMapping("/getAll")
    public ResponseEntity<List<Subscribe>> getAllSubscribers() {
        log.info("============ Get All Method Start ============");
        log.info("getAllSubscribe() -> | ");
        List<Subscribe> all = subscribeService.getAllSubscribe();
        log.info("getAllSubscribe() -> | List Subscribe : {}",all);
        log.info("============ Get All Method End ============");
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    
    //Unsubscribe By Id
    @PutMapping("/unsubcribebyid/{id}")
    public ResponseEntity<Map<String, String>> unSubscribeById(@PathVariable String id) {
    	log.info("==========unSubscribeById Started=============");
        log.info("unSubscribeById(String) -> | Id : {}",id);
        subscribeService.unSubscribeById(id);
        log.info("unSubcribeById(String) -> | Id : {} | Completed",id);
        Map<String, String> map = new HashMap<>();
        map.put("message", "You have Unsubscribed from the services with id " + id + ". Hence you are unable to recieve the updates");
        log.info("==========unSubscribeById Endeded=============");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
    //Unsubscribe By Email
    @PutMapping("/unsubcribebyemail/{email}")
    public ResponseEntity<Map<String, String>> unSubscribeByEmail(@PathVariable String email) {
    	log.info("===========unSubscribeByEmail Started=============");
        log.info("unSubscribeByEmail(String) -> | Email : {}", email);
        subscribeService.unSubscribeByEmail(email);
        log.info("unSubcribeByEmail(String) -> | Email : {} | Completed", email);
        Map<String, String> map = new HashMap<>();
        map.put("message", "You have Unsubscribed from the services with email " + email + ". Hence you are unable to recieve the updates");
        log.info("==========unSubscribeByEmail Endeded=============");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
    //Unsubscribe By Mobile Number
    @PutMapping("/unsubcribebymobile/{mobileNumber}")
    public ResponseEntity<Map<String, String>> unSubscribeByMobileNumber(@PathVariable String mobileNumber) {
    	log.info("============unSubscribeByMobile Started=============");
        log.info("unSubscribeByMobileNumber(String) -> | Mobile Number : {}", mobileNumber);
        subscribeService.unSubscribeByMobileNumber(mobileNumber);
        log.info("unSubcribeByMobileNumber(String) -> | Mobile Number : {} | Completed", mobileNumber);
        Map<String, String> map = new HashMap<>();
        map.put("message", "You have Unsubscribed from the services with mobile number " + mobileNumber + ". Hence you are unable to recieve the updates");
        log.info("============unSubscribeByMobile Ended===============");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    //Find By Email
    @GetMapping("/findbyemail/{email}")
    public ResponseEntity<Subscribe> findSubscribeByEmail(@PathVariable String email) {
    	log.info("============findSubscribeByEmail Started=============");
        log.info("findSubscribeByEmail() -> | ");
        Subscribe subscribe = subscribeService.findSubscribeByEmail(email);
        log.info("findSubscribeByEmail() -> | Subscribe : {}", subscribe);
        log.info("============findSubscribeByEmail Ended=============");
        return new ResponseEntity<>(subscribe, HttpStatus.OK);
    }
    
    //Find By Id
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Subscribe> findSubscribeById(@PathVariable String id) {
    	log.info("============findSubscribeById Started=============");
        log.info("findSubscribeById() -> | ");
        Subscribe subscribe = subscribeService.findSubscribeById(id);
        log.info("findSubscribeById() -> | Subscribe : {}", subscribe);
        log.info("============findSubscribeById Ended=============");
        return new ResponseEntity<>(subscribe, HttpStatus.OK);
    }
    
    //Find By Mobile Number
    @GetMapping("/findbymobile/{mobileNumber}")
    public ResponseEntity<Subscribe> findSubscribeByMobileNumber(@PathVariable String mobileNumber) {
    	log.info("============findSubscribeByMobileNumber Started=============");
        log.info("findSubscribeByMobileNumber() -> | ");
        Subscribe subscribe = subscribeService.findSubscribeByMobileNumber(mobileNumber);
        log.info("findSubscribeByMobileNumber() -> | Subscribe : {}", subscribe);
        log.info("============findSubscribeByMobileNumber Ended=============");
        return new ResponseEntity<>(subscribe, HttpStatus.OK);
    }

    //Delete By Id
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<Map<String, String>> deleteSubscribeById(@PathVariable String id) {
    	log.info("============deleteSubscribeById Started=============");
        log.info("deleteSubscribeById(String) -> | Id : {}",id);
        subscribeService.deleteSubscribeById(id);
        log.info("deleteSubscribeById(String) -> | Id : {} | Completed",id);
        Map<String, String> map = new HashMap<>();
        map.put("message", "You have successfully deleted with id " + id);
        log.info("============deleteSubscribeById Ended=============");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
    //Delete By Email
    @DeleteMapping("/deletebyemail/{email}")
    public String deleteSubscribeByEmail(@PathVariable String email) {
    	log.info("============deleteSubscribeByEmail Started=============");
        log.info("deleteSubscribeByEmail(String) -> | Email : {}",email);
        subscribeService.deleteSubscribeByEmail(email);
        log.info("deleteSubscribeByEmail(String) -> | Email : {} | Completed",email);
        log.info("============deleteSubscribeByEmail Ended=============");
        return "User deleted successfully with email " + email;
    }
}
