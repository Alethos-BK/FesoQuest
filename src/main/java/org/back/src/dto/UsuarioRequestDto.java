package org.back.src.dto;

import org.back.src.enums.ETipoUsuario;

public class UsuarioRequestDto {
    private String nome;
    private String matricula;
    private String email;
    private String senha;
    private ETipoUsuario tipoUsuario;

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

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public ETipoUsuario getTipoUsuario() { return tipoUsuario; }

    public void setTipoUsuario(ETipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }
}