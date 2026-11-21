package com.iset.formations.demo.repository;

import com.iset.formations.demo.model.SessionFormation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SessionFormationRepository extends JpaRepository<SessionFormation, Long> {

    List<SessionFormation> findByThemeFormation_IdAndDatedebutGreaterThanEqualAndDatefinLessThanEqual(
            Long themeId, Date dateDebut, Date dateFin
    );

    List<SessionFormation> findByDatedebutGreaterThanEqualAndDatefinLessThanEqual(
            Date dateDebut, Date dateFin
    );

    List<SessionFormation> findByThemeFormation_Id(Long themeId);
}