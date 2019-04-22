package com.mosdev.restapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mosdev.restapi.domain.*;
import com.mosdev.restapi.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Element;
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
    private final HistoryRepo historyRepo;
    private final ArtistsRepo artistsRepo;
    private final LeadersRepo leadersRepo;
    private final QuizAnswerRepo quizAnswerRepo;

    @Autowired
    public RestApiController(AfficheRepo afficheRepo, EventsRepo eventsRepo, AdsRepo adsRepo, QuizRepo quizRepo, HistoryRepo historyRepo, ArtistsRepo artistsRepo, LeadersRepo leadersRepo, QuizAnswerRepo quizAnswerRepo) {
        this.afficheRepo = afficheRepo;
        this.eventsRepo = eventsRepo;
        this.adsRepo = adsRepo;
        this.quizRepo = quizRepo;
        this.historyRepo = historyRepo;
        this.artistsRepo = artistsRepo;
        this.leadersRepo = leadersRepo;
        this.quizAnswerRepo = quizAnswerRepo;
    }
    @GetMapping("/poster")
    public Object getPoster(Map<Affiche, Long> list){
        return afficheRepo.findAll();
    }

    @PostMapping("/quizResults")
    public Object quizResults(@RequestBody String quizResults){
        ArrayList list = new ArrayList();
        try {
            ObjectMapper or = new ObjectMapper();
            list = or.readValue(quizResults, ArrayList.class);
        }catch (IOException e){
            e.printStackTrace();
        }

        int answerCount = 0;
        int i;
        for (i = 0; i < list.size(); i++){
            Long answerId = ((Integer)list.get(i)).longValue();
            QuizAnswer answer = quizAnswerRepo.getOne(answerId);
            if (answer.getIs_correct()) {
                answerCount++;
            }
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("allAnswers", i);
        result.put("correctAnswers", answerCount);

        return result;
    }

    @GetMapping("/events")
    public Object getEvents(){

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

    @GetMapping("/about")
    public Object getAbout(){
        Map<String, List> allAbout = new HashMap<>();
        allAbout.put("history", historyRepo.findAll());
        allAbout.put("leaders", leadersRepo.findAll());
        allAbout.put("artists", artistsRepo.findAll());
        return new ResponseEntity<>(allAbout, HttpStatus.OK);
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
