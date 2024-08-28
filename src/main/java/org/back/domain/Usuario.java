package org.back.domain;

public abstract class Usuario {
    private String nome;
    private String matricula;
    private String email;
    private String senha;

    public Usuario(String nome, String matricula, String email, String senha) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
    }

    public String obterNome(){
        return nome;
    }

    public String obterMatricula(){
        return matricula;
    }

    public String obterEmail(){
        return email;
    }

    public String obterSenha(){
        return senha;
    }

    public void atualizarNome(String  nome){
        this.nome = nome;
    }

    public void atualizarMatricula(String  matricula){
        this.matricula = matricula;
    }

    public void atualizarEmail(String  email){
        this.email = email;
    }

    public void atualizarSenha(String  senha){
        this.senha = senha;
    }
}
