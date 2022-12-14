
package com.portfolio.ed.Controller;

import com.portfolio.ed.Entity.Proyectos;
import com.portfolio.ed.Interface.IProyectosService;
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
public class ProyectosController {
    
    @Autowired IProyectosService iproyectosService;
    
    @GetMapping("/proyectos/traer")
    public List<Proyectos> getProyectos() {
        return iproyectosService.getProyectos();
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyectos/crear")
    public String createProyectos(@RequestBody Proyectos proyectos){
        iproyectosService.saveProyectos(proyectos);
        return "La Proyectos fue creada correctamente";
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyectos/borrar/{id}")
    public String deleteProyectos(@PathVariable Long id){
        iproyectosService.deleteProyectos(id);
        return "La Proyectos fue eliminada correctamente";
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    //URL:PUERTO/proyectos/editar/id/?nombres & apellido & fechaNacimiento & nacionalidad & mail & acercaDe & ocupacion & image_background_header & image_perfil_header
    @PutMapping("/proyectos/editar/{id}")
    public Proyectos editProyectos (@PathVariable Long id,
                                //@RequestParam("idPersona") String nuevoIdPersona,
                                @RequestParam("nombreProyecto") String nuevoNombreProyecto,
                                @RequestParam("descripcion") String nuevoDescripcion,
                                @RequestParam("link") String nuevoLink){
    
        Proyectos proyectos = iproyectosService.findProyectos(id);
        
        //proyectos.setIdPersona(id);
        proyectos.setNombreProyecto(nuevoNombreProyecto);
        proyectos.setDescripcion(nuevoDescripcion);
        proyectos.setLink(nuevoLink);
        
        iproyectosService.saveProyectos(proyectos);
        return proyectos;
    }
    
}
