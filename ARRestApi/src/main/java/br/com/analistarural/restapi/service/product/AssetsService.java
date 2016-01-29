package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Assets;
import br.com.analistarural.domain.repository.product.AssetsRepository;

@Service
@Transactional
public class AssetsService {

	@Autowired
	private AssetsRepository assetsRepository;
	
	public Iterable<Assets> findAll(){
		return assetsRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Assets assets){
		assetsRepository.save(assets);
	}
	
	public void delete(Long id){
		assetsRepository.delete(id);
	}
}
