/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.Entity;

/**
 *
 * @author manou
 */
public class CoutEvenement {
private int id;
private int NbBillet;
private float prix;
private int coutcategorie;
private int demandeEvent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbBillet() {
        return NbBillet;
    }

    public void setNbBillet(int NbBillet) {
        this.NbBillet = NbBillet;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getCoutcategorie() {
        return coutcategorie;
    }

    public void setCoutcategorie(int coutcategorie) {
        this.coutcategorie = coutcategorie;
    }

    public int getDemandeEvent() {
        return demandeEvent;
    }

    public void setDemandeEvent(int demandeEvent) {
        this.demandeEvent = demandeEvent;
    }

    public CoutEvenement(int id, int NbBillet, float prix, int coutcategorie, int demandeEvent) {
        this.id = id;
        this.NbBillet = NbBillet;
        this.prix = prix;
        this.coutcategorie = coutcategorie;
        this.demandeEvent = demandeEvent;
    }

    public CoutEvenement() {
    }

    
}
