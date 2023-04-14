package com.example.demo.controller;

import com.example.demo.model.DemoUser;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<DemoUser> getAllUsers() {
        LOG.info("Getting all users.");
        return (List<DemoUser>) userRepository.findAll();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public DemoUser getUser(@PathVariable Long userId) {
        LOG.info("Getting user with ID: {}.", userId);
        if (userRepository.findById(userId).isPresent()) {
            return userRepository.findById(userId).get();
        }
        return null;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DemoUser addNewUsers(@RequestBody DemoUser user) {
        LOG.info("Saving user.");
        return userRepository.save(user);
    }

}
