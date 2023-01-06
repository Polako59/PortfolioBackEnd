
package com.portfolio.ed.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@NotNull
    //private Long idPersona;
    
    @NotNull
    @Size(max=100, message= "No cumple con la longitud")
    private String empresa;
    
    @Size(max=10, message= "No cumple con la longitud")
    private String desde;
    
    @Size(max=10, message= "No cumple con la longitud")
    private String hasta;
    
    @Size(max=150, message= "No cumple con la longitud")
    private String puesto;
    
    @Size(max=750, message= "No cumple con la longitud")
    private String tareas;
    
    @Size(max=300, message= "No cumple con la longitud")
    private String logo;
    
    
    //Constructores

    public Experiencia() {
    }

    public Experiencia(String empresa, String desde, String hasta, String puesto, String tareas, String logo) {
        this.empresa = empresa;
        this.desde = desde;
        this.hasta = hasta;
        this.puesto = puesto;
        this.tareas = tareas;
        this.logo = logo;
    }
    
    //Getter and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
