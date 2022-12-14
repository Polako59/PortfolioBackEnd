
package com.portfolio.ed.Interface;

import com.portfolio.ed.Entity.Proyectos;
import java.util.List;


public interface IProyectosService {
    
    //Traer una lista de Proyectos
    public List<Proyectos> getProyectos();
    
    //Guardar un objeto de tipo Proyectos
    public void saveProyectos(Proyectos proyectos);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deleteProyectos(Long id);
    
    //Buscar una Proyectos por ID
    public Proyectos findProyectos(Long id);
}
