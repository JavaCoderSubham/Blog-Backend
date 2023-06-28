package com.blog.subscribe.controller;

import java.util.List;

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
import com.blog.subscribe.service.EmailSenderService;
import com.blog.subscribe.service.SubscribeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/subscribe")
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;
    
    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/create")
    public ResponseEntity<Subscribe> createSubscribe(@RequestBody Subscribe subscribe) {
        log.info("create(Subscribe) -> | Subscribe : {}",subscribe);
        Subscribe save = subscribeService.create(subscribe);
        log.info("create(Subscribe) -> | After Service : {}",save);
        emailSenderService.sendSimpleEmail(subscribe.getEmail(), "Congratulations " + subscribe.getName() + ", you have subscribed successfully to our updates. Thankyou for subscribing to our services.", "Blog Subscription");
        log.info("sendSimpleEmail() -> | Registration email sent successfully.");
        return new ResponseEntity<Subscribe>(save, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Subscribe>> getAllSubscribers() {
        log.info("============ Get All Method Start ============");
        log.info("getAllSubscribe() -> | ");
        List<Subscribe> all = subscribeService.getAllSubscribe();
        log.info("getAllSubscribe() -> | List Subscribe : {}",all);
        log.info("============ Get All Method End ============");
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PutMapping("/unsubcribe/{id}")
    public ResponseEntity<String> unSubscribe(@PathVariable String id) {
        log.info("unSubscribe(String) -> | Id : {}",id);
        subscribeService.unSubscribe(id);
        log.info("unScribe(String) -> | Id : {} | Completed",id);
        return new ResponseEntity<>("You have Unsubscribed from the services with id " + id + ". Hence you are unable to recieve the updates", HttpStatus.OK);
    }

    @GetMapping("/findbyemail/{email}")
    public ResponseEntity<Subscribe> findSubscribeByEmail(@PathVariable String email) {
        log.info("findSubscribeByEmail() -> | ");
        Subscribe subscribe = subscribeService.findSubscribeByEmail(email);
        log.info("findSubscribeByEmail() -> | Subscribe : {}", subscribe);
        return new ResponseEntity<>(subscribe, HttpStatus.OK);
    }
    
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Subscribe> findSubscribeById(@PathVariable String id) {
        log.info("findSubscribeById() -> | ");
        Subscribe subscribe = subscribeService.findSubscribeById(id);
        log.info("findSubscribeById() -> | Subscribe : {}", subscribe);
        return new ResponseEntity<>(subscribe, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSubscribeById(@PathVariable String id) {
        log.info("deleteSubscribeById(String) -> | Id : {}",id);
        subscribeService.deleteSubscribeById(id);
        log.info("deleteSubscribeById(String) -> | Id : {} | Completed",id);
        return "User deleted successfully with id " + id;
    }
    
    @DeleteMapping("/delete/{email}")
    public String deleteSubscribeByEmail(@PathVariable String email) {
        log.info("deleteSubscribeByEmail(String) -> | Email : {}",email);
        subscribeService.deleteSubscribeByEmail(email);
        log.info("deleteSubscribeByEmail(String) -> | Email : {} | Completed",email);
        return "User deleted successfully with email " + email;
    }
}
