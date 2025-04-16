package com.example.gestione_campioni_sql.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "champion")
public class Champion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nome")
    String nome;

    @Column(name = "ruolo")
    String ruolo;  // TOP, JUNGLE, MID, ADC, SUPPORT

    @Column(name = "difficolta")
    String difficolta; // FACILE, MEDIO, DIFFICILE

    @Column(name = "data_rilascio")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate dataRilascio;

    @Column(name = "regione")
    String regione;

    public Champion() {}

    public Champion(Long id, String nome, String ruolo, String difficolta, LocalDate dataRilascio, String regione){
        this.id = id;
        this.nome = nome;
        this.ruolo = ruolo;
        this.difficolta = difficolta;
        this.dataRilascio = dataRilascio;
        this.regione = regione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(String difficolta) {
        this.difficolta = difficolta;
    }

    public LocalDate getDataRilascio() {
        return dataRilascio;
    }

    public void setDataRilascio(LocalDate dataRilascio) {
        this.dataRilascio = dataRilascio;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

}
