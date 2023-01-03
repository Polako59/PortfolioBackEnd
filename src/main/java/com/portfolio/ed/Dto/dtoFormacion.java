
package com.portfolio.ed.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class dtoFormacion {
    
   
    @NotBlank
    @Size(max=50, message= "No cumple con la longitud")
    private String titulo;
    
    @Size( max=10, message= "No cumple con la longitud")
    private String fecha;
    
    @Size(max=50, message= "No cumple con la longitud")
    private String institucion;
    
    @NotBlank
    @Size( max=100, message= "No cumple con la longitud")
    private String descripcion;
    
    @Size( max=50, message= "No cumple con la longitud")
    private String claseForm;

    public dtoFormacion() {
    }

    public dtoFormacion(String titulo, String fecha, String institucion, String descripcion, String claseForm) {
        //this.idPersona = idPersona;
        this.titulo = titulo;
        this.fecha = fecha;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.claseForm = claseForm;
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
