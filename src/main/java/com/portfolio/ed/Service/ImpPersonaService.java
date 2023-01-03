
package com.portfolio.ed.Service;

import com.portfolio.ed.Entity.Persona;
import com.portfolio.ed.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {
    @Autowired IPersonaRepository ipersonaRepository;

    public List<Persona> list(){
        return ipersonaRepository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return ipersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByApellido(String apellido){
        return ipersonaRepository.findByApellido(apellido);
    }
    

    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    public void deletePersona(int id) {
        ipersonaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return ipersonaRepository.existsById(id);
    }
    
    public boolean existsByApellido(String titulo){
        return ipersonaRepository.existsByApellido(titulo);
    }
    
}
