package com.example.tp1.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Adresse implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int code;

    private int numAppart;
    private String rue;
    private String ville;
    private String codePostal;

    public Adresse(int code, int numAppart, String rue, String ville, String codePostal) {
        this.code = code;
        this.numAppart = numAppart;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Adresse() {}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getNumAppart() {
        return numAppart;
    }

    public void setNumAppart(int numAppart) {
        this.numAppart = numAppart;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "Adresse{code=" + code + ", numAppart=" + numAppart + ", rue='" + rue + "', ville='" + ville + "', codePostal='" + codePostal + "'}";
    }
}
