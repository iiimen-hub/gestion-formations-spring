package com.iset.formations.demo.controller;

import com.iset.formations.demo.model.ThemeFormation;
import com.iset.formations.demo.repository.ThemeFormationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/themes")
public class ThemeController {

    private final ThemeFormationRepository themeFormationRepository;

    public ThemeController(ThemeFormationRepository themeFormationRepository) {
        this.themeFormationRepository = themeFormationRepository;
    }

    @GetMapping
    public String afficherThemes(Model model) {
        model.addAttribute("themeForm", new ThemeFormation());
        model.addAttribute("themes", themeFormationRepository.findAll());
        return "themes";
    }

    @PostMapping("/ajouter")
    public String ajouterTheme(@ModelAttribute("themeForm") ThemeFormation themeForm) {
        themeFormationRepository.save(themeForm);
        return "redirect:/themes";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerTheme(@PathVariable Long id) {
        if (themeFormationRepository.existsById(id)) {
            themeFormationRepository.deleteById(id);
        }
        return "redirect:/themes";
    }
}