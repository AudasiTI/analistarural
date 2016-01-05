package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.ProductFinished;
import br.com.analistarural.domain.repository.product.ProductFinishedRepository;


@Service
@Transactional
public class ProductFinishedService {


	@Autowired
	private ProductFinishedRepository productFinishedRepository;
	
	public Iterable<ProductFinished> findAll(){
		return productFinishedRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(ProductFinished source){
		productFinishedRepository.save(source);
	}
	
	public void delete(Long id){
		productFinishedRepository.delete(id);
	}
}
