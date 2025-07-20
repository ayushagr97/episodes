package com.episodes.Episodes.controller;

import com.episodes.Episodes.model.Episode;
import com.episodes.Episodes.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episode")
public class EpisodeController {

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/list")
    public ResponseEntity<List<Episode>> getEpisode(){
         return  episodeService.getAllEpisodees();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Episode> getEpisode(@PathVariable Integer id){
             return episodeService.getEpisodee(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Episode> addEpisode(@RequestBody Episode episode){
        return episodeService.addEpisode(episode);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deltedEpisode(@PathVariable Integer id){
        return  episodeService.deleteEpisode(id);
    }
}
