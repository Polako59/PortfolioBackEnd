
package com.portfolio.ed.Interface;

import com.portfolio.ed.Entity.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    //Traer una lista de Experiencia
    public List<Experiencia> get();
    
    //Guardar un objeto de tipo Experiencia
    public void save(Experiencia experiencia);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void delete(Long id);
    
    //Buscar una Experiencia por ID
    public Experiencia find(Long id);
}
