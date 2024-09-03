package br.com.bomlivro.bom_livro.repositories;

import br.com.bomlivro.bom_livro.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutorRepository extends JpaRepository<Autor, Long> {
  @Query(
    "SELECT obj FROM Autor obj " +
    "WHERE UPPER(obj.nome) LIKE UPPER(CONCAT('%',:nome,'%')) " +
    "AND UPPER(obj.sobrenome) LIKE UPPER(CONCAT('%',:sobrenome,'%'))"
  )
  Page<Autor> searchByName(String nome, String sobrenome, Pageable pageable);
}
