package com.senac.gerenciamento.model;

import javax.persistence.*;

@Entity
public class Usuario {

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SENHA")
    private String senha;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
