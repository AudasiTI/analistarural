package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.analistarural.domain.entity.product.TypeVehicle;
import br.com.analistarural.domain.repository.product.TypeVehicleRepository;

@Service
@Transactional
public class TypeVehicleService {

	@Autowired
	private TypeVehicleRepository typeVehicleRepository;
	
	public Iterable<TypeVehicle> findAll(){
		return typeVehicleRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(TypeVehicle typeVehicle){
		typeVehicleRepository.save(typeVehicle);
	}
	
	public void delete(Long id){
		typeVehicleRepository.delete(id);
	}
}
