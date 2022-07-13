/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

 import Model.Service;
 import java.util.ArrayList;

/**
 *
 * @author manoel.carvalho
 */
public class ServiceDAO {
    
   
    public void insert(Service service) {
       Banco.service.add(service);
    }

    public ArrayList<Service> selectALL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Atualizar um objeto no banco de dados
     * @param service
     * @return
     */
    
    /*
    public boolean update(Service service) {
        for (int i = 0; i < Banco.service.size(); i++) {
            if(idSaoIguais(Banco.service.get(i).service)){
                Banco.service.set(i, service);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do serviço passado
     * @param service
     * @return
     */
    /*
    public boolean delete(Service service) {
        for (Service serviceList : Banco.service) {
            if(idSaoIguais(ServiceList.service)){
                Banco.service.remove(serviceList);
                return true;
            }
        }
        return false;
    }
    
    /**
     * retorna um arrayList com todos os serviços do banco de dados
     * @return uma lista com todos os registros do banco.
     */
    
    /*
    public ArrayList<Service> selectAll(){
        return Banco.Service;
    }
    
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param service
     * @param serviceAComparar
     * @return verdadeiro caso os id forem iguais e falso se não forem
     */
    
    
    /*
    private boolean idSaoIguais(Service service, Service serviceAComparar) {
        return service.getId() == serviceAComparar.getId();
    }
    */
    
}
