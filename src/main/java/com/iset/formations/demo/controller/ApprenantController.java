package com.iset.formations.demo.controller;

import com.iset.formations.demo.model.Apprenant;
import com.iset.formations.demo.repository.ApprenantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/apprenants")
public class ApprenantController {

    private final ApprenantRepository apprenantRepository;

    public ApprenantController(ApprenantRepository apprenantRepository) {
        this.apprenantRepository = apprenantRepository;
    }

    @GetMapping
    public String listeApprenants(Model model) {
        model.addAttribute("apprenantForm", new Apprenant());
        model.addAttribute("apprenants", apprenantRepository.findAll());
        return "apprenants";
    }

    @PostMapping("/ajouter")
    public String ajouterApprenant(@ModelAttribute("apprenantForm") Apprenant apprenant) {
        apprenantRepository.save(apprenant);
        return "redirect:/apprenants";
    }
}