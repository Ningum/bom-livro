package br.com.bomlivro.bom_livro.repositories;

import br.com.bomlivro.bom_livro.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
  @Query(
    "SELECT obj FROM Categoria obj " +
    "WHERE UPPER(obj.nome) LIKE UPPER(CONCAT('%',:nome,'%')) "
  )
  Page<Categoria> searchByName(String nome, Pageable pageable);
}
