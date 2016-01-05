package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Defensive;
import br.com.analistarural.domain.repository.product.DefensiveRepository;


@Service
@Transactional
public class DefensiveService {


	@Autowired
	private DefensiveRepository defensiveRepository;
	
	public Iterable<Defensive> findAll(){
		return defensiveRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Defensive defensive){
		defensiveRepository.save(defensive);
	}
	
	public void delete(Long id){
		defensiveRepository.delete(id);
	}
}
