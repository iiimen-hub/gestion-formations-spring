package com.iset.formations.demo.repository;

import com.iset.formations.demo.model.ThemeFormation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeFormationRepository extends JpaRepository<ThemeFormation, Long> {
    ThemeFormation findByTheme(String theme);
}