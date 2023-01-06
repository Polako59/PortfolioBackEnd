
package com.portfolio.ed.Controller;


import org.apache.commons.lang3.StringUtils;
import com.portfolio.ed.Dto.dtoFormacion;
import com.portfolio.ed.Entity.Formacion;
import com.portfolio.ed.Service.ImpFormacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/formacion")
@CrossOrigin(origins="https://hosting-angular-argprog-4b59b.web.app/")
//@CrossOrigin
public class FormacionController {
    @Autowired 
    ImpFormacionService impformacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Formacion>> list() {
        List<Formacion> list = impformacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Formacion> getById(@PathVariable("id")Long id){
        if(!impformacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Formacion formacion = impformacionService.getOne(id).get();
        return new ResponseEntity(formacion, HttpStatus.OK);
    }
    
    
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!impformacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        impformacionService.deleteFormacion(id);
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
    
    
    
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoFormacion dtoformacion){
        if(!impformacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(impformacionService.existsByTitulo(dtoformacion.getTitulo()) && (impformacionService.getByTitulo(dtoformacion.getTitulo()).get().getId()) != id){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoformacion.getTitulo())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Formacion formacion = impformacionService.getOne(id).get();
        
        //formacion.setIdPersona(dtoformacion.getIdPersona());
        formacion.setTitulo(dtoformacion.getTitulo());
        formacion.setFecha(dtoformacion.getFecha());
        formacion.setInstitucion(dtoformacion.getInstitucion());
        formacion.setDescripcion(dtoformacion.getDescripcion());
        formacion.setClaseForm(dtoformacion.getClaseForm());
        
        impformacionService.saveFormacion(formacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
