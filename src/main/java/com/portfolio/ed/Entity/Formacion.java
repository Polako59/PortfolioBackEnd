
package com.portfolio.ed.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Formacion {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@NotNull
    //private Long idPersona;
    
    @NotNull
    @Size(max=250, message= "No cumple con la longitud")
    private String titulo;
    
    @Size(max=10, message= "No cumple con la longitud")
    private String fecha;
    
    @Size(max=150, message= "No cumple con la longitud")
    private String institucion;
    
    @Size(max=400, message= "No cumple con la longitud")
    private String descripcion;
    
    @Size(max=50, message= "No cumple con la longitud")
    private String claseForm;

    public Formacion() {
    }

    public Formacion(String titulo, String fecha, String institucion, String descripcion, String claseForm) {
        //this.idPersona = idPersona;
        this.titulo = titulo;
        this.fecha = fecha;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.claseForm = claseForm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public Long getIdPersona() {
    //    return idPersona;
    //}

    //public void setIdPersona(Long idPersona) {
    //    this.idPersona = idPersona;
    //}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClaseForm() {
        return claseForm;
    }

    public void setClaseForm(String claseForm) {
       this.claseForm = claseForm;
    }
    
}
