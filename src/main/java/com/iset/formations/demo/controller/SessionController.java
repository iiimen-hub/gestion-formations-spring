package com.iset.formations.demo.controller;

import com.iset.formations.demo.model.SessionFormation;
import com.iset.formations.demo.repository.SessionFormationRepository;
import com.iset.formations.demo.repository.ThemeFormationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sessions")
public class SessionController {

    private final SessionFormationRepository sessionRepository;
    private final ThemeFormationRepository themeRepository;

    public SessionController(SessionFormationRepository sessionRepository,
                             ThemeFormationRepository themeRepository) {
        this.sessionRepository = sessionRepository;
        this.themeRepository = themeRepository;
    }

    @GetMapping
    public String listeSessions(Model model) {
        model.addAttribute("sessions", sessionRepository.findAll());
        return "sessions";
    }

    @GetMapping("/nouvelle")
    public String nouvelleSession(Model model) {
        model.addAttribute("sessionForm", new SessionFormation());
        model.addAttribute("themes", themeRepository.findAll());
        return "nouvelle_session";
    }

    @PostMapping("/enregistrer")
    public String enregistrerSession(@ModelAttribute("sessionForm") SessionFormation sessionFormation) {
        sessionRepository.save(sessionFormation);
        return "redirect:/sessions";
    }
}