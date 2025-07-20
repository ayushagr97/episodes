package com.episodes.Episodes.repos;

import com.episodes.Episodes.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepos extends JpaRepository<Episode,Integer> {
}
