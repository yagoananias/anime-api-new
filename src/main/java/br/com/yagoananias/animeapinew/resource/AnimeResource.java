package br.com.yagoananias.animeapinew.resource;

import br.com.yagoananias.animeapinew.model.Anime;
import br.com.yagoananias.animeapinew.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/animes")
public class AnimeResource {

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Anime> get(@PathVariable Integer id) {

        Anime anime = animeRepository.getOne(id);

        if (anime == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(anime);

    }

    @GetMapping
    public ResponseEntity<List<Anime>> getAll() {

        List<Anime> listaAnimes = animeRepository.findAll();
        return ResponseEntity.ok().body(listaAnimes);
    }

    @PostMapping
    public Anime add(@Validated @RequestBody Anime anime) {
        return animeRepository.save(anime);
    }
}
