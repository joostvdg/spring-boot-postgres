package com.example.demo.controller;

import com.example.demo.model.Hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Hello sayHello() {
        LOG.info("Saying hello");
        return new Hello("Hello DHL");
    }

}
