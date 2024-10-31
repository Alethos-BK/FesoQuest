package org.back.src.user.enums;

public enum EUserType {

    JOGADOR(0),
    MESTRE(1);

    private final int valor;

    EUserType(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

}

