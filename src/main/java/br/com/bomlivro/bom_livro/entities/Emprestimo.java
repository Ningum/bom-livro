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
}
