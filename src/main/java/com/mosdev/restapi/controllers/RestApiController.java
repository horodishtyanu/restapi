package com.mosdev.restapi.controllers;

import com.mosdev.restapi.domain.Affiche;
import com.mosdev.restapi.repos.AfficheRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RestApiController {

    private final AfficheRepo afficheRepo;


    @Autowired
    public RestApiController(AfficheRepo afficheRepo) {
        this.afficheRepo = afficheRepo;
    }

    @GetMapping("/poster")
    public Object getPoster(Map<Affiche, Long> list){
        return afficheRepo.findAll();
    }
}
