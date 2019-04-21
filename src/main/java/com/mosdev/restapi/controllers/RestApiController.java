package com.mosdev.restapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mosdev.restapi.domain.Ads;
import com.mosdev.restapi.domain.Affiche;
import com.mosdev.restapi.domain.Events;
import com.mosdev.restapi.domain.Quiz;
import com.mosdev.restapi.repos.AdsRepo;
import com.mosdev.restapi.repos.AfficheRepo;
import com.mosdev.restapi.repos.EventsRepo;
import com.mosdev.restapi.repos.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@RestController
public class RestApiController {

    private final AfficheRepo afficheRepo;
    private final EventsRepo eventsRepo;
    private final AdsRepo adsRepo;
    private final QuizRepo quizRepo;
    private Object o1;

    @Autowired
    public RestApiController(AfficheRepo afficheRepo, EventsRepo eventsRepo, AdsRepo adsRepo, QuizRepo quizRepo) {
        this.afficheRepo = afficheRepo;
        this.eventsRepo = eventsRepo;
        this.adsRepo = adsRepo;
        this.quizRepo = quizRepo;
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

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        List<Map<String,String>> result = new ArrayList<>();
        List<Object> all = new ArrayList<>();
        all.addAll(eventsRepo.findAll());
        all.addAll(adsRepo.findAll());
        all.addAll(quizRepo.findAll());


        try {
            for (Object item:all
                 ) {
                String json = ow.writeValueAsString(item);
                Map<String, String> myArr = new HashMap<>();
                if (item instanceof Events){
                    myArr.put("type", ((Events)item).getType());
                    myArr.put("sort", ((Events)item).getSort().toString());
                }else if(item instanceof Ads){
                    myArr.put("type", ((Ads)item).getType());
                    myArr.put("sort", ((Ads)item).getSort().toString());
                }else if(item instanceof Quiz){
                    myArr.put("type", ((Quiz)item).getType());
                    myArr.put("sort", ((Quiz)item).getSort().toString());
                }
                myArr.put("object", json);
                result.add(myArr);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        result.sort((Comparator.comparing(o -> o.get("sort"))));
        return new ResponseEntity<>(result, HttpStatus.OK);
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
