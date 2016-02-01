package br.com.analistarural.restapi.service.field;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.dto.field.FieldsDTO;
import br.com.analistarural.domain.entity.field.Field;
import br.com.analistarural.domain.repository.FarmRepository;
import br.com.analistarural.domain.repository.FieldGroupRepository;
import br.com.analistarural.domain.repository.FieldRepository;
import br.com.analistarural.domain.repository.SystemAccountRepository;

@Service
@Transactional
public class FieldService {

	@Autowired
	private FieldRepository fieldRepository;

	@Autowired
	private FarmRepository farmRepository;

	@Autowired
	private FieldGroupRepository fieldGroupRepository;

	@Autowired
	private SystemAccountRepository systemAccountRepository;

	public Iterable<Field> findAll() {
		return fieldRepository.findAll();
	}

	public Iterable<FieldsDTO> findFieldsByFarm(Long farmID) {

		List<FieldsDTO> fieldDTOList = new ArrayList<FieldsDTO>();

		Iterable<Field> field = fieldRepository.findFieldsByFarm(farmID);

		for (Field field2 : field) {
			fieldDTOList.add(new FieldsDTO(field2));
		}
		return fieldDTOList;
	}

	@Transactional(readOnly = false)
	public void save(FieldsDTO fieldDTO) {

		Field field = fieldDTO.toField(fieldDTO);

		field.setFarm(farmRepository.findByName(fieldDTO.getFarmName(), fieldDTO.getSystemAccount()).get());
		field.getFarm().setSystemAccount(systemAccountRepository.findById(fieldDTO.getSystemAccount()).get());

		if ((fieldDTO.getGroupName() != null) && (fieldDTO.getGroupName() != "")) {
			field.setFieldGroup(
					fieldGroupRepository.findByName(fieldDTO.getGroupName(), field.getFarm().getId()).get());
		} else {
			field.setFieldGroup(null);
		}

		fieldRepository.save(field);

	}

	public void delete(Long id) {
		fieldRepository.delete(id);
	}

	public FieldsDTO findFieldByID(Long fieldID) {
		FieldsDTO fieldDTO = new FieldsDTO(fieldRepository.findById(fieldID).get());
		return fieldDTO;
	}

	public Iterable<FieldsDTO> findFieldsBySystemAccount(Long systemAccountID) {
		List<FieldsDTO> fieldDTOList = new ArrayList<FieldsDTO>();

		Iterable<Field> field = fieldRepository.findFieldsBySystemAccount(systemAccountID);

		for (Field field2 : field) {
			fieldDTOList.add(new FieldsDTO(field2));
		}
		return fieldDTOList;
	}
}
