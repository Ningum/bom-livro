package br.com.bomlivro.bom_livro.controllers;

import br.com.bomlivro.bom_livro.dto.CategoriaDTO;
import br.com.bomlivro.bom_livro.services.AutorService;
import br.com.bomlivro.bom_livro.services.CategoriaService;
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
@RequestMapping(value = "/categorias")
public class CategoriaController {

  @Autowired
  private CategoriaService service;

  @GetMapping
  public ResponseEntity<Page<CategoriaDTO>> findAll(
    @RequestParam(name = "nome", defaultValue = "") String nome,
    Pageable pageable
  ) {
    Page<CategoriaDTO> dto = service.findaAll(nome, pageable);
    return ResponseEntity.ok(dto);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
    CategoriaDTO dto = service.findById(id);
    return ResponseEntity.ok(dto);
  }

  @PostMapping
  public ResponseEntity<CategoriaDTO> insert(@RequestBody CategoriaDTO dto) {
    dto = service.insert(dto);
    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(dto.getId())
      .toUri();
    return ResponseEntity.created(uri).body(dto);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CategoriaDTO> update(
    @PathVariable Long id,
    @Valid @RequestBody CategoriaDTO dto
  ) {
    dto = service.update(id, dto);
    return ResponseEntity.ok(dto);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
