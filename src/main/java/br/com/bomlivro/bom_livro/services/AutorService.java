package br.com.bomlivro.bom_livro.services;

import br.com.bomlivro.bom_livro.dto.AutorDTO;
import br.com.bomlivro.bom_livro.entities.Autor;
import br.com.bomlivro.bom_livro.repositories.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorService {

  @Autowired
  private AutorRepository autorRepository;

  @Transactional(readOnly = true)
  public Page<AutorDTO> findaAll(
    String nome,
    String sobrenome,
    Pageable pageable
  ) {
    Page<Autor> result = autorRepository.searchByName(
      nome,
      sobrenome,
      pageable
    );
    return result.map(x -> new AutorDTO(x));
  }

  @Transactional(readOnly = true)
  public AutorDTO findById(Long id) {
    Autor product = autorRepository
      .findById(id)
      .orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    return new AutorDTO(product);
  }

  @Transactional
  public AutorDTO insert(AutorDTO dto) {
    Autor entity = new Autor();
    copyDtoToEntity(dto, entity);
    entity = autorRepository.save(entity);

    return new AutorDTO(entity);
  }

  @Transactional
  public AutorDTO update(Long id, AutorDTO dto) {
    try {
      Autor entity = autorRepository.getReferenceById(id);
      copyDtoToEntity(dto, entity);
      entity = autorRepository.save(entity);

      return new AutorDTO(entity);
    } catch (EntityNotFoundException e) {
      throw new RuntimeException("Recurso não encontrado");
    }
  }

  private void copyDtoToEntity(AutorDTO dto, Autor entity) {
    entity.setNome(dto.getNome());
    entity.setSobrenome(dto.getSobrenome());
    entity.setDataNascimento(dto.getDataNascimento());
    entity.setNacionalidade(dto.getNacionalidade());
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void delete(Long id) {
    if (!autorRepository.existsById(id)) {
      throw new RuntimeException("Recurso não encontrado");
    }
    try {
      autorRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new RuntimeException("Falha de integridade referencial");
    }
  }
}
