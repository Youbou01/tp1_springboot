package com.example.tp1.repositories;

import com.example.tp1.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    List<Etudiant> findByNom(String nom);

    List<Etudiant> findByNomContaining(String nom);

    @Query("SELECT e FROM Etudiant e WHERE e.adresse.ville = :ville")
    List<Etudiant> findByVille(@Param("ville") String ville);

    @Query(value = "SELECT * FROM etudiant WHERE date_naissance > :date", nativeQuery = true)
    List<Etudiant> findByDateNaissanceAfter(@Param("date") LocalDate date);
}
