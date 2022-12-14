
package com.portfolio.ed.Interface;

import com.portfolio.ed.Entity.Skills;
import java.util.List;


public interface ISkillsService {
    
    //Traer una lista de Skills
    public List<Skills> getSkills();
    
    //Guardar un objeto de tipo Skills
    public void saveSkills(Skills skills);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deleteSkills(Long id);
    
    //Buscar una Skills por ID
    public Skills findSkills(Long id);
}
