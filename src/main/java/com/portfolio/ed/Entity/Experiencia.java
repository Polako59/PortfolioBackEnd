
package com.portfolio.ed.Entity;

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
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@NotNull
    //private Long idPersona;
    
    @NotNull
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String empresa;
    
    @Size(min =1, max=10, message= "No cumple con la longitud")
    private String desde;
    
    @Size(min =1, max=10, message= "No cumple con la longitud")
    private String hasta;
    
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String puesto;
    
    @Size(min =1, max=150, message= "No cumple con la longitud")
    private String tareas;
    
    @Size(min =1, max=50, message= "No cumple con la longitud")
    private String logo;
    
}
