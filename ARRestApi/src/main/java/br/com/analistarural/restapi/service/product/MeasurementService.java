package br.com.analistarural.restapi.service.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.account.SystemAccount;
import br.com.analistarural.domain.entity.field.Farm;
import br.com.analistarural.domain.entity.product.Measurement;
import br.com.analistarural.domain.repository.product.MeasurementRepository;


@Service
@Transactional
public class MeasurementService {
	@Autowired
	private MeasurementRepository measurementRepository;
	
	public Iterable<Measurement> findAll(){
		return measurementRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Measurement measurement){
		measurementRepository.save(measurement);
	}
	
	public void delete(Long id){
		measurementRepository.delete(id);
	}
	
	public Optional<Measurement> findByIdMeasurement(Long idMeasurement) {
		return measurementRepository.findByIdMeasurement(idMeasurement);
	}

}
