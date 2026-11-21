package com.iset.formations.demo.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "formateurs")
public class Formateur extends Personne {

    private String grade;
    private String fonction;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePremiereFormation;

    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<SessionFormation> sessions = new ArrayList<>();

    public Formateur() {
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Date getDatePremiereFormation() {
        return datePremiereFormation;
    }

    public void setDatePremiereFormation(Date datePremiereFormation) {
        this.datePremiereFormation = datePremiereFormation;
    }

    public List<SessionFormation> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionFormation> sessions) {
        this.sessions = sessions;
    }
}