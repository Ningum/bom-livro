package br.com.bomlivro.bom_livro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Date dataEmprestimo;
  private Date dataDevolucao;
  private Date dataDevolvido;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario id_usuario;

  @ManyToOne
  @JoinColumn(name = "livro_id")
  private Livro id_livro;

  public Emprestimo() {}

  public Emprestimo(
    Long id,
    Date dataEmprestimo,
    Date dataDevolucao,
    Date dataDevolvido,
    Usuario id_usuario,
    Livro id_livro
  ) {
    this.id = id;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = dataDevolucao;
    this.dataDevolvido = dataDevolvido;
    this.id_usuario = id_usuario;
    this.id_livro = id_livro;
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

  public Usuario getId_usuario() {
    return id_usuario;
  }

  public void setId_usuario(Usuario id_usuario) {
    this.id_usuario = id_usuario;
  }

  public Livro getId_livro() {
    return id_livro;
  }

  public void setId_livro(Livro id_livro) {
    this.id_livro = id_livro;
  }
}
