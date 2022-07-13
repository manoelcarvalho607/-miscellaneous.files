/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;



/**
 *
 * @author manoel.carvalho
 */
public class User extends People {
    
   
    protected String senha;
    protected String nivelAcesso;

    public User(int id, String nome, String senha ) {
        super(id, nome);
        this.senha = senha;
    }

    public User(int id, String nome, char sexo, String dataNascimento, String telefone,  String email, String cpf, String senha, String nivelAcesso) {
        super(id, nome, sexo, dataNascimento, telefone, email, cpf);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    

  
    
    
    
    
}
