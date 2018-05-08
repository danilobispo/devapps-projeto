package com.example.hal_9000.projetodevapps.services;

import com.example.hal_9000.projetodevapps.Model.Animal;

import java.util.ArrayList;
import java.util.List;

public class ConsultaService {
    public List<Animal> getAnimaisParaAdocao() {
        List<Animal> animaisParaAdocao = new ArrayList<Animal>();
        for (int i = 0; i < 20; i++) {
            Animal dummy = new Animal();
            dummy.setName("Nome " + String.valueOf(i));
            dummy.setPorte("Porte " + String.valueOf(i));
            dummy.setIdade(i);
            dummy.setLocalizacao("Localizacao " + String.valueOf(i));
            dummy.setSexo("Sexo " + String.valueOf(i));
            dummy.setImagem_uri(null);
            animaisParaAdocao.add(dummy);
        }
        return animaisParaAdocao;
    }

    public List<Animal> getAnimaisParaAjuda() {
        List<Animal> animaisParaAdocao = new ArrayList<Animal>();
        for (int i = 0; i < 20; i++) {
            Animal dummy = new Animal();
            dummy.setName("Nome " + String.valueOf(i));
            dummy.setPorte("Porte " + String.valueOf(i));
            dummy.setIdade(i);
            dummy.setLocalizacao("Localizacao " + String.valueOf(i));
            dummy.setSexo("Sexo " + String.valueOf(i));
            dummy.setImagem_uri(null);
            animaisParaAdocao.add(dummy);
        }
        return animaisParaAdocao;
    }
}


