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
import com.mycompany.myapp.Entity.Reservation;
import static com.mycompany.myapp.services.DemenedeEvenementService.resultOK;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hedib
 */
public class ReservationService {
    public ArrayList<Reservation> reservations;
 public static ReservationService instance=null;
public static boolean resultOK=true;
   private ConnectionRequest req;
//public boolean resultOK=true;


 

  private ReservationService() {
         req = new ConnectionRequest();
    }

 public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }



public boolean addReservation(Reservation r){

       String url = Connexion.BASE_URL+"/add/Reservation1?date_res="+r.getDate_res()+"&heure_res="+r.getHeure_res()+
"&statut="+r.getStatut()+"&cout="+r.getCout()+
"&utilisateur="+r.getUtilisateur()+"&demandeEvent="
+r.getDemandeEvnet()+"";
     
    
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





public ArrayList<Reservation> parseReservations(String jsonText){
        try {
            reservations=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> ReservationsListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list =(List<Map<String,Object>>)ReservationsListJson.get("root");
           
for(Map<String,Object> obj : list){
                Reservation r =new Reservation();

                float id = Float.parseFloat(obj.get("id").toString());
                r.setId((int)id);


if(obj.get("date_res")==null)
r.setDate_res(null);
else                
 r.setDate_res(obj.get("date_res").toString());
  
     
 if(obj.get("heure_res")==null)
r.setHeure_res(null);
else        
r.setHeure_res(obj.get("heure_res").toString());
    

          
  if(obj.get("statut")==null)
r.setStatut("null");
else        
r.setStatut(obj.get("statut").toString());


 // float idDemandeEvent = Float.parseFloat(obj.get("demandeEvent").toString());
  //              r.setDemandeEvnet((int)idDemandeEvent);

 //   float idUtilisateur = Float.parseFloat(obj.get("utilisateur").toString());
 //               r.setUtilisateur((int)idUtilisateur);

                  
                reservations.add(r);
            }
            
            
        } catch (IOException ex) {
            
        }
        return  reservations;
    }
 public ArrayList< Reservation> getAllReservations(){
       
        String url = Connexion.BASE_URL+"/displayReservation";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reservations = parseReservations(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reservations;
    }


public boolean deletReservation(int id){
String url = Connexion.BASE_URL+"/deletReservation/"+id;
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
