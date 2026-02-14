package com.example.tp1;

import com.example.tp1.entities.Etudiant;
import com.example.tp1.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    public DemoApplication(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
    EtudiantRepository etudiantRepository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        etudiantRepository.save(new Etudiant("Juanito", "Maria", LocalDate.of(1980, 1, 1)));

    }
}
