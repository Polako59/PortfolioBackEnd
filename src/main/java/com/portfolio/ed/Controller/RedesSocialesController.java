
package com.portfolio.ed.Controller;

import com.portfolio.ed.Entity.RedesSociales;
import com.portfolio.ed.Interface.IRedesSocialesService;
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
public class RedesSocialesController {
    
    @Autowired IRedesSocialesService iredesSocialesService;
    
    @GetMapping("/redesSociales/traer")
    public List<RedesSociales> getRedesSociales() {
        return iredesSocialesService.getRedesSociales();
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/redesSociales/crear")
    public String createRedesSociales(@RequestBody RedesSociales redesSociales){
        iredesSocialesService.saveRedesSociales(redesSociales);
        return "La RedesSociales fue creada correctamente";
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/redesSociales/borrar/{id}")
    public String deleteRedesSociales(@PathVariable Long id){
        iredesSocialesService.deleteRedesSociales(id);
        return "La RedesSociales fue eliminada correctamente";
    }
    
    ///@PreAuthorize("hasRole('ADMIN')")
    //URL:PUERTO/redesSociales/editar/id/?nombres & apellido & fechaNacimiento & nacionalidad & mail & acercaDe & ocupacion & image_background_header & image_perfil_header
    @PutMapping("/redesSociales/editar/{id}")
    public RedesSociales editRedesSociales (@PathVariable Long id,
                                //@RequestParam("idPersona") Long nuevoIdPersona,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("logo") String nuevoLogo,
                                @RequestParam("link") String nuevoLink){
    
        RedesSociales redesSociales = iredesSocialesService.findRedesSociales(id);
        
        //redesSociales.setIdPersona(nuevoIdPersona);
        redesSociales.setNombre(nuevoNombre);
        redesSociales.setLogo(nuevoLogo);
        redesSociales.setLink(nuevoLink);
        
        iredesSocialesService.saveRedesSociales(redesSociales);
        return redesSociales;
    }
}
