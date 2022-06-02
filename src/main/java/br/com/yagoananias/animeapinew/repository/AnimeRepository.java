package br.com.yagoananias.animeapinew.repository;

import br.com.yagoananias.animeapinew.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {
}
