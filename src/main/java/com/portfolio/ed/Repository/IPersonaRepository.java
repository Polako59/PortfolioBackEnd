
package com.portfolio.ed.Repository;

import com.portfolio.ed.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Integer> {
    public Optional<Persona> findByApellido(String apellido);
    public boolean existsByApellido(String apellido);
    
}
