/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.Entity;

/**
 *
 * @author hedib
 */
public class Reservation {
private int id;
private String date_res;
private String heure_res;
private String statut;
private float cout;
private int demandeEvnet;
private int utilisateur;

    public Reservation() {
    }

    public Reservation(int id, String date_res, String heure_res, String statut, float cout, int demandeEvnet, int utilisateur) {
        this.id = id;
        this.date_res = date_res;
        this.heure_res = heure_res;
        this.statut = statut;
        this.cout = cout;
        this.demandeEvnet = demandeEvnet;
        this.utilisateur = utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_res() {
        return date_res;
    }

    public void setDate_res(String date_res) {
        this.date_res = date_res;
    }

    public String getHeure_res() {
        return heure_res;
    }

    public void setHeure_res(String heure_res) {
        this.heure_res = heure_res;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public int getDemandeEvnet() {
        return demandeEvnet;
    }

    public void setDemandeEvnet(int demandeEvnet) {
        this.demandeEvnet = demandeEvnet;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    
}
