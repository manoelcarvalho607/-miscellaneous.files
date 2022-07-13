/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import DAO.UserDAO;
import Model.User;
import View.Login;
import View.MainScreen;

/**
 *
 * @author manoel.carvalho
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;
    
    
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    
     public void enterSystem(){
        //pegar usuario da view
         User user = helper.getModel();
         
         MainScreen main = new MainScreen();
           main.setVisible(true);
           this.view.dispose();
        
        //pesquisar no banco
       // UserDAO userDAO = new UserDao();
       // User userAutenticado = userDAO.selectPorNomeESenha(user);
       
       /*
       if(userAutenticado != null){
           MainScreen main = new MainScreen();
           main.setVisible(true);
       }else{
           view.exibeMensagem("Usuario ou senha invalidos");
       }
       */
       
        //se o usuario da view tiver o mesmo login e senha do usuario vindo do banco , vai se redirecionando para tela MainScreen 
        ///se de erro vaia mostrar uma mensagem de erro
    }
    
    
    
}
