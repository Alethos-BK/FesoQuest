package org.back.domain.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.back.domain.mesa.Mesa;

import java.util.List;

@Entity(name = "jogador")
public class Jogador extends Usuario {
    @ManyToMany
    @JoinTable(
            name = "jogador_mesa",
            joinColumns = @JoinColumn(name = "jogador_id"),
            inverseJoinColumns = @JoinColumn(name = "mesa_id")
    )
    private List<Mesa> mesas;

    public Jogador(int id, String nome, String matricula, String email, String senha,  boolean eMestre) {
        super(id, nome, matricula, email, senha, eMestre);
    }
}
