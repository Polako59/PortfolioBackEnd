
package com.portfolio.ed.Service;

import com.portfolio.ed.Entity.Formacion;
import com.portfolio.ed.Repository.IFormacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpFormacionService {
    
    @Autowired 
            IFormacionRepository iformacionRepository;
    
    public List<Formacion> list(){
        return iformacionRepository.findAll();
    }
    
    public Optional<Formacion> getOne(Long id){
        return iformacionRepository.findById(id);
    }
    
    public Optional<Formacion> getByTitulo(String titulo){
        return iformacionRepository.findByTitulo(titulo);
    }
    

    public void saveFormacion(Formacion formacion) {
        iformacionRepository.save(formacion);
    }

    public void deleteFormacion(Long id) {
        iformacionRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return iformacionRepository.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return iformacionRepository.existsByTitulo(titulo);
    }

    
}
