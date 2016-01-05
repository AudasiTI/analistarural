package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Fuel;
import br.com.analistarural.domain.repository.product.FuelRepository;


@Service
@Transactional
public class FuelService {

	@Autowired
	private FuelRepository fuelRepository;
	
	public Iterable<Fuel> findAll(){
		return fuelRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Fuel fuel){
		fuelRepository.save(fuel);
	}
	
	public void delete(Long id){
		fuelRepository.delete(id);
	}
}
