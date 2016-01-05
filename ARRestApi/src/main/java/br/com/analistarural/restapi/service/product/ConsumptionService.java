package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Consumption;
import br.com.analistarural.domain.repository.product.ConsumptionRepository;

@Service
@Transactional
public class ConsumptionService {

	@Autowired
	private ConsumptionRepository consumptionRepository;
	
	public Iterable<Consumption> findAll(){
		return consumptionRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Consumption consumption){
		consumptionRepository.save(consumption);
	}
	
	public void delete(Long id){
		consumptionRepository.delete(id);
	}
}
