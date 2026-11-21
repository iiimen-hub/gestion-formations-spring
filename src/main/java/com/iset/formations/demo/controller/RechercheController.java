package com.iset.formations.demo.controller;

import com.iset.formations.demo.model.SessionFormation;
import com.iset.formations.demo.repository.SessionFormationRepository;
import com.iset.formations.demo.repository.ThemeFormationRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/recherche")
public class RechercheController {

    private final SessionFormationRepository sessionRepository;
    private final ThemeFormationRepository themeRepository;

    public RechercheController(SessionFormationRepository sessionRepository,
                               ThemeFormationRepository themeRepository) {
        this.sessionRepository = sessionRepository;
        this.themeRepository = themeRepository;
    }

    @GetMapping
    public String pageRecherche(
            @RequestParam(name = "themeId", required = false) Long themeId,
            @RequestParam(name = "dateDebut", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(name = "dateFin", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin,
            Model model
    ) {
        model.addAttribute("themes", themeRepository.findAll());
        model.addAttribute("selectedThemeId", themeId);
        model.addAttribute("dateDebut", dateDebut);
        model.addAttribute("dateFin", dateFin);

        List<SessionFormation> resultats;
        if (themeId != null && dateDebut != null && dateFin != null) {
            resultats = sessionRepository.findByThemeFormation_IdAndDatedebutGreaterThanEqualAndDatefinLessThanEqual(
                    themeId, dateDebut, dateFin
            );
        } else if (themeId != null) {
            resultats = sessionRepository.findByThemeFormation_Id(themeId);
        } else {
            resultats = sessionRepository.findAll();
        }

        model.addAttribute("resultats", resultats);
        return "recherche";
    }
}