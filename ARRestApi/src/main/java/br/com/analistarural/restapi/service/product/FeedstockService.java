package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.product.Feedstock;
import br.com.analistarural.domain.entity.product.Source;
import br.com.analistarural.domain.repository.product.FeedstockRepository;
import br.com.analistarural.domain.repository.product.SourceRepository;

@Service
@Transactional
public class FeedstockService {

	@Autowired
	private FeedstockRepository feedstockRepository;
	
	public Iterable<Feedstock> findAll(){
		return feedstockRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Feedstock feedstock){
		feedstockRepository.save(feedstock);
	}
	
	public void delete(Long id){
		feedstockRepository.delete(id);
	}
}
