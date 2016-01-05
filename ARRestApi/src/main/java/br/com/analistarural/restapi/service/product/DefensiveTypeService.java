package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.DefensiveType;
import br.com.analistarural.domain.repository.product.DefensiveTypeRepository;

@Service
@Transactional
public class DefensiveTypeService {

	@Autowired
	private DefensiveTypeRepository defensiveTypeRepository;
	
	public Iterable<DefensiveType> findAll(){
		return defensiveTypeRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(DefensiveType defensiveType){
		defensiveTypeRepository.save(defensiveType);
	}
	
	public void delete(Long id){
		defensiveTypeRepository.delete(id);
	}
}
