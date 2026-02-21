package com.example.tp1.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "livre_biblio")
public class Livre implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "code")
    private Integer code;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "titre_livre", nullable = false)
    private String titre;

    @Column(name = "auteur_livre", length = 40, nullable = false)
    private String auteur;

    @Column(name = "date_publication")
    private LocalDate datePublication;

    @Column(name = "nb_copies")
    private Integer nbCopies;

    public Livre() {
    }

    public Livre(String isbn, String titre, String auteur, LocalDate datePublication, Integer nbCopies) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nbCopies = nbCopies;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public Integer getNbCopies() {
        return nbCopies;
    }

    public void setNbCopies(Integer nbCopies) {
        this.nbCopies = nbCopies;
    }
}