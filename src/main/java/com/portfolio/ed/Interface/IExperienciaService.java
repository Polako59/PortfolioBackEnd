
package com.portfolio.ed.Interface;

import com.portfolio.ed.Entity.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    //Traer una lista de Experiencia
    public List<Experiencia> getExperiencia();
    
    //Guardar un objeto de tipo Experiencia
    public void saveExperiencia(Experiencia experiencia);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deleteExperiencia(Long id);
    
    //Buscar una Experiencia por ID
    public Experiencia findExperiencia(Long id);
}
