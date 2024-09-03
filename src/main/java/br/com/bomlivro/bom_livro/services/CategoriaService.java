package br.com.bomlivro.bom_livro.services;

import br.com.bomlivro.bom_livro.dto.CategoriaDTO;
import br.com.bomlivro.bom_livro.entities.Categoria;
import br.com.bomlivro.bom_livro.repositories.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Transactional(readOnly = true)
  public Page<CategoriaDTO> findaAll(
    String nome,
    Pageable pageable
  ) {
    Page<Categoria> result = categoriaRepository.searchByName(nome, pageable);
    return result.map(x -> new CategoriaDTO(x));
  }

  @Transactional(readOnly = true)
  public CategoriaDTO findById(Long id) {
    Categoria categoria = categoriaRepository
      .findById(id)
      .orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    return new CategoriaDTO(categoria);
  }

  @Transactional
  public CategoriaDTO insert(CategoriaDTO dto) {
    Categoria entity = new Categoria();
    copyDtoToEntity(dto, entity);
    entity = categoriaRepository.save(entity);

    return new CategoriaDTO(entity);
  }

  @Transactional
  public CategoriaDTO update(Long id, CategoriaDTO dto) {
    try {
      Categoria entity = categoriaRepository.getReferenceById(id);
      copyDtoToEntity(dto, entity);
      entity = categoriaRepository.save(entity);

      return new CategoriaDTO(entity);
    } catch (EntityNotFoundException e) {
      throw new RuntimeException("Recurso não encontrado");
    }
  }

  private void copyDtoToEntity(CategoriaDTO dto, Categoria entity) {
    entity.setNome(dto.getNome());
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void delete(Long id) {
    if (!categoriaRepository.existsById(id)) {
      throw new RuntimeException("Recurso não encontrado");
    }
    try {
      categoriaRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new RuntimeException("Falha de integridade referencial");
    }
  }
}
