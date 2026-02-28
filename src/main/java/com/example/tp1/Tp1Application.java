package com.example.tp1;

import com.example.tp1.entities.*;
import com.example.tp1.repositories.EtatLivreRepository;
import com.example.tp1.repositories.EtudiantRepository;
import com.example.tp1.repositories.LivreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Tp1Application implements CommandLineRunner {

    EtudiantRepository etudiantRepository;
    LivreRepository livreRepository;
    EtatLivreRepository etatLivreRepository;

    public Tp1Application(EtudiantRepository etudiantRepository, LivreRepository livreRepository, EtatLivreRepository etatLivreRepository) {
        this.etudiantRepository = etudiantRepository;
        this.livreRepository = livreRepository;
        this.etatLivreRepository = etatLivreRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Tp1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Adresse adresse1 = new Adresse();
        adresse1.setNumAppart(10);
        adresse1.setRue("Rue de la Paix");
        adresse1.setVille("Paris");
        adresse1.setCodePostal("75001");

        Adresse adresse2 = new Adresse();
        adresse2.setNumAppart(25);
        adresse2.setRue("Avenue des Fleurs");
        adresse2.setVille("Lyon");
        adresse2.setCodePostal("69001");

        Etudiant etudiant1 = new Etudiant("Dupont", "Alice", LocalDate.of(2000, 3, 15));
        etudiant1.setAdresse(adresse1);

        Etudiant etudiant2 = new Etudiant("Martin", "Bob", LocalDate.of(1999, 7, 22));
        etudiant2.setAdresse(adresse2);

        etudiantRepository.save(etudiant1);
        etudiantRepository.save(etudiant2);

        System.out.println("=== Etudiants ===");
        for (Etudiant e : etudiantRepository.findAll()) {
            System.out.println(e);
        }

        EtatLivre etat1 = new EtatLivre();
        etat1.setDisponible(true);
        etat1.setEmprunte(true);

        EtatLivre etat2 = new EtatLivre();
        etat2.setDisponible(true);
        etat2.setEmprunte(false);

        etatLivreRepository.save(etat1);
        etatLivreRepository.save(etat2);

        Livre livre1 = new Livre("111", "Java Avancé", "Auteur A", LocalDate.of(2020, 1, 1), 3);
        livre1.setEtat(etat1);

        Livre livre2 = new Livre("222", "Spring Boot", "Auteur B", LocalDate.of(2021, 5, 10), 2);
        livre2.setEtat(etat1);

        Livre livre3 = new Livre("333", "Hibernate", "Auteur C", LocalDate.of(2019, 9, 20), 1);
        livre3.setEtat(etat2);

        livreRepository.save(livre1);
        livreRepository.save(livre2);
        livreRepository.save(livre3);

        System.out.println("=== Livres ===");
        for (Livre l : livreRepository.findAll()) {
            System.out.println(l);
        }

        etudiant1.setLivres(Arrays.asList(livre1, livre3));
        etudiantRepository.save(etudiant1);





        System.out.println("\n=== Livres par titre 'Spring Boot' ===");
        for (Livre l : livreRepository.findByTitre("Spring Boot")) {
            System.out.println(l);
        }

        System.out.println("\n=== Etudiants par nom exact 'Dupont' ===");
        for (Etudiant e : etudiantRepository.findByNom("Dupont")) {
            System.out.println(e);
        }

        System.out.println("\n=== Etudiants par nom contenant 'ar' ===");
        for (Etudiant e : etudiantRepository.findByNomContaining("ar")) {
            System.out.println(e);
        }

        System.out.println("\n=== Livre par ISBN '111' ===");
        System.out.println(livreRepository.findByIsbn("111"));

        System.out.println("\n=== Livres avec état 1 (disponible=true, emprunté=true) ===");
        for (Livre l : livreRepository.findByEtat(etat1)) {
            System.out.println(l);
        }

        System.out.println("\n=== Livres avec moins de 3 exemplaires ===");
        for (Livre l : livreRepository.findByNbCopiesLessThan(3)) {
            System.out.println(l);
        }


        System.out.println("\n=== Etudiants habitant à Paris (JPQL) ===");
        for (Etudiant e : etudiantRepository.findByVille("Paris")) {
            System.out.println(e);
        }

        System.out.println("\n=== Livres ordonnés par auteur (Native) ===");
        for (Livre l : livreRepository.findAllOrderByAuteur()) {
            System.out.println(l);
        }

        System.out.println("\n=== Etudiants nés après le 01/01/2000 (Native) ===");
        for (Etudiant e : etudiantRepository.findByDateNaissanceAfter(LocalDate.of(2000, 1, 1))) {
            System.out.println(e);
        }
    }
}
