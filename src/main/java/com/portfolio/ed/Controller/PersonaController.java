
package com.portfolio.ed.Controller;


import com.portfolio.ed.Entity.Persona;
import com.portfolio.ed.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La Persona fue creada correctamente";
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La Persona fue eliminada correctamente";
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    //URL:PUERTO/personas/editar/id/?nombres & apellido & fechaNacimiento & nacionalidad & mail & acercaDe & ocupacion & image_background_header & image_perfil_header
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam("nombres") String nuevoNombres,
                                @RequestParam("apellido") String nuevoApellido,
                                //@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd" ) Date nuevoFechaNacimiento,
                                @RequestParam("fechaNacimiento") String nuevoFechaNacimiento,
                                @RequestParam("nacionalidad") String nuevoNacionalidad,
                                @RequestParam("mail") String nuevoMail,
                                @RequestParam("acercaDe") String nuevoAcercaDe,
                                @RequestParam("ocupacion") String nuevoOcupacion,
                                @RequestParam("image_background_header") String nuevoImage_background_header,
                                @RequestParam("image_perfil_header") String nuevoImage_perfil_header){
    
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombres(nuevoNombres);
        persona.setApellido(nuevoApellido);
        persona.setFechaNacimiento(nuevoFechaNacimiento);
        persona.setNacionalidad(nuevoNacionalidad);
        persona.setMail(nuevoMail);
        persona.setAcercaDe(nuevoAcercaDe);
        persona.setOcupacion(nuevoOcupacion);
        persona.setImage_background_header(nuevoImage_background_header);
        persona.setImage_perfil_header(nuevoImage_perfil_header);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
}


