package org.back.domain.usuario;

import jakarta.persistence.*;
import org.back.domain.enuns.ETipoUsuario;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private String matricula;
    private String email;
    private String senha;

    @Enumerated(EnumType.ORDINAL)
    private ETipoUsuario tipoUsuario;

    public Usuario() {}

    protected Usuario(int id, String nome, String matricula, String email, String senha, ETipoUsuario tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
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

    public ETipoUsuario getTipoUsuario() { return tipoUsuario; }

    public void setTipoUsuario(ETipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }
}
