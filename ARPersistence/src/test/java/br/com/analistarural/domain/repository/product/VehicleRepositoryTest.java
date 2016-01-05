package br.com.analistarural.domain.repository.product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.product.Assets;
import br.com.analistarural.domain.entity.product.TypeVehicle;
import br.com.analistarural.domain.entity.product.Vehicle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class VehicleRepositoryTest {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private AssetsRepository assetsRepository;
	
	@Autowired
	private TypeVehicleRepository typeVehicleRepository;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(vehicleRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Vehicle vehicle1 = vehicleRepository.save(createVehicle());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(vehicleRepository.findByIdVehicle(vehicle1.getIdVehicle()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private Vehicle createVehicle() {
		Vehicle vehicle = new Vehicle();
		List<Assets> assets = (List<Assets>) assetsRepository.findAll();
		List<TypeVehicle> typeVehicles = (List<TypeVehicle>) typeVehicleRepository.findAll();
		vehicle.setModel("8089");
		vehicle.setBrand("Jonhn Deere");
		vehicle.setYear("2015");
		vehicle.setAcquisitionDate("01/01/2016");
		vehicle.setValueHour(22.0);
		vehicle.setSign("");
		vehicle.setTypeVehicle(typeVehicles.get(0));
		vehicle.setAssets(assets.get(0));
		return vehicle;
	}

}
