/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author manoel.carvalho
 */
public class Provider {
    
    private Integer id;
    private String empresa;
    private String colaborador;
    private Integer cpf;
    private String morador;
    private Date data;
    private String hora;
    private String obs;

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getMorador() {
        return morador;
    }

    public void setMorador(String morador) {
        this.morador = morador;
    }

    public Date getData() {
        return data;
    }
    
    public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
     public String setDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
    public String getHoraFormatada(){
        return new SimpleDateFormat("HH:mm").format(data);
    }
    
     public String setHoraFormatada(){
        return new SimpleDateFormat("HH:mm").format(data);
    }
    

    public void setData(Date data) {
        this.data = data;
    }

   
  
    
    

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDataFormatada(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    @Override
    public String toString() {
        return getEmpresa();
    }
    
    
}
