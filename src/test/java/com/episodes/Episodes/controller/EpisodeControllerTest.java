package com.episodes.Episodes.controller;

import com.episodes.Episodes.model.Episode;
import com.episodes.Episodes.service.EpisodeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(EpisodeController.class)
class EpisodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EpisodeService episodeService;
    private Episode episode;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        episode =new Episode(1,"aa","bb",11);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getEpisode() throws Exception {

        Mockito.when(episodeService.getEpisodee(1)).thenReturn(ResponseEntity.ok(episode));

        mockMvc.perform(MockMvcRequestBuilders.get("/episode/get/1")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void testGetEpisode() throws Exception{
        List<Episode> episodeList =new ArrayList<>();
        episodeList.add(episode);

        Mockito.when(episodeService.getAllEpisodees()).thenReturn(ResponseEntity.ok(episodeList));

        mockMvc.perform(MockMvcRequestBuilders.get("/episode/list")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("aa"));
    }


     @Test
    void testAddEpisode() throws Exception {
        Mockito.when(episodeService.addEpisode(Mockito.any(Episode.class))).thenReturn(ResponseEntity.ok(episode));

        mockMvc.perform(MockMvcRequestBuilders.post("/episode/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(episode)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    void deltedEpisode() {

    }
}