package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Variety;
import br.com.analistarural.domain.repository.product.VarietyRepository;

@Service
@Transactional
public class VarietyService {

	@Autowired
	private VarietyRepository varietyRepository;
	
	public Iterable<Variety> findAll(){
		return varietyRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Variety variety){
		varietyRepository.save(variety);
	}
	
	public void delete(Long id){
		varietyRepository.delete(id);
	}
}
