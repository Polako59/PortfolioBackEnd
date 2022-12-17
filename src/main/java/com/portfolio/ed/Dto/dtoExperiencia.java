
package com.portfolio.ed.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String empresa;
    @NotBlank
    private String desde;
    @NotBlank
    private String hasta;
    @NotBlank
    private String puesto;
    @NotBlank
    private String tareas;
    private String logo;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String empresa, String desde, String hasta, String puesto, String tareas, String logo) {
        this.empresa = empresa;
        this.desde = desde;
        this.hasta = hasta;
        this.puesto = puesto;
        this.tareas = tareas;
        this.logo = logo;
    }
    
    //Getters and Setters

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
        
    
}