package org.back.domain.usuario;

import jakarta.persistence.*;
import org.back.domain.mesa.Mesa;

import java.util.ArrayList;
import java.util.List;

//TODO: por enquanto usar heranca nao faz sentido para nós talvez a retiraremos e deixaremos apenas usuario
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private String matricula;
    private String email;
    private String senha;
    private boolean eMestre;

    public Usuario() {}

    protected Usuario(int id, String nome, String matricula, String email, String senha, boolean eMestre) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.eMestre = eMestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getEMestre() { return eMestre; }

    public void setEMestre(boolean eMestre) {this.eMestre = eMestre; }
}
