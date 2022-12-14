
package com.portfolio.ed.Controller;

import com.portfolio.ed.Entity.Experiencia;
import com.portfolio.ed.Interface.IExperienciaService;
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
public class ExperienciaController {
    @Autowired IExperienciaService iexperienciaService;
    
    @GetMapping("/experiencia/traer")
    public List<Experiencia> getExperiencia() {
        return iexperienciaService.getExperiencia();
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia){
        iexperienciaService.saveExperiencia(experiencia);
        return "La Experiencia fue creada correctamente";
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        iexperienciaService.deleteExperiencia(id);
        return "La Experiencia fue eliminada correctamente";
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    //URL:PUERTO/experiencia/editar/id/?nombres & apellido & fechaNacimiento & nacionalidad & mail & acercaDe & ocupacion & image_background_header & image_perfil_header
    @PutMapping("/experiencia/editar/{id}")
    public Experiencia editExperiencia (@PathVariable Long id,
                                //@RequestParam("idPersona") String nuevoIdPersona,
                                @RequestParam("empresa") String nuevoEmpresa,
                                //@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd" ) Date nuevoFechaNacimiento,
                                @RequestParam("desde") String nuevoDesde,
                                @RequestParam("hasta") String nuevoHasta,
                                @RequestParam("puesto") String nuevoPuesto,
                                @RequestParam("tareas") String nuevoTareas,
                                @RequestParam("logo") String nuevoLogo){
    
        Experiencia experiencia = iexperienciaService.findExperiencia(id);
        
        //experiencia.setIdPersona(id);
        experiencia.setEmpresa(nuevoEmpresa);
        experiencia.setDesde(nuevoDesde);
        experiencia.setHasta(nuevoHasta);
        experiencia.setPuesto(nuevoPuesto);
        experiencia.setTareas(nuevoTareas);
        experiencia.setLogo(nuevoLogo);
        
        iexperienciaService.saveExperiencia(experiencia);
        return experiencia;
    }
    
}
