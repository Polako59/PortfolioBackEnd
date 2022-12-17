
package com.portfolio.ed.Repository;

import com.portfolio.ed.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository<Skills,Long>{
    public Optional<Skills> findByName(String name);
    public boolean existsByName(String name);
}
