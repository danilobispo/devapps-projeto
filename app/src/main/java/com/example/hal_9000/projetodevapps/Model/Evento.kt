package com.example.hal_9000.projetodevapps.Model

/**
 * Created by Danilo José Bispo Galvão on 10/05/2018.
 */
data class Evento(
    var titulo: String,
    var data: String, // TODO: Revisar tipo dessa variável quando dados reais forem inseridos
    var hora: String, // TODO: Revisar tipo dessa variável quando dados reais forem inseridos
    var local: String,
    var informacoes: String) {}