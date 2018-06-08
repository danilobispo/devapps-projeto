package com.example.hal_9000.projetodevapps.services;

import com.example.hal_9000.projetodevapps.Model.Animal;
import com.example.hal_9000.projetodevapps.Model.Categoria;
import com.example.hal_9000.projetodevapps.Model.Evento;
import com.example.hal_9000.projetodevapps.Model.Pessoa;

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

    public List<Animal> getMeusPets() {
        List<Animal> animaisParaAdocao = new ArrayList<Animal>();
        for (int i = 0; i < 5; i++) {

            Animal dummy = new Animal();
            dummy.setCategoria("AJUDAR | APADRINHAR");
            dummy.setQtInteressados(3);
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

    public ArrayList<Evento> getEventos() {
        ArrayList<Evento> eventosList = new ArrayList<Evento>();
        eventosList.add(new Evento(
                "Evento 1",
                "16/09/2112",
                "11h às 16h",
                "ICC Sul",
                "AAA"));
        eventosList.add(new Evento(
                "Evento 2",
                "14/10/2112",
                "12h às 15h",
                "ICC Norte",
                "BBBB"));
        eventosList.add(new Evento(
                "Evento 3",
                "24/09/2112",
                "14h às 18h",
                "ICC Centro",
                "CCCC"));
        return eventosList;
    }

    public Pessoa getProfile() {
        return new Pessoa("Marilia Martins de Souza", "27 anos",
                "marilia_martins@gmail.com", "", "Sobradinho - DF", "Rua 203, conjunto B, casa 37",
                "(61) 98274-2947", "mari_martins", "123", "123",
                null, "adotou 1 gato");
    }
}


