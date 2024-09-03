package br.com.bomlivro.bom_livro.dto;

import br.com.bomlivro.bom_livro.entities.Livro;

public class LivroDTO {

  private Long id;
  private String titulo;
  private String isbn;
  private String anoPublicacao;
  private Boolean disponivel;
  private CategoriaDTO id_categoria;
  private AutorDTO id_autor;

  public LivroDTO() {}

  public LivroDTO(
    Long id,
    String titulo,
    String isbn,
    String anoPublicacao,
    Boolean disponivel,
    CategoriaDTO id_categoria,
    AutorDTO id_autor
  ) {
    this.id = id;
    this.titulo = titulo;
    this.isbn = isbn;
    this.anoPublicacao = anoPublicacao;
    this.disponivel = disponivel;
    this.id_categoria = id_categoria;
    this.id_autor = id_autor;
  }

  public LivroDTO(Livro entity) {
    id = entity.getId();
    titulo = entity.getTitulo();
    isbn = entity.getIsbn();
    anoPublicacao = entity.getAnoPublicacao();
    disponivel = entity.getDisponivel();
    id_categoria = new CategoriaDTO(entity.getId_categoria());
    id_autor = new AutorDTO(entity.getId_autor());
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

  public CategoriaDTO getId_categoria() {
    return id_categoria;
  }

  public void setId_categoria(CategoriaDTO id_categoria) {
    this.id_categoria = id_categoria;
  }

  public AutorDTO getId_autor() {
    return id_autor;
  }

  public void setId_autor(AutorDTO id_autor) {
    this.id_autor = id_autor;
  }
}
