package com.mosdev.restapi.controllers;


import com.mosdev.restapi.domain.Affiche;
import com.mosdev.restapi.repos.AfficheRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RestApiController {

    private AfficheRepo afficheRepo;

    @Autowired
    public void setAfficheRepo(AfficheRepo afficheRepo) {
        this.afficheRepo = afficheRepo;
    }


    @GetMapping("/poster")
    public Object getHelloMessage(Map<String, Object> map){
        return afficheRepo.findAll();

    }
}
