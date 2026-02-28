package com.example.tp1.repositories;

import com.example.tp1.entities.EtatLivre;
import com.example.tp1.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Integer> {

    List<Livre> findByTitre(String titre);

    Livre findByIsbn(String isbn);

    List<Livre> findByEtat(EtatLivre etat);

    List<Livre> findByNbCopiesLessThan(int nbCopies);

    @Query(value = "SELECT * FROM livre_biblio ORDER BY auteur_livre", nativeQuery = true)
    List<Livre> findAllOrderByAuteur();
}
