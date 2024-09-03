package br.com.bomlivro.bom_livro.dto;

import br.com.bomlivro.bom_livro.entities.Emprestimo;
import java.util.Date;

public class EmprestimoDTO {

  private Long id;
  private Date dataEmprestimo;
  private Date dataDevolucao;
  private Date dataDevolvido;
  private UsuarioDTO id_usuario;
  private LivroDTO id_livro;

  public EmprestimoDTO() {}

  public EmprestimoDTO(
    Long id,
    Date dataEmprestimo,
    Date dataDevolucao,
    Date dataDevolvido,
    UsuarioDTO id_usuario,
    LivroDTO id_livro
  ) {
    this.id = id;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = dataDevolucao;
    this.dataDevolvido = dataDevolvido;
    this.id_usuario = id_usuario;
    this.id_livro = id_livro;
  }

  public EmprestimoDTO(Emprestimo entity) {
    id = entity.getId();
    dataEmprestimo = entity.getDataEmprestimo();
    dataDevolucao = entity.getDataDevolucao();
    dataDevolvido = entity.getDataDevolvido();
    id_usuario = new UsuarioDTO(entity.getId_usuario());
    id_livro = new LivroDTO(entity.getId_livro());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDataEmprestimo() {
    return dataEmprestimo;
  }

  public void setDataEmprestimo(Date dataEmprestimo) {
    this.dataEmprestimo = dataEmprestimo;
  }

  public Date getDataDevolucao() {
    return dataDevolucao;
  }

  public void setDataDevolucao(Date dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
  }

  public Date getDataDevolvido() {
    return dataDevolvido;
  }

  public void setDataDevolvido(Date dataDevolvido) {
    this.dataDevolvido = dataDevolvido;
  }

  public UsuarioDTO getId_usuario() {
    return id_usuario;
  }

  public void setId_usuario(UsuarioDTO id_usuario) {
    this.id_usuario = id_usuario;
  }

  public LivroDTO getId_livro() {
    return id_livro;
  }

  public void setId_livro(LivroDTO id_livro) {
    this.id_livro = id_livro;
  }
}
