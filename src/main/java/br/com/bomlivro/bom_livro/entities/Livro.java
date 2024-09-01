package br.com.bomlivro.bom_livro.entities;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

    public Livro(){}
    
}
