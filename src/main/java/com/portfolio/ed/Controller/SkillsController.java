
package com.portfolio.ed.Controller;

import com.portfolio.ed.Dto.dtoSkills;
import com.portfolio.ed.Entity.Skills;
import com.portfolio.ed.Service.ImpSkillsService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/skills")
@CrossOrigin(origins="https://hosting-angular-argprog-4b59b.web.app/")
//@CrossOrigin

public class SkillsController {
    @Autowired 
    ImpSkillsService impskillsService;
    
    @GetMapping("/skills/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = impskillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/skills/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id")Long id){
        if(!impskillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = impskillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/skills/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!impskillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        impskillsService.deleteSkills(id);
        return new ResponseEntity(new Mensaje("Formacion Eliminada"), HttpStatus.OK);
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/skills/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
        if(StringUtils.isBlank(dtoskills.getName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(impskillsService.existsByName(dtoskills.getName()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        
          Skills skills = new Skills(dtoskills.getName(),dtoskills.getLevel()
                  ,dtoskills.getLogo());
          
        impskillsService.saveSkills(skills);
        
        return new ResponseEntity(new Mensaje("Skill creada"), HttpStatus.OK);
       
    
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/skills/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoSkills dtoskills){
        if(!impskillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(impskillsService.existsByName(dtoskills.getName()) && (impskillsService.getByName(dtoskills.getName()).get().getId()) != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getName())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = impskillsService.getOne(id).get();
        
        skills.setName(dtoskills.getName());
        skills.setLevel(dtoskills.getLevel());
        skills.setLogo(dtoskills.getLogo());
        
        impskillsService.saveSkills(skills);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
