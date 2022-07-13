/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Schedule;
import Model.Client;
import Model.Service;
import Model.User;
import java.util.ArrayList;

/**
 *
 * @author manoel.carvalho
 */
public class Banco {
    
    public static ArrayList<User> user;
    public static ArrayList<Client> client;
    public static ArrayList<Service> service;
    public static ArrayList<Schedule> schedule;
    
    public static void inicia(){
        
        //Instancia os Objetos
        user = new ArrayList<User>();
        client = new ArrayList<Client>();
        service = new ArrayList<Service>();
        schedule = new ArrayList<Schedule>();
        
        //criando elementos 
        
        User user1 = new User(1,"barbeiro",'M',"09/06/1996","986744859","barbeiro@email.com","9858-000","12345","alto");
        User user2 = new User(2,"barbeiro2",'M',"09/06/2000","998547374","barbeiro@gmail.cm","8794-000","1234","medio");
        
        Client client1 = new Client(1,"João",'M',"20/08/1970","39230920","joao@gmail.com","34449933-32","Rua ismael","23450-000");
        Client client2 = new Client(2,"Carlos",'M',"20/08/1994","39230782","carlos@gmail.com","34449933-70","Rua chechin","23888-000");
        
        Service service1 = new Service(1,"Corte Simples", 20);
        Service service2 = new Service (2,"barba",15);
        
       // Schedule schedule1 = new Schedule()
    }
    
}
