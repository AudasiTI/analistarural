package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.FuelType;
import br.com.analistarural.domain.repository.product.FuelTypeRepository;


@Service
@Transactional
public class FuelTypeService {

	@Autowired
	private FuelTypeRepository fuelTypeRepository;
	
	public Iterable<FuelType> findAll(){
		return fuelTypeRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(FuelType fuelType){
		fuelTypeRepository.save(fuelType);
	}
	
	public void delete(Long id){
		fuelTypeRepository.delete(id);
	}
}
