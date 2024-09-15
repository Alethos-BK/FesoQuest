package org.back.domain.enums;

import org.apache.commons.lang3.StringUtils;
import org.back.domain.exception.CustomException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Locale;
import java.util.NoSuchElementException;

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

    public static ETipoUsuario get(Integer valor) throws CustomException {
        try {
            return Arrays.stream(ETipoUsuario.values())
                    .filter(tipo -> valor == tipo.getValor()).findAny().get();
        } catch (NoSuchElementException ex) {
            String feedback = String.format("Valor inexperado. Esperado: [%s]", listar());
            throw new CustomException(HttpStatus.BAD_REQUEST, feedback);
        }
    }

    public static String listar() {
        StringBuilder sb = new StringBuilder();
        for (ETipoUsuario tipo : ETipoUsuario.values()) {
            sb.append(tipo.name());
            sb.append(": ");
            sb.append(tipo.getValor());
            sb.append("\n");
        }
        return sb.toString();
    }
}

