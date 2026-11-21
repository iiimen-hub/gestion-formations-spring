package com.iset.formations.demo.repository;

import com.iset.formations.demo.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    Personne findByCin(String cin);
}