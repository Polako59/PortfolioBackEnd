
package com.portfolio.ed.Service;

import com.portfolio.ed.Entity.RedesSociales;
import com.portfolio.ed.Interface.IRedesSocialesService;
import com.portfolio.ed.Repository.IRedesSocialesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpRedesSocialesService implements IRedesSocialesService{
    
    @Autowired IRedesSocialesRepository iredesSocialesRepository;

    @Override
    public List<RedesSociales> getRedesSociales() {
        List<RedesSociales> redesSociales = iredesSocialesRepository.findAll();
        return redesSociales;
    }

    @Override
    public void saveRedesSociales(RedesSociales redesSociales) {
        iredesSocialesRepository.save(redesSociales);
    }

    @Override
    public void deleteRedesSociales(Long id) {
        iredesSocialesRepository.deleteById(id);
    }

    @Override
    public RedesSociales findRedesSociales(Long id) {
        RedesSociales redesSociales = iredesSocialesRepository.findById(id).orElse(null);
        return redesSociales;
    }
    
}
