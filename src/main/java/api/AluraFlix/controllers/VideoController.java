package api.AluraFlix.controllers;

import api.AluraFlix.domain.video.*;
import api.AluraFlix.repositories.VideoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/videos")
@CrossOrigin(origins = "*",maxAge = 3600)
public class VideoController {

    @Autowired
    private VideoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid CreateVideoDto dto, UriComponentsBuilder uriBuilder){
        var video = new Video(dto);
        repository.save(video);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(video.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailVideoDto(video));
    }

    @GetMapping
    public ResponseEntity<Page<ListVideoDto>> list(@PageableDefault(size = 10, sort = {"title"}) Pageable pageable) {
        var page = repository.findAllByActiveTrue(pageable).map(ListVideoDto::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var video = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetailVideoDto(video));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateVideoDto dto) {
        var video = repository.getReferenceById(dto.id());
        video.dataUpdate(dto);

        return ResponseEntity.ok(new DetailVideoDto(video));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var video = repository.getReferenceById(id);
        video.delete();

        return ResponseEntity.noContent().build();
    }
}
