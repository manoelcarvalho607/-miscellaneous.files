/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.User;
import View.Login;

/**
 *
 * @author visitante
 */
public class LoginHelper implements IHelper {
    
    private final Login view;
    
    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public User getModel() {
        String name = view.getTxtUser().getText();
        String password = view.getTxtPassword().getText();
        User model = new User(0,name,password);
        
        return model;
    }
    
    public void setarModel(User model) {
        String name = model.getNome();
        String password = model.getSenha();
        
        view.getTxtUser().setText(name);
        view.getTxtPassword().setText(password);
    }
    
    public void screenClean() {
        view.getTxtUser().setText("");
        view.getTxtPassword().setText("");
    }

    @Override
    public Object obterModelo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void limparTela() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
