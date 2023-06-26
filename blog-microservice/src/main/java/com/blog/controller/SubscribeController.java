package com.blog.controller;

import com.blog.entity.BlogDetails;
import com.blog.entity.Subscribe;
import com.blog.service.SubscribeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/subscribe")
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    @PostMapping("/create")
    public ResponseEntity<Subscribe> createSubscribe(@RequestBody Subscribe subscribe) {
        log.info("create(Subscribe) -> | Subscribe : {}",subscribe);
        Subscribe save = subscribeService.create(subscribe);
        log.info("create(Subscribe) -> | After Service : {}",save);
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

    @PutMapping("/unsubcribe")
    public ResponseEntity<String> unSubscribe(@RequestParam String id) {
        log.info("unSubscribe(String) -> | Id : {}",id);
        subscribeService.unSubscribe(id);
        log.info("unScribe(String) -> | Id : {} | Completed",id);
        return new ResponseEntity<>("You have Unsubscribed from the services with id " + id + ". Hence you are unable to recieve the updates", HttpStatus.OK);
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<Subscribe> findSubscribeByEmail(@RequestParam String email) {
        log.info("findSubscribeByEmail() -> | ");
        Subscribe subscribe = subscribeService.findSubscribeByEmail(email);
        log.info("findSubscribeByEmail() -> | Subscribe : {}", subscribe);
        return new ResponseEntity<>(subscribe, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void subscribeDeleteById(@RequestParam String id) {
        log.info("subscribeDeleteById(String) -> | Id : {}",id);
        subscribeService.subscribeDeleteById(id);
        log.info("subscribeDeleteById(String) -> | Id : {} | Completed",id);
    }
}
