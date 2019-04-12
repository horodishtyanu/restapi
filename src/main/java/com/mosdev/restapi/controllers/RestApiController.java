package com.mosdev.restapi.controllers;

import com.mosdev.restapi.domain.Affiche;
import com.mosdev.restapi.domain.Events;
import com.mosdev.restapi.repos.AfficheRepo;
import com.mosdev.restapi.repos.EventsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@RestController
public class RestApiController {

    private final AfficheRepo afficheRepo;
    private final EventsRepo eventsRepo;
    @Autowired
    public RestApiController(AfficheRepo afficheRepo, EventsRepo eventsRepo) {
        this.afficheRepo = afficheRepo;
        this.eventsRepo = eventsRepo;
    }
    @GetMapping("/poster")
    public Object getPoster(Map<Affiche, Long> list){
        return afficheRepo.findAll();
    }

    @GetMapping("/events")
    public Object getEvents(Map<Events, Long> map){
        return eventsRepo.findAll();
    }

    @GetMapping("/test")
    public Object test(){

        Map<String, Object> myArr = new HashMap<>();
        myArr.put("Events", eventsRepo.findAll());
        myArr.put("Posters", afficheRepo.findAll().get(0));
        return myArr;
    }

    @GetMapping("/downFile")
    public void downloadFile(HttpServletResponse response) throws IOException {
        File file = new File("C:\\Users\\Alexander\\Desktop\\baner_bags.png");

        String fileName = file.getName();
        Path filePath = file.toPath();
        String mediaType = Files.probeContentType(filePath);

        response.setContentType(mediaType);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+fileName);
        response.setContentLength((int)file.length());

        BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        outStream.flush();
        inStream.close();
    }
}
