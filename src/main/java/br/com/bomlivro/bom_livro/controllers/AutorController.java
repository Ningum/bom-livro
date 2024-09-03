package br.com.bomlivro.bom_livro.controllers;

import br.com.bomlivro.bom_livro.dto.AutorDTO;
import br.com.bomlivro.bom_livro.services.AutorService;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

  @Autowired
  private AutorService autorService;

  @GetMapping
  public ResponseEntity<Page<AutorDTO>> findAll(
    @RequestParam(name = "nome", defaultValue = "") String nome,
    @RequestParam(name = "sobrenome", defaultValue = "") String sobrenome,
    Pageable pageable
  ) {
    Page<AutorDTO> dto = autorService.findaAll(nome, sobrenome, pageable);
    return ResponseEntity.ok(dto);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<AutorDTO> findById(@PathVariable Long id) {
    AutorDTO dto = autorService.findById(id);
    return ResponseEntity.ok(dto);
  }

  @PostMapping
  public ResponseEntity<AutorDTO> insert(@RequestBody AutorDTO dto) {
    dto = autorService.insert(dto);
    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(dto.getId())
      .toUri();
    return ResponseEntity.created(uri).body(dto);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<AutorDTO> update(
    @PathVariable Long id,
    @Valid @RequestBody AutorDTO dto
  ) {
    dto = autorService.update(id, dto);
    return ResponseEntity.ok(dto);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    autorService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
