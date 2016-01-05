package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Seed;
import br.com.analistarural.domain.repository.product.SeedRepository;

public class SeedService {

	@Autowired
	private SeedRepository seedRepository;
	
	public Iterable<Seed> findAll(){
		return seedRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Seed seed){
		seedRepository.save(seed);
	}
	
	public void delete(Long id){
		seedRepository.delete(id);
	}
}
