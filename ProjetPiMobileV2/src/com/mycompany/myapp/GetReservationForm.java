/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.DemandeEvenement;
import com.mycompany.myapp.Entity.Reservation;
import com.mycompany.myapp.services.DemenedeEvenementService;
import com.mycompany.myapp.services.ReservationService;
import java.util.ArrayList;

/**
 *
 * @author hedib
 */
public class GetReservationForm extends SideMenuBaseForm  {
 SpanLabel sp = new SpanLabel();
    Reservation d=new Reservation();
ArrayList<Reservation>r;
    public GetReservationForm(Resources res) {




 super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
        profilePicLabel.setMask(mask.createMask());

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        
        Container remainingTasks = BoxLayout.encloseY(
                        new Label("12", "CenterTitle"),
                        new Label("remaining tasks", "CenterSubTitle")
                );
        remainingTasks.setUIID("RemainingTasks");
        Container completedTasks = BoxLayout.encloseY(
                        new Label("32", "CenterTitle"),
                        new Label("completed tasks", "CenterSubTitle")
        );
        completedTasks.setUIID("CompletedTasks");

        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.centerAbsolute(
                                BoxLayout.encloseY(
                                    new Label("Jennifer Wilson", "Title"),
                                    new Label("UI/UX Designer", "SubTitle")
                                )
                            ).add(BorderLayout.WEST, profilePicLabel),
                        GridLayout.encloseIn(2, remainingTasks, completedTasks)
                );
        
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        fab.getAllStyles().setMargin(BOTTOM, completedTasks.getPreferredH() - fab.getPreferredH() / 2);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));
fab.addActionListener(e->new AddDemenedeEvenement(this).show());
                        
        add(new Label("Listes des reservations", "TodayTitle"));
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
       
 sp.setText(ReservationService.getInstance().getAllReservations().toString());
r=ReservationService.getInstance().getAllReservations();
for(Reservation r:r){
      addItem(r,res);
    }
//for(DemandeEvenement d :sp)
       // add(sp);
//getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e->this.showBack());
    //    addButtonBottom(arrowDown, "Finish landing page concept", 0xd997f1, true);
    //    addButtonBottom(arrowDown, "Design app illustrations", 0x5ae29d, false);
    //    addButtonBottom(arrowDown, "Javascript training ", 0x4dc2ff, false);
    //    addButtonBottom(arrowDown, "Surprise Party for Matt", 0xffc06f, false);
    //    setupSideMenu(res);
    }
    public void addItem(Reservation r,Resources res){
Container c1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
 FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e->this.showBack());
        addButtonBottom(arrowDown, r.getStatut(), 0xd997f1, true,r);
      //  addButtonBottom(arrowDown, "Design app illustrations", 0x5ae29d, false,d);
        //addButtonBottom(arrowDown, "Javascript training ", 0x4dc2ff, false,d);
        //addButtonBottom(arrowDown, "Surprise Party for Matt", 0xffc06f, false,d);
        //setupSideMenu(res);
//Label l1 =new Label (d.getDate_demande());
//c1.add(l1);
//this.add(c1);
//this.add(c1);
}
    private void addButtonBottom(Image arrowDown, String text, int color, boolean first,Reservation r) {
        MultiButton finishLandingPage = new MultiButton(text);
        finishLandingPage.setEmblem(arrowDown);
        finishLandingPage.setUIID("Container");
        finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIcon(createCircleLine(color, finishLandingPage.getPreferredH(),  first));
        finishLandingPage.setIconUIID("Container");

//finishLandingPage.addActionListener(e->new UpdateDemandeEvenementForm(this,d).show());

        add(FlowLayout.encloseIn(finishLandingPage));
    

  }
    
    private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if(first) {
            y = height / 6 + 1;
        }
        g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    }

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }

    
}
