
package com.portfolio.ed.Dto;

import javax.validation.constraints.NotBlank;


public class dtoPersona {

    @NotBlank
    private String nombres;
    @NotBlank
    private String apellido;
    @NotBlank
    private String fechaNacimiento;
    @NotBlank
    private String nacionalidad;
    @NotBlank
    private String mail;
    @NotBlank
    private String acercaDe;
    @NotBlank
    private String ocupacion;
    @NotBlank
    private String image_background_header;
    @NotBlank
    private String image_perfil_header;
    @NotBlank
    
    //Constructores

    public dtoPersona() {
    }

    public dtoPersona(String nombres, String apellido, String fechaNacimiento, String nacionalidad, String mail, String acercaDe, String ocupacion, String image_background_header, String image_perfil_header) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.mail = mail;
        this.acercaDe = acercaDe;
        this.ocupacion = ocupacion;
        this.image_background_header = image_background_header;
        this.image_perfil_header = image_perfil_header;
    }
    
    //Getters and Setters

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getImage_background_header() {
        return image_background_header;
    }

    public void setImage_background_header(String image_background_header) {
        this.image_background_header = image_background_header;
    }

    public String getImage_perfil_header() {
        return image_perfil_header;
    }

    public void setImage_perfil_header(String image_perfil_header) {
        this.image_perfil_header = image_perfil_header;
    }
    
    
}
