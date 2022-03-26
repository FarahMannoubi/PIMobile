/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
//import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.mycompany.myapp.Entity.DemandeEvenement;
import com.mycompany.myapp.services.DemenedeEvenementService;
import java.util.Date;
//import javafx.scene.control.DatePicker;

/**
 *
 * @author manou
 */
public class AddDemenedeEvenement extends Form {


public AddDemenedeEvenement(Form previous){
Form hi=this;
TableLayout tl;
int spanButton = 2;
if(Display.getInstance().isTablet()) {
    tl = new TableLayout(7, 2);
} else {
    tl = new TableLayout(14, 1);
    spanButton = 1;
}
tl.setGrowHorizontally(true);
hi.setLayout(tl);
setTitle(" Nouvelle Demande ");
//setLayout(BoxLayout.y());

TextField tfdescription_demande = new TextField("", "Notre association/société [nom de l’association/société] souhaiterait organiser un évènement public... ", 20, TextArea.ANY);

TextField tflibelleEvenement = new TextField("", "préciser nom de l’évènement");

TextField tfdescription_event = new TextField("", " un évènement public,savoir[préciser type d’évènement]");
        


Picker dateDebutEvenement = new Picker();
dateDebutEvenement.setType(Display.PICKER_TYPE_DATE);
 Date date;
try{
        date = new SimpleDateFormat("yyyy-MM-dd").parse("1230-10-22");
dateDebutEvenement.setDate(date);    
}catch (ParseException var4) {
    var4.printStackTrace();
}

Picker datefinEvenement = new Picker();
datefinEvenement.setType(Display.PICKER_TYPE_DATE);
 


Picker timePickerheure_debutEvent = new Picker();
timePickerheure_debutEvent.setType(Display.PICKER_TYPE_TIME);
 

Picker timePickerheure_finEvent = new Picker();
timePickerheure_finEvent.setType(Display.PICKER_TYPE_TIME);

TextField tfCapacite  = new TextField("", "1234", 4, TextArea.NUMERIC); 

  
 Button btnValider = new Button("Ajouter");
        


        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfCapacite.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {

SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");


DemandeEvenement d = new DemandeEvenement(0,
"1230-10-22"
,"en attente",tfdescription_demande.getText()
,format.format(dateDebutEvenement.getDate()),format.format(datefinEvenement.getDate()),format.format(datefinEvenement.getDate())
,format.format(datefinEvenement.getDate()),tfdescription_event.getText(),Integer.parseInt(tfCapacite.getText())
,1,tflibelleEvenement.getText(),tflibelleEvenement.getText(),1); 
                       if( DemenedeEvenementService.getInstance().addDemenedeEvenenement(d))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
   new DemandeEvenementAddCoutEvenement(hi,d).show();
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }      
                
            }
        });
        hi.add("Description demande").add(tfdescription_demande).add("Evenement").add(tflibelleEvenement).add("Description Evenement").add(tfdescription_event).add("Date Debut Evenement").add(dateDebutEvenement).add("Date Fin Evenement").add(datefinEvenement).add("Heure Debut Evenement").add(timePickerheure_debutEvent).add("Heure Fin Evenement").add(timePickerheure_finEvent).add("Capacite").add(tfCapacite).add(btnValider);
      //addAll(tfdescription_demande,tflibelleEvenement,tfdescription_event,tfDateDebutEvenement,dateDebutEvenement,tfDateFinEvenement,datefinEvenement,tfheure_debutEvent,timePickerheure_debutEvent,tfheure_finEvent,timePickerheure_finEvent,tfCapacite,btnValider);
     
getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
}
    
}

