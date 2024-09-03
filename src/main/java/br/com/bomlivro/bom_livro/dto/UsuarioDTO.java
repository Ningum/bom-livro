package br.com.bomlivro.bom_livro.dto;

import br.com.bomlivro.bom_livro.entities.Usuario;
import java.util.Date;

public class UsuarioDTO {

  private Long id;
  private String nome;
  private String email;
  private String telefone;
  private Date dataCadastro;

  public UsuarioDTO() {}

  public UsuarioDTO(
    Long id,
    String nome,
    String email,
    String telefone,
    Date dataCadastro
  ) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.dataCadastro = dataCadastro;
  }

  public UsuarioDTO(Usuario entity) {
    id = entity.getId();
    nome = entity.getNome();
    email = entity.getEmail();
    telefone = entity.getTelefone();
    dataCadastro = entity.getDataCadastro();
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public Date getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(Date dataCadastro) {
    this.dataCadastro = dataCadastro;
  }
}
