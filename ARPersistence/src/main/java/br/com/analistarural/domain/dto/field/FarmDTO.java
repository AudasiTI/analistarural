package br.com.analistarural.domain.dto.field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.analistarural.domain.entity.account.SystemAccount;
import br.com.analistarural.domain.entity.field.Farm;
import br.com.analistarural.domain.entity.field.Field;

public class FarmDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private Long systemAccount;

	private Double size;
	
	private List<Field> fields = new ArrayList<Field>();

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSystemAccount() {
		return systemAccount;
	}

	public void setSystemAccount(Long systemAccount) {
		this.systemAccount = systemAccount;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public FarmDTO() {
		// TODO Auto-generated constructor stub
	}

	public FarmDTO(Farm farm) {
		setId(farm.getId());
		setName(farm.getName());
		setSize(farm.getSize());
		setSystemAccount(farm.getSystemAccount().getId());
	}

	public Farm toFarm(FarmDTO farmDTO) {

		Farm farm = new Farm();
		SystemAccount systemAccount = new SystemAccount();
		systemAccount.setId(farmDTO.getSystemAccount());

		farm.setId(farmDTO.getId());
		farm.setName(farmDTO.getName());
		farm.setSize(farmDTO.getSize());
		farm.setSystemAccount(systemAccount);

		return farm;

	}

}
