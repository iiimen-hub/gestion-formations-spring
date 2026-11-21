package com.iset.formations.demo.repository;

import com.iset.formations.demo.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}