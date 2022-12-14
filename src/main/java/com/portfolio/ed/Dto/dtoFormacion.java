
package com.portfolio.ed.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class dtoFormacion {
    
    //@NotBlank
    //private Long idPersona;
    
    @NotBlank
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String titulo;
    
    @Size(min =1, max=10, message= "No cumple con la longitud")
    private String fecha;
    
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String institucion;
    
    @NotBlank
    @Size(min =1, max=100, message= "No cumple con la longitud")
    private String descripcion;
    
    //private Long idClaseForm;

    public dtoFormacion() {
    }

    public dtoFormacion(Long idPersona, String titulo, String fecha, String institucion, String descripcion, Long idClaseForm) {
        //this.idPersona = idPersona;
        this.titulo = titulo;
        this.fecha = fecha;
        this.institucion = institucion;
        this.descripcion = descripcion;
        //this.idClaseForm = idClaseForm;
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

    //public Long getIdClaseForm() {
    //    return idClaseForm;
    //}

    //public void setIdClaseForm(Long idClaseForm) {
    //    this.idClaseForm = idClaseForm;
    //}
    
    
}
