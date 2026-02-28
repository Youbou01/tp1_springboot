package com.example.tp1.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class EtatLivre implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int code;

    private boolean disponible;

    @Column(name = "emprunte")
    private boolean emprunte;

    public EtatLivre() {}

    public EtatLivre(int code, boolean disponible, boolean emprunte) {
        this.code = code;
        this.disponible = disponible;
        this.emprunte = emprunte;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isEmprunte() {
        return emprunte;
    }

    public void setEmprunte(boolean emprunte) {
        this.emprunte = emprunte;
    }

    @Override
    public String toString() {
        return "EtatLivre{code=" + code + ", disponible=" + disponible + ", emprunte=" + emprunte + "}";
    }
}
