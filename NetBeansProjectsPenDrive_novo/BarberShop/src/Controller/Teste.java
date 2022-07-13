/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Agenda;
import View.Login;
import View.MainScreen;

/**
 *
 * @author visitante
 */
public class Teste {
    
    static void main(String[] args){
        Login login = new Login();
        login.setVisible(true);
        MainScreen ms = new MainScreen();
       ms.setVisible(true);
       Agenda agenda = new Agenda();
       agenda.setVisible(true);
        
    }
    
}
