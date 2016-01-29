package br.com.analistarural.restapi.service.field;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.dto.field.FarmDTO;
import br.com.analistarural.domain.dto.field.FieldDTO;
import br.com.analistarural.domain.entity.field.Farm;
import br.com.analistarural.domain.entity.field.Field;
import br.com.analistarural.domain.repository.FarmRepository;

@Service
@Transactional
public class FarmService {

	@Autowired
	private FarmRepository farmRepository;

	public Iterable<FarmDTO> findFarmsBySystemAccount(Long systemAccountID) {

		List<FarmDTO> farmDTOList = new ArrayList<FarmDTO>();

		Iterable<Farm> farm = farmRepository.findFarmsBySystemAccount(systemAccountID);

		for (Farm farm2 : farm) {
			farmDTOList.add(new FarmDTO(farm2));
		}
		return farmDTOList;
	}

	@Transactional(readOnly = false)
	public void save(FarmDTO farmDTO) {

		Farm farm = farmRepository.save(farmDTO.toFarm(farmDTO));

	}

	public void delete(Long id) {
		farmRepository.delete(id);
	}

	public FarmDTO findFarmByID(Long farmID) {
		FarmDTO farmDTO = new FarmDTO(farmRepository.findById(farmID).get());
		return farmDTO;
	}

}