package br.com.analistarural.restapi.service.test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.repository.SystemAccountRepository;
import br.com.analistarural.restapi.service.FarmService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class FarmServiceTest {

	@Autowired
	SystemAccountRepository systemAccountRepository;
	
	@Autowired
	FarmService fs;
	
//	@Test
//	@Transactional
//	@Rollback(false)
//	public void testRegister() {
//		Boolean c = false;
//		Farm fa = new Farm();
//		Optional<SystemAccount> sa = systemAccountRepository.findById((long)1);
//		SystemAccount s = sa.get();
//		fa.setName("Rancho");
//		fa.setSystemAccount(s);
//		c = fs.register(fa);
//		assertTrue(c);
//	}

	@Test
	public void testFindFarmsBySystemAccount() {
		fail("Not yet implemented");
	}

}
