
package com.portfolio.ed.Controller;

import com.portfolio.ed.Dto.dtoExperiencia;
import com.portfolio.ed.Entity.Experiencia;
import com.portfolio.ed.Security.Controller.Mensaje;
import com.portfolio.ed.Service.ImpExperienciaService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="https://hosting-angular-argprog-4b59b.web.app/")
//@CrossOrigin

public class ExperienciaController {
    @Autowired
    ImpExperienciaService impExperienciaService;
    
    @GetMapping("/experiencia/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = impExperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/experiencia/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") long id){
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = impExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/experiencia/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (!impExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        impExperienciaService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/experiencia/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){      
        if(StringUtils.isBlank(dtoexp.getEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impExperienciaService.existsByEmpresa(dtoexp.getEmpresa()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexp.getEmpresa()
                , dtoexp.getDesde(),dtoexp.getHasta(), dtoexp.getPuesto()
                , dtoexp.getTareas(), dtoexp.getLogo());
        impExperienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/experiencia/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoExperiencia dtoexp){
        //Validamos si existe el ID
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(impExperienciaService.existsByEmpresa(dtoexp.getEmpresa()) && impExperienciaService.getByEmpresa(dtoexp.getEmpresa()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = impExperienciaService.getOne(id).get();
        experiencia.setEmpresa(dtoexp.getEmpresa());
        experiencia.setDesde((dtoexp.getDesde()));
        experiencia.setHasta((dtoexp.getHasta()));
        experiencia.setPuesto((dtoexp.getPuesto()));
        experiencia.setTareas((dtoexp.getTareas()));
        experiencia.setLogo((dtoexp.getLogo()));
        
        
        
        impExperienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}