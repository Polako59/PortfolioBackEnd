
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

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
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
    @Size(min =1, max=200, message= "No cumple con la longitud")
    private String acercaDe;
        
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String ocupacion;
    
    @NotNull
    private String image_background_header;
    
    @NotNull
    private String image_perfil_header;

    
}






