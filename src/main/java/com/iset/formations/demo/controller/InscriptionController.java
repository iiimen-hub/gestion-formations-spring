package com.iset.formations.demo.controller;

import com.iset.formations.demo.model.Inscription;
import com.iset.formations.demo.repository.ApprenantRepository;
import com.iset.formations.demo.repository.InscriptionRepository;
import com.iset.formations.demo.repository.SessionFormationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inscriptions")
public class InscriptionController {

    private final InscriptionRepository inscriptionRepository;
    private final ApprenantRepository apprenantRepository;
    private final SessionFormationRepository sessionFormationRepository;

    public InscriptionController(InscriptionRepository inscriptionRepository,
                                 ApprenantRepository apprenantRepository,
                                 SessionFormationRepository sessionFormationRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.apprenantRepository = apprenantRepository;
        this.sessionFormationRepository = sessionFormationRepository;
    }

    @GetMapping
    public String pageInscriptions(Model model) {
        model.addAttribute("inscriptionForm", new Inscription());
        model.addAttribute("apprenants", apprenantRepository.findAll());
        model.addAttribute("sessions", sessionFormationRepository.findAll());
        model.addAttribute("inscriptions", inscriptionRepository.findAll());
        return "inscriptions";
    }

    @PostMapping("/ajouter")
    public String ajouterInscription(@ModelAttribute("inscriptionForm") Inscription inscription) {
        inscriptionRepository.save(inscription);
        return "redirect:/inscriptions";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerInscription(@PathVariable("id") Long id) {
        inscriptionRepository.deleteById(id);
        return "redirect:/inscriptions";
    }
}