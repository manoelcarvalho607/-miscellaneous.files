/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import View.Agenda;
import View.MainScreen;

/**
 *
 * @author visitante
 */
public class MainController {
    
    private final MainScreen view;

    public MainController(MainScreen view) {
        this.view = view;
    }
    
    public void navegarAgenda(){
       
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
         this.view.dispose();
       
    }
    
}
