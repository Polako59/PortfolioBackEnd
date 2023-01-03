
package com.portfolio.ed.Controller;


import com.portfolio.ed.Dto.dtoPersona;
import com.portfolio.ed.Entity.Persona;
import com.portfolio.ed.Interface.IPersonaService;
import com.portfolio.ed.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin
//@CrossOrigin(origins="http://localhost:4200")
public class PersonaController {
    @Autowired 
    ImpPersonaService imppersonaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = imppersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!imppersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = imppersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    
    /*@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!imppersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        imppersonaService.deletePersona(id);
        return new ResponseEntity(new Mensaje("Formacion Eliminada"), HttpStatus.OK);
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoFormacion dtoformacion){
        if(StringUtils.isBlank(dtoformacion.getTitulo())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(impformacionService.existsByTitulo(dtoformacion.getTitulo())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
          Formacion formacion = new Formacion(
                dtoformacion.getTitulo(), 
                dtoformacion.getFecha(),
                dtoformacion.getInstitucion(),
                dtoformacion.getDescripcion(),
                dtoformacion.getClaseForm());

        
        impformacionService.saveFormacion(formacion);
        return new ResponseEntity(new Mensaje("Formacion creada"), HttpStatus.OK);
    
    
    
    }*/
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!imppersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(imppersonaService.existsByApellido(dtopersona.getApellido()) && (imppersonaService.getByApellido(dtopersona.getApellido()).get().getId()) != id){
            return new ResponseEntity(new Mensaje("Ese Apellido ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getApellido())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = imppersonaService.getOne(id).get();
        

        persona.setNombres(dtopersona.getNombres());
        persona.setApellido(dtopersona.getApellido());
        persona.setFechaNacimiento(dtopersona.getFechaNacimiento());
        persona.setNacionalidad(dtopersona.getNacionalidad());
        persona.setMail(dtopersona.getMail());
        persona.setAcercaDe(dtopersona.getAcercaDe());
        persona.setOcupacion(dtopersona.getOcupacion());
        persona.setImage_background_header(dtopersona.getImage_background_header());
        persona.setImage_perfil_header(dtopersona.getImage_perfil_header());
                
        imppersonaService.savePersona(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}


