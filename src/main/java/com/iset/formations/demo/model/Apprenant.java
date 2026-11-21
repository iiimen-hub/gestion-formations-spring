package com.iset.formations.demo.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "apprenants")
public class Apprenant extends Personne {

    @Column(nullable = false, unique = true)
    private String numero;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePremiereInscription;

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscription> inscriptions = new ArrayList<>();

    public Apprenant() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDatePremiereInscription() {
        return datePremiereInscription;
    }

    public void setDatePremiereInscription(Date datePremiereInscription) {
        this.datePremiereInscription = datePremiereInscription;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}