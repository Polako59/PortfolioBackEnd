
package com.portfolio.ed.Interface;

import com.portfolio.ed.Entity.Formacion;
import java.util.List;


public interface IFormacionService {
    
    //Traer una lista de Formacion
    public List<Formacion> getFormacion();
    
    //Guardar un objeto de tipo Formacion
    public void saveFormacion(Formacion formacion);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deleteFormacion(Long id);
    
    //Buscar una Formacion por ID
    public Formacion findFormacion(Long id);
}
