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
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.mycompany.myapp.Entity.DemandeEvenement;
import com.mycompany.myapp.services.DemenedeEvenementService;

import java.util.Date;


/**
 *
 * @author manou
 */
public class UpdateDemandeEvenementForm extends Form {
public UpdateDemandeEvenementForm(Form previous,DemandeEvenement d) {
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

TextField tfdescription_demande = new TextField(d.getDescription_demande(), d.getDescription_demande(), 20, TextArea.ANY);
tfdescription_demande.setUIID("TextFieldBlack");
TextField tflibelleEvenement = new TextField(d.getLibelleEvenement(), d.getLibelleEvenement());

TextField tfdescription_event = new TextField(d.getDescription_event());
        


Picker dateDebutEvenement = new Picker();
dateDebutEvenement.setType(Display.PICKER_TYPE_DATE);
 Date date;
 try{
        date = new SimpleDateFormat("yyyy-MM-dd").parse(d.getDate_debutEvent());
dateDebutEvenement.setDate(date);    
}catch (ParseException var4) {
    var4.printStackTrace();
}





Picker datefinEvenement = new Picker();
datefinEvenement.setType(Display.PICKER_TYPE_DATE);
 Date date1;
   try{
        date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d.getDate_finEvent());
dateDebutEvenement.setDate(date1);  
 
}catch (ParseException var5) {
    var5.printStackTrace();
}
Picker timePickerheure_debutEvent = new Picker();
timePickerheure_debutEvent.setType(Display.PICKER_TYPE_TIME);
 

Picker timePickerheure_finEvent = new Picker();
timePickerheure_finEvent.setType(Display.PICKER_TYPE_TIME);

TextField tfCapacite  = new TextField(d.getCapacite());

  
 Button btnModifier = new Button("Modifier");
        

 Button btnSupprimer = new Button("Supprimer");
btnSupprimer.addActionListener(new ActionListener() {
 @Override
            public void actionPerformed(ActionEvent evt) {

 if( DemenedeEvenementService.getInstance().deleteDemandeEvenement(d.getId()))
                        {
                           Dialog.show("Success","Supppppppppppppppppp",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));

}
});


        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfCapacite.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {

SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

int id=d.getId();
DemandeEvenement d = new DemandeEvenement(id,
"1230-10-22"
,"en attente",tfdescription_demande.getText()
,format.format(dateDebutEvenement.getDate()),format.format(datefinEvenement.getDate()),format.format(datefinEvenement.getDate())
,format.format(datefinEvenement.getDate()),tfdescription_event.getText(),Integer.parseInt(tfCapacite.getText())
,1,tflibelleEvenement.getText(),tflibelleEvenement.getText(),1);
                       if( DemenedeEvenementService.getInstance().updateDemenedeEvenenement(d))
                        {
//finishLandingPage.addActionListener(e->new UpdateDemandeEvenementForm(this,d).show());
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                                

                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }      
                
            }
        });
        hi.add("Description demande").add(tfdescription_demande).add("Evenement").add(tflibelleEvenement).add("Description Evenement").add(tfdescription_event).add("Date Debut Evenement").add(dateDebutEvenement).add("Date Fin Evenement").add(datefinEvenement).add("Heure Debut Evenement").add(timePickerheure_debutEvent).add("Heure Fin Evenement").add(timePickerheure_finEvent).add("Capacite").add(tfCapacite).add(btnModifier).add(btnSupprimer);
      //addAll(tfdescription_demande,tflibelleEvenement,tfdescription_event,tfDateDebutEvenement,dateDebutEvenement,tfDateFinEvenement,datefinEvenement,tfheure_debutEvent,timePickerheure_debutEvent,tfheure_finEvent,timePickerheure_finEvent,tfCapacite,btnValider);
     
getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());


}

    
}
