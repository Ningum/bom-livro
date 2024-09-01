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

  public Autor() {}

  public Autor(
    Long id,
    String nome,
    String sobrenome,
    Date dataNascimento,
    String nacionalidade
  ) {
    this.id = id;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.dataNascimento = dataNascimento;
    this.nacionalidade = nacionalidade;
  }

  public Autor(Autor entity) {
    this.id = id;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.dataNascimento = dataNascimento;
    this.nacionalidade = nacionalidade;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getNacionalidade() {
    return nacionalidade;
  }

  public void setNacionalidade(String nacionalidade) {
    this.nacionalidade = nacionalidade;
  }
}
