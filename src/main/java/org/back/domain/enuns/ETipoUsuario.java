package org.back.domain.enuns;

public enum ETipoUsuario {
    JOGADOR(0),
    MESTRE(1);

    private final int valor;

    ETipoUsuario(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

