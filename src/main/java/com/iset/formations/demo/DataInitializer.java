package com.iset.formations.demo;

import com.iset.formations.demo.model.ThemeFormation;
import com.iset.formations.demo.repository.ThemeFormationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initThemes(ThemeFormationRepository themeRepository) {
        return args -> {
            if (themeRepository.findByTheme("Réseaux & Cybersécurité") == null) {
                ThemeFormation t1 = new ThemeFormation();
                t1.setTheme("Réseaux & Cybersécurité");
                t1.setMotsCles("TCP/IP, Linux, Sécurité, Firewall");
                themeRepository.save(t1);
            }
            if (themeRepository.findByTheme("Intelligence Artificielle & Data") == null) {
                ThemeFormation t2 = new ThemeFormation();
                t2.setTheme("Intelligence Artificielle & Data");
                t2.setMotsCles("Python, Machine Learning, SQL, Data");
                themeRepository.save(t2);
            }
            if (themeRepository.findByTheme("Cloud & DevOps") == null) {
                ThemeFormation t3 = new ThemeFormation();
                t3.setTheme("Cloud & DevOps");
                t3.setMotsCles("Docker, Git, CI/CD, Virtualisation");
                themeRepository.save(t3);
            }
        };
    }
}