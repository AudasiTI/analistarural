package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Source;
import br.com.analistarural.domain.repository.product.SourceRepository;

public class DefensiveTypeService {

	@Autowired
	private SourceRepository sourceRepository;
	
	public Iterable<Source> findAll(){
		return sourceRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Source source){
		sourceRepository.save(source);
	}
	
	public void delete(Long id){
		sourceRepository.delete(id);
	}
}
