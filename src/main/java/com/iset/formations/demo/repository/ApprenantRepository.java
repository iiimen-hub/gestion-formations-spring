package com.iset.formations.demo.repository;

import com.iset.formations.demo.model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    Apprenant findByNumero(String numero);
}