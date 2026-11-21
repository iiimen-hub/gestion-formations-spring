package com.iset.formations.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "themes_formation")
public class ThemeFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String theme;

    private String motsCles;

    @OneToMany(mappedBy = "themeFormation", cascade = CascadeType.ALL)
    private List<SessionFormation> sessions = new ArrayList<>();

    public ThemeFormation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    public List<SessionFormation> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionFormation> sessions) {
        this.sessions = sessions;
    }
}