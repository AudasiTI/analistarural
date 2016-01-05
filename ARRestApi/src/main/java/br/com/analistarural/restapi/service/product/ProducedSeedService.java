package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.ProducedSeed;
import br.com.analistarural.domain.repository.product.ProducedSeedRepository;

@Service
@Transactional
public class ProducedSeedService {

	@Autowired
	private ProducedSeedRepository producedSeedRepository;
	
	public Iterable<ProducedSeed> findAll(){
		return producedSeedRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(ProducedSeed producedSeed){
		producedSeedRepository.save(producedSeed);
	}
	
	public void delete(Long id){
		producedSeedRepository.delete(id);
	}
}
