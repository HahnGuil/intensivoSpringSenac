package com.senac.gerenciamento.model;

import javax.persistence.*;
import javax.swing.text.Style;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SILGA")
    private String sigla;

    @Column(name = "POPULACAO")
    private Double populacao;

    @ManyToOne
//    O primeiro define a coluna na tabela de estado. O segundo é a coluna a onde ele se referencia na tabela de destino
    @JoinColumn(name = "I_PAIS", referencedColumnName = "ID")
    private Pais pais;

    public Estado() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Double populacao) {
        this.populacao = populacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
