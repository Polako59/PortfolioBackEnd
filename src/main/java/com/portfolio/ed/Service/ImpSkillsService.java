
package com.portfolio.ed.Service;

import com.portfolio.ed.Entity.Skills;
import com.portfolio.ed.Repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpSkillsService {
    
    @Autowired 
    ISkillsRepository iskillsRepository;
    
    public List<Skills> list(){
        return iskillsRepository.findAll();
    }
    
    public Optional<Skills> getOne(Long id){
        return iskillsRepository.findById(id);
    }
    
    public Optional<Skills> getByName(String name){
        return iskillsRepository.findByName(name);
    }
    

    public void saveSkills(Skills skills) {
        iskillsRepository.save(skills);
    }

    public void deleteSkills(Long id) {
        iskillsRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return iskillsRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return iskillsRepository.existsByName(name);
    }
}
