package org.back.domain.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.back.domain.mesa.Mesa;

import java.util.List;

@Entity(name = "mestre")
public class Mestre extends Usuario {

    @OneToMany(mappedBy = "mestre")
    private List<Mesa> mesas;

    public Mestre() {}

    public Mestre(int id, String nome, String matricula, String email, String senha,  boolean eMestre) {
        super(id, nome, matricula, email, senha, eMestre);
    }
}
