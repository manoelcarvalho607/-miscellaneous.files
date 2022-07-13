
package Controller.Helper;

import Model.Client;
import Model.Schedule;
import Model.Service;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manoel.carvalho
 */
public class ScheduleHelper implements IHelper{
    
    private final Agenda view;

    public ScheduleHelper(Agenda view) {
        this.view = view;
    }
    
     public void preecherTabela(ArrayList<Schedule> schedules) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTxtTable().getModel();
       tableModel.setNumRows(0);
       
       
       for(Schedule schedule: schedules){
           
            tableModel.addRow(new Object[]{
            /*
                schedule.getID(),
                schedule.getCliente().getNome(),
                schedule.getServico().getDescricao(),
                schedule.getValor(),
                schedule.getDataFormatada(),
                schedule.getHoraFormatada(),
                schedule.getObservacao()
              */  
            });
           
       }
        
    }
    

   

    public void preecherCliente(ArrayList<Client> clients) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxClient().getModel();
        
        for (Client client : clients) {
            comboBoxModel.addElement(client);
        }

        
    }

    public void preecherServico(ArrayList<Service> services) {
      
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxService().getModel();
       
        for (Service service : services) {
            comboBoxModel.addElement(service);
        }
        
        
    }
    
    public Client obterClient() {
      return (Client)view.getjComboBoxClient().getSelectedItem();
    }
    

    public Service obterServico() {
      return (Service)view.getjComboBoxService().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getTxtValor().setText(valor +"");
    }

    @Override
    public Schedule obterModelo() {
      String  idString = view.getTxtID().getText();
      int id = Integer.parseInt(idString);
      
      Client client = obterClient();
      Service service = obterServico();
      String valorString = view.getTxtValor().getText();
      float valor = Float.parseFloat(valorString);
      String date = view.getTxtDate().getText();
      String hora = view.getTxtHora().getText();
      String dataHora = date + "" + hora;
      String obs = view.getTxtObs().getText();
      
      Schedule schedule = new Schedule(id, client, service, valor, dataHora, obs);
      
      return schedule;
    }

    @Override
    public void limparTela() {
        view.getTxtID().setText("0");
        view.getTxtDate().setText("");
        view.getTxtHora().setText("");
        view.getTxtObs().setText("");
        
    }

   

   
    
}
