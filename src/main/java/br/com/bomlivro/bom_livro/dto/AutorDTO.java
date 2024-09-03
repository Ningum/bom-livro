package br.com.bomlivro.bom_livro.dto;

import br.com.bomlivro.bom_livro.entities.Autor;

public class AutorDTO {

  private Long id;
  private String nome;
  private String sobrenome;
  private String dataNascimento;
  private String nacionalidade;

  public AutorDTO(
    Long id,
    String nome,
    String sobrenome,
    String dataNascimento,
    String nacionalidade
  ) {
    this.id = id;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.dataNascimento = dataNascimento;
    this.nacionalidade = nacionalidade;
  }

  public AutorDTO(Autor entity) {
    id = entity.getId();
    nome = entity.getNome();
    sobrenome = entity.getSobrenome();
    dataNascimento = entity.getDataNascimento();
    nacionalidade = entity.getNacionalidade();
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public String getNacionalidade() {
    return nacionalidade;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public void setNacionalidade(String nacionalidade) {
    this.nacionalidade = nacionalidade;
  }
}
