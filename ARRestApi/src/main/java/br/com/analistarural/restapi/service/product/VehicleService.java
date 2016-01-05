package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.analistarural.domain.entity.product.Vehicle;
import br.com.analistarural.domain.repository.product.VehicleRepository;

@Service
@Transactional
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Iterable<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Vehicle vehicle){
		vehicleRepository.save(vehicle);
	}
	
	public void delete(Long id){
		vehicleRepository.delete(id);
	}
}
