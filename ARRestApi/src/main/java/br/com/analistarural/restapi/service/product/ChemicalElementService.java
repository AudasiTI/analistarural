package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.ChemicalElement;
import br.com.analistarural.domain.repository.product.ChemicalElementRepository;


@Service
@Transactional
public class ChemicalElementService {

	@Autowired
	private ChemicalElementRepository chemicalElementRepository;
	
	public Iterable<ChemicalElement> findAll(){
		return chemicalElementRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(ChemicalElement chemicalElement){
		chemicalElementRepository.save(chemicalElement);
	}
	
	public void delete(Long id){
		chemicalElementRepository.delete(id);
	}
}
