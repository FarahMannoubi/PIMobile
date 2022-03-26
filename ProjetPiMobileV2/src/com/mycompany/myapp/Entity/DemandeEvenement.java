/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.Entity;

import java.util.Date;

/**
 *
 * @author manou
 */
public class DemandeEvenement {
private int id;
private String date_demande;
private String statut;
private String description_demande;
private String date_debutEvent;
private String date_finEvent;
private String heure_debutEvent;
private String heure_finEvent;
private String description_event;
private int capacite;
private int destination;
private String libelleEvenement;
private int utilisateur;
private String image;
 public DemandeEvenement(){}

    public DemandeEvenement(int id , String date_demande, String statut, String description_demande
 , String date_debutEvent, String date_finEvent, String heure_debutEvent, String heure_finEvent,
 String description_event, int capacite,int destination,
String libelleEvenement,String image,int utilisateur) {
        this.id = id;
        this.date_demande = date_demande;
        this.statut = statut;
        this.description_demande = description_demande;
        this.date_debutEvent = date_debutEvent;
        this.date_finEvent = date_finEvent;
        this.heure_debutEvent = heure_debutEvent;
        this.heure_finEvent = heure_finEvent;
        this.description_event = description_event;
        this.capacite = capacite;
        this.destination=destination;
        this.libelleEvenement=libelleEvenement;
       this.utilisateur=utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_demande() {
        return date_demande;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public String getLibelleEvenement() {
        return libelleEvenement;
    }

    public void setLibelleEvenement(String libelleEvenement) {
        this.libelleEvenement = libelleEvenement;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDate_demande(String date_demande) {
        this.date_demande = date_demande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDescription_demande() {
        return description_demande;
    }

    public void setDescription_demande(String description_demande) {
        this.description_demande = description_demande;
    }

    public String getDate_debutEvent() {
        return date_debutEvent;
    }

    public void setDate_debutEvent(String date_debutEvent) {
        this.date_debutEvent = date_debutEvent;
    }

    public String getDate_finEvent() {
        return date_finEvent;
    }

    public void setDate_finEvent(String date_finEvent) {
        this.date_finEvent = date_finEvent;
    }

    public String getHeure_debutEvent() {
        return heure_debutEvent;
    }

    public void setHeure_debutEvent(String heure_debutEvent) {
        this.heure_debutEvent = heure_debutEvent;
    }

    public String getHeure_finEvent() {
        return heure_finEvent;
    }

    public void setHeure_finEvent(String heure_finEvent) {
        this.heure_finEvent = heure_finEvent;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
  public int getUtilisateur() {
        return id;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    

 @Override
    public String toString() {
        return "Les Demande Evenement "+"\n"+"\n"+ "Date demande"+"\n" + date_demande +"\n"+"\n" + "Statut"+"\n" + statut +"\n" +"\n" + "Description Demande"+ "\n" + description_demande + "\n" + "\n"+" Date Debut Evenement "+"\n" +date_debutEvent+"\n"+"\n"+" Date Fin Evenement "+"\n" +date_finEvent+"\n"+"\n"+" heure Debut Evenement "+heure_debutEvent+"\n"+"\n"+" heure Fin Evenement "+heure_finEvent+"\n"+"\n"+" Description Evenement "+description_event+"\n"+"\n"+" capacite "+"\n"+capacite+"\n"+"\n"+" utilisateur "+"\n"+utilisateur+"\n"+"\n";
    }


    
}
