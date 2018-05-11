package com.example.hal_9000.projetodevapps.Model;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class Animal implements Serializable {

    private String categoria;
    private String name;
    private String especie;
    private String sexo;
    private String porte;
    private int idade;
    private Uri imagem_uri;
    private String localizacao;
    private ArrayList<String> temperamento;
    private ArrayList<String> saude;
    private ArrayList<String> exigencias;
    private String sobre;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ArrayList<String> getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(ArrayList<String> temperamento) {
        this.temperamento = temperamento;
    }

    public ArrayList<String> getSaude() {
        return saude;
    }

    public void setSaude(ArrayList<String> saude) {
        this.saude = saude;
    }

    public ArrayList<String> getExigencias() {
        return exigencias;
    }

    public void setExigencias(ArrayList<String> exigencias) {
        this.exigencias = exigencias;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public Uri getImagem_uri() {
        return imagem_uri;
    }

    public void setImagem_uri(Uri imagem_uri) {
        this.imagem_uri = imagem_uri;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
