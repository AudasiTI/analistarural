package br.com.analistarural.restapi.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.account.SystemAccount;
import br.com.analistarural.domain.entity.field.Farm;
import br.com.analistarural.domain.repository.FarmRepository;

@Service
@Transactional
public class FarmService {

	@Autowired
	private FarmRepository farmRepository;

	public void register(Farm farm) {
		if (farm.getName().isEmpty()) {

		} else if (farm.getSystemAccount().getId() <= 0) {

		} else {
			farmRepository.save(farm);
		}

	}

	public Stream<Farm> findFarmsBySystemAccount(SystemAccount sa) {
		return farmRepository.streamAllFarmsBySystemAccount(sa.getId());
	}
}
