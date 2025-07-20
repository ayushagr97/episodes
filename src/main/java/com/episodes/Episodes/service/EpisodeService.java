package com.episodes.Episodes.service;

import com.episodes.Episodes.model.Episode;
import com.episodes.Episodes.repos.EpisodeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {


    @Autowired
    private EpisodeRepos repos;

    public ResponseEntity<List<Episode>> getAllEpisodees(){
        List<Episode> epList= repos.findAll();
        return new ResponseEntity<>(epList, HttpStatus.OK);
    }


    public ResponseEntity<Episode> getEpisodee(Integer id){
        Episode episode= repos.findById(id).get();
        return new ResponseEntity<>(episode, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteEpisode(Integer id){
        repos.deleteById(id);
        return new ResponseEntity<>("DELETED",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Episode> addEpisode(Episode episode){
        Episode ep=repos.save(episode);
        return new ResponseEntity<>(ep,HttpStatus.CREATED);

    }




}
