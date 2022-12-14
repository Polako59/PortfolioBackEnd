
package com.portfolio.ed.Interface;

import com.portfolio.ed.Entity.RedesSociales;
import java.util.List;


public interface IRedesSocialesService {
    
    //Traer una lista de Skills
    public List<RedesSociales> getRedesSociales();
    
    //Guardar un objeto de tipo Skills
    public void saveRedesSociales(RedesSociales redesSociales);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deleteRedesSociales(Long id);
    
    //Buscar una Skills por ID
    public RedesSociales findRedesSociales(Long id);
    
    
}
