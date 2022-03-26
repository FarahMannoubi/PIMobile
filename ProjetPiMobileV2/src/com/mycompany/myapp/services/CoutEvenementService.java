/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.services;

import com.codename1.io.ConnectionRequest;
import com.mycompany.myapp.Entity.CoutEvenement;
import com.mycompany.myapp.Entity.DemandeEvenement;
import java.util.ArrayList;

/**
 *
 * @author manou
 */
public class CoutEvenementService {
public ArrayList<CoutEvenement> coutEvenements;
 public static CoutEvenementService instance=null;
public static boolean resultOK=true;
   private ConnectionRequest req;
//public boolean resultOK=true;


 

  private CoutEvenementService() {
         req = new ConnectionRequest();
    }

 public static CoutEvenementService getInstance() {
        if (instance == null) {
            instance = new CoutEvenementService();
        }
        return instance;
    }
    
}
