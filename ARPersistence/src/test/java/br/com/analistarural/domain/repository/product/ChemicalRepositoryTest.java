package br.com.analistarural.domain.repository.product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;
import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.product.Chemical;
import br.com.analistarural.domain.entity.product.ChemicalType;
import br.com.analistarural.domain.entity.product.ProductCategory;
import br.com.analistarural.domain.entity.product.ProductType;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ChemicalRepositoryTest {

	@Autowired
	private ChemicalRepository chemicalRepository;
	
	@Autowired
	ChemicalTypeRepository chemicalTypeRepository;
	
	@Autowired 
	ProductCategoryRepository productCategoryRepository;
	
	@Autowired 
	ProductTypeRepository productTypeRepository;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(chemicalRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Chemical chemical1 = chemicalRepository.save(createChemical());
		Chemical chemical2 = chemicalRepository.save(createChemical());

		assertThat(chemicalRepository.findById(chemical1.getId()).isPresent(), is(true));
		assertThat(chemicalRepository.findById(chemical2.getId()).isPresent(), is(true));
	}
	
	
	private Chemical createChemical(){

		Chemical chemical = new Chemical();
		java.util.List<ChemicalType> ct = (java.util.List<ChemicalType>) chemicalTypeRepository.findAll();
		Optional<ProductType> pt = productTypeRepository.findById((long) 25);
		Optional<ProductCategory> pc = productCategoryRepository.findById((long) 37);
		
		
		chemical.setName("AgroFertilizante");
		chemical.setUnity("Litro");
		chemical.setCost(30.0);
		chemical.setAverage(30.3);
		chemical.setInventory((long) 10);
		chemical.setRestrictUse(true);
		chemical.setChemicalType(ct.get(0));
		chemical.setProductType(pt.get());
		chemical.setProductCategory(pc.get());
		
		return chemical;
	}

}
