package com.iset.formations.demo.repository;

import com.iset.formations.demo.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    List<Inscription> findBySessionFormation_Id(Long sessionId);
    List<Inscription> findByApprenant_Id(Long apprenantId);
}