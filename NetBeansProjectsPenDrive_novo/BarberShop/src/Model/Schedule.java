/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import static java.util.Date.parse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author visitante
 */
public class Schedule {
    
    
    private int id;
    private Client client;
    private Service service;
    private float valor;
    private Date date;
    private String obs;

    public Schedule(int id, Client client, Service service, float valor, String date) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.valor = valor;
        try {
            this.date = new SimpleDateFormat("dd/WW/yyyy HH:mm").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Schedule(int id, Client client, Service service, float valor, String date,String obs) {
        this(id,client,service,valor,date);
        this.obs = obs;
    
    }

    public Schedule() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDate() {
        return date;
    }
    
    public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

     public String getHoraFormatada(){
        return new SimpleDateFormat("HH:mm").format(date);
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void insert(Schedule schedule) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
