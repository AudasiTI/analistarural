package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Fertilizer;
import br.com.analistarural.domain.repository.product.FertilizerRepository;

@Service
@Transactional
public class FertilizerService {

	@Autowired
	private FertilizerRepository fertilizerRepository;
	
	public Iterable<Fertilizer> findAll(){
		return fertilizerRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Fertilizer fertilizer){
		fertilizerRepository.save(fertilizer);
	}
	
	public void delete(Long id){
		fertilizerRepository.delete(id);
	}
	
	
}
