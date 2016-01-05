package br.com.analistarural.domain.repository.product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.product.TypeVehicle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class TypeVehicleRepositoryTest {

	@Autowired
	private TypeVehicleRepository typeVehicleRepositoryTest;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(typeVehicleRepositoryTest, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		TypeVehicle typeVehicle1 = typeVehicleRepositoryTest.save(createTypeVehicle());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(typeVehicleRepositoryTest.findByIdTypeVehicle(typeVehicle1.getIdTypeVehicle()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private TypeVehicle createTypeVehicle() {
		TypeVehicle typeVehicle = new TypeVehicle();
		typeVehicle.setName("Trator");
		return typeVehicle;
	}

}
