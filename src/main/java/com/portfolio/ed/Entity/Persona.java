
package com.portfolio.ed.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String nombres;
    
    @NotNull
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String apellido;
    
    @NotNull
    @Size(min =1, max=10, message= "No cumple con la longitud")
    //private Date fechaNacimiento;
    private String fechaNacimiento;
    
    @NotNull
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String nacionalidad;
    
    @NotNull
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String mail;
    
    @NotNull
    @Size(min =1, max=300, message= "No cumple con la longitud")
    private String acercaDe;
        
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String ocupacion;
    
    @NotNull
    private String image_background_header;
    
    @NotNull
    private String image_perfil_header;

    //Constructores

    public Persona() {
    }

    public Persona(String nombres, String apellido, String fechaNacimiento, String nacionalidad, String mail, String acercaDe, String ocupacion, String image_background_header, String image_perfil_header) {
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

    //Getter and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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






