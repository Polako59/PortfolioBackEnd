
package com.portfolio.ed.Controller;

import com.portfolio.ed.Entity.Skills;
import com.portfolio.ed.Interface.ISkillsService;
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
public class SkillsController {
    @Autowired ISkillsService iskillsService;
    
    @GetMapping("/skills/traer")
    public List<Skills> getSkills() {
        return iskillsService.getSkills();
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/skills/crear")
    public String createSkills(@RequestBody Skills skills){
        iskillsService.saveSkills(skills);
        return "La Skills fue creada correctamente";
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/skills/borrar/{id}")
    public String deleteSkills(@PathVariable Long id){
        
        iskillsService.deleteSkills(id);
        return "La Skills fue eliminada correctamente";
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    //URL:PUERTO/skills/editar/id/?nombres & apellido & fechaNacimiento & nacionalidad & mail & acercaDe & ocupacion & image_background_header & image_perfil_header
    @PutMapping("/skills/editar/{id}")
    public Skills editSkills (@PathVariable Long id,
                                @RequestParam("skillName") String nuevoSkillName,
                                @RequestParam("skillLevel") Long nuevoSkillLevel){
                                //@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd" ) Date nuevoFechaNacimiento,
                                //@RequestParam("idPersona") Long nuevoIdPersona){
                                //@RequestParam("idPersona") Long nuevoIdPersona){
        Skills skills = iskillsService.findSkills(id);
        
        skills.setSkillName(nuevoSkillName);
        skills.setSkillLevel(nuevoSkillLevel);
        //skills.setIdPersona(nuevoIdPersona);
        
        iskillsService.saveSkills(skills);
        return skills;
    }
}
