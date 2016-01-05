package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Product;
import br.com.analistarural.domain.repository.product.ProductRepository;


@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> findAll(){
		return productRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Product product){
		productRepository.save(product);
	}
	
	public void delete(Long id){
		productRepository.delete(id);
	}
}
