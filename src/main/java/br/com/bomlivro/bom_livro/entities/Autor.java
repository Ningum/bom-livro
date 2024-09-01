package br.com.bomlivro.bom_livro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_autor")
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String sobrenome;
  private Date dataNascimento;
  private String nacionalidade;

  public Autor(){}
}
