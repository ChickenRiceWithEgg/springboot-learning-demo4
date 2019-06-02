package com.xjw.demo4.controller;

import com.xjw.demo4.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private Person person;

    @GetMapping("/person")
    public String helloPerson(){
        log.info(person.toString());
        return person.toString();
    }
}
