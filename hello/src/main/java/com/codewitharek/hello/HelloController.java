package com.codewitharek.hello;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final NameRepository nameRepository;

    public HelloController(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    // CREATE  -> POST /hello
    @PostMapping
    public NameEntity create(@Valid @RequestBody HelloRequest request) {
        return nameRepository.save(new NameEntity(request.getName()));
    }
    @PostMapping("/batch")
    public List<NameEntity> createBatch(@Valid @RequestBody HelloBatchRequest request) {
        return request.getNames().stream().map(name -> nameRepository.save(new NameEntity(name))).toList();
    }

    // READ ALL -> GET /hello
    @GetMapping
    public Page<NameEntity> getAll(
            @RequestParam(required = false) String name,
            Pageable pageable
    ) {
        if (name == null || name.isBlank()) {
            return nameRepository.findAll(pageable);
        }
        return nameRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    // READ ONE -> GET /hello/{id}
    @GetMapping("/{id}")
    public ResponseEntity<NameEntity> getOne(@PathVariable Long id) {
        return nameRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE -> PUT /hello/{id}
    @PutMapping("/{id}")
    public ResponseEntity<NameEntity> update(@PathVariable Long id, @Valid@RequestBody HelloRequest request) {
        return nameRepository.findById(id)
                .map(entity -> {
                    entity.setName(request.getName());
                    NameEntity saved = nameRepository.save(entity);
                    return ResponseEntity.ok(saved);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE -> DELETE /hello/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!nameRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        nameRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

