/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.ScheduleHelper;
import DAO.ClientDAO;
import DAO.ScheduleDAO;
import DAO.ServiceDAO;
import Model.Client;
import Model.Schedule;
import Model.Service;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class AgendaController {
    
    private final Agenda view;
    private final ScheduleHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new ScheduleHelper(view);
    }
    
    
   public void atualizarDados(){
       //buscar lista de agendamento do banco de dados
       
       
       ScheduleDAO scheduleDAO = new ScheduleDAO();
       
       ArrayList<Schedule> schedules = ScheduleDAO.selectALL();
       
       
       // exibir essa lista view
       
       helper.preecherTabela(schedules);
       
   }
   
   public void atualizaCliente(){
       //buscar clientes no banco de dados
       ClientDAO clientDAO = new ClientDAO();
      ArrayList<Client> clients = clientDAO.selectALL(); 
       
       
    // exibir clientes no combobox
       helper.preecherCliente(clients);
       
   }
   
   
   public void atualizarServico(){
       ServiceDAO serviceDAO =  new ServiceDAO();
       ArrayList<Service> services = serviceDAO.selectALL();
       
       helper.preecherServico(services);
   }
   
   public void atualizarValor(){
       Service service = helper.obterServico();
       helper.setarValor(service.getValor());
   }
   
   
   public void agendar(){
       //buscar objeto agaendamento da tela
       Schedule schedule = helper.obterModelo();
       //buscar objeto no banco de dados
       new Schedule().insert(schedule);
       //inserir elementos na tabela
       atualizarDados();
       helper.limparTela();
   }
    
    
}
