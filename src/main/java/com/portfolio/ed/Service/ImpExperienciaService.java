
package com.portfolio.ed.Service;

import com.portfolio.ed.Entity.Experiencia;
import com.portfolio.ed.Interface.IExperienciaService;
import com.portfolio.ed.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService {
    @Autowired 
    IExperienciaRepository iexperienciaRepository;
   
     public List<Experiencia> list(){
         return iexperienciaRepository.findAll();
     }
     
     public Optional<Experiencia> getOne(long id){
         return iexperienciaRepository.findById(id);
     }
     
     public Optional<Experiencia> getByEmpresa(String empresa){
         return iexperienciaRepository.findByEmpresa(empresa);
     }
     
     public void save(Experiencia expe){
         iexperienciaRepository.save(expe);
     }
     
     public void delete(long id){
         iexperienciaRepository.deleteById(id);
     }
     
     public boolean existsById(long id){
         return iexperienciaRepository.existsById(id);
     }
     
     public boolean existsByEmpresa(String empresa){
         return iexperienciaRepository.existsByEmpresa(empresa);
     }
    
}
