package com.episodes.Episodes.service;

import com.episodes.Episodes.model.Episode;
import com.episodes.Episodes.repos.EpisodeRepos;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EpisodeServiceTest {

            @Mock
            private EpisodeRepos repos;

            @InjectMocks
            private  EpisodeService service;

    Episode episode;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        episode =new Episode(1,"spec","kk",111);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllEpisodees() {

        List<Episode> episodesList=new ArrayList<>(Arrays.asList(episode));
        Mockito.when(repos.findAll()).thenReturn(episodesList);

        ResponseEntity<List<Episode>>  ep=service.getAllEpisodees();
        assertEquals("spec", ep.getBody().get(0).getName());
    }

    @Test
    void getEpisodee() {

        Mockito.when(repos.findById(1)).thenReturn(Optional.of(episode));

        ResponseEntity<Episode>  resp=service.getEpisodee(1);
        assertEquals("spec",resp.getBody().getName());
    }

    @Test
    void deleteEpisode() {

        Mockito.doNothing().when(repos).deleteById(1);
        ResponseEntity<String>  resp= service.deleteEpisode(1);

        assertEquals("DELETED",resp.getBody());
    }

    @Test
    void addEpisode() {
        Mockito.when(repos.save(episode)).thenReturn(episode);
        ResponseEntity<Episode>  resp=service.addEpisode(episode);

        assertEquals("kk",resp.getBody().getHero());



    }
}