/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Connexion.Connexion;
import com.mycompany.myapp.Entity.DemandeEvenement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author manou
 */
public class DemenedeEvenementService {
     public ArrayList<DemandeEvenement> demandeEvenements;
 public static DemenedeEvenementService instance=null;
public static boolean resultOK=true;
   private ConnectionRequest req;
//public boolean resultOK=true;


 

  private DemenedeEvenementService() {
         req = new ConnectionRequest();
    }

 public static DemenedeEvenementService getInstance() {
        if (instance == null) {
            instance = new DemenedeEvenementService();
        }
        return instance;
    }


public boolean addDemenedeEvenenement(DemandeEvenement d){

       String url = Connexion.BASE_URL+"/add/DemandeEvenement1?date_demande="+d.getDate_demande()+"&statut="+d.getStatut()+
"&description_demande="+d.getDescription_demande()+"&date_debutEvent="+d.getDate_debutEvent()+
"&date_finEvent="+d.getDate_finEvent()+"&heure_debutEvent="
+d.getHeure_debutEvent()+"&heure_finEvent="+d.getHeure_finEvent()+"&description_event="
+d.getDescription_event()+"&capacite="+d.getCapacite()+
 "&destination="+d.getDestination()+"&libelleEvenement="+d.getLibelleEvenement()+"&image="+d.getImage()+
"&utilisateur="+1+""; 
     
    
       req.setUrl(url);
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
       return resultOK;
    
}
public boolean updateDemenedeEvenenement(DemandeEvenement d){

       String url = Connexion.BASE_URL+"/put/DemandeEvenement/"+d.getId()+"?date_demande="+d.getDate_demande()+"&statut="+d.getStatut()+
"&description_demande="+d.getDescription_demande()+"&date_debutEvent="+d.getDate_debutEvent()+
"&date_finEvent="+d.getDate_finEvent()+"&heure_debutEvent="
+d.getHeure_debutEvent()+"&heure_finEvent="+d.getHeure_finEvent()+"&description_event="
+d.getDescription_event()+"&capacite="+d.getCapacite()+
 "&destination="+d.getDestination()+"&libelleEvenement="+d.getLibelleEvenement()+"&image="+d.getImage()+
"&utilisateur="+1+""; 
     
    
       req.setUrl(url);
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
       return resultOK;
    
}
public ArrayList<DemandeEvenement> parseDemandeEvenements(String jsonText){
        try {
            demandeEvenements=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> DemandeEvenementsListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list =(List<Map<String,Object>>)DemandeEvenementsListJson.get("root");
           
for(Map<String,Object> obj : list){
                DemandeEvenement d = new DemandeEvenement();

                float id = Float.parseFloat(obj.get("id").toString());
                d.setId((int)id);


if(obj.get("date_demande")==null)
d.setDate_demande("null");
else                
 d.setDate_demande(obj.get("date_demande").toString());
  
     
 if(obj.get("statut")==null)
d.setStatut("null");
else        
 d.setStatut(obj.get("statut").toString());
    

          
  if(obj.get("description_demande")==null)
d.setDescription_demande("null");
else        
 d.setDescription_demande(obj.get("description_demande").toString());



if(obj.get("date_debutEvent")==null)
d.setDate_debutEvent(null);
else        
 d.setDate_debutEvent(obj.get("date_debutEvent").toString());


if(obj.get("date_finEvent")==null)
d.setDate_finEvent("null");
else        
 d.setDate_finEvent(obj.get("date_finEvent").toString());


if(obj.get("heure_debutEvent")==null)
d.setHeure_debutEvent("null");
else        
 d.setHeure_debutEvent(obj.get("heure_debutEvent").toString());



if(obj.get("heure_finEvent")==null)
d.setHeure_finEvent("null");
else        
 d.setHeure_finEvent(obj.get("heure_finEvent").toString());

if(obj.get("description_event")==null)
d.setDescription_event("null");
else        
 d.setDescription_event(obj.get("description_event").toString());

    float idUtilisateur = Float.parseFloat(obj.get("id").toString());
                d.setUtilisateur((int)idUtilisateur);

                  
                float capacite = Float.parseFloat(obj.get("capacite").toString());
                d.setCapacite((int)capacite);

  if(obj.get("libelleEvenement")==null)
d.setLibelleEvenement("null");
else        
 d.setLibelleEvenement(obj.get("libelleEvenement").toString());

                demandeEvenements.add(d);
            }
            
            
        } catch (IOException ex) {
            
        }
        return  demandeEvenements;
    }
 public ArrayList< DemandeEvenement> getAlldemandeEvenements(){
       
        String url = Connexion.BASE_URL+"/get/DemandeEvenement";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                demandeEvenements = parseDemandeEvenements(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return demandeEvenements;
    }
public boolean deleteDemandeEvenement(int id){
String url = Connexion.BASE_URL+"/deletDemandeEvenement/"+id;
        req.setUrl(url);
  req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                req.removeResponseCodeListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;

}
    
}
