package br.com.analistarural.restapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.analistarural.domain.entity.product.Tools;
import br.com.analistarural.domain.repository.product.ToolsRepository;

@Service
@Transactional
public class ToolsService {

	@Autowired
	private ToolsRepository toolsRepository;
	
	public Iterable<Tools> findAll(){
		return toolsRepository.findAll();
	}
	
	@Transactional(readOnly = false)  
	public void save(Tools tools){
		toolsRepository.save(tools);
	}
	
	public void delete(Long id){
		toolsRepository.delete(id);
	}
}
