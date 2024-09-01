package br.com.bomlivro.bom_livro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "tb_livro")
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;
  private String isbn;
  private String anoPublicacao;
  private Boolean disponivel;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private Categoria id_categoria;

  @ManyToOne
  @JoinColumn(name = "autor_id")
  private Autor id_autor;

  public Livro(
    Long id,
    String titulo,
    String isbn,
    String anoPublicacao,
    Boolean disponivel,
    Categoria id_categoria,
    Autor id_autor
  ) {
    this.id = id;
    this.titulo = titulo;
    this.isbn = isbn;
    this.anoPublicacao = anoPublicacao;
    this.disponivel = disponivel;
    this.id_categoria = id_categoria;
    this.id_autor = id_autor;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getAnoPublicacao() {
    return anoPublicacao;
  }

  public void setAnoPublicacao(String anoPublicacao) {
    this.anoPublicacao = anoPublicacao;
  }

  public Boolean getDisponivel() {
    return disponivel;
  }

  public void setDisponivel(Boolean disponivel) {
    this.disponivel = disponivel;
  }

  public Categoria getId_categoria() {
    return id_categoria;
  }

  public void setId_categoria(Categoria id_categoria) {
    this.id_categoria = id_categoria;
  }

  public Autor getId_autor() {
    return id_autor;
  }

  public void setId_autor(Autor id_autor) {
    this.id_autor = id_autor;
  }

  public Livro() {}
}
