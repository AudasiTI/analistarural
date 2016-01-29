package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Parts;
import br.com.analistarural.domain.repository.product.PartsRepository;


@Service
@Transactional
public class PartsService {

	@Autowired
	private PartsRepository partsRepository;
	
	public Iterable<Parts> findAll(){
		return partsRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Parts parts){
		partsRepository.save(parts);
	}
	
	public void delete(Long id){
		partsRepository.delete(id);
	}
}
