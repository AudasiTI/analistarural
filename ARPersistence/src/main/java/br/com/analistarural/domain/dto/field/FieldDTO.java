package br.com.analistarural.domain.dto.field;

import java.io.Serializable;

import br.com.analistarural.domain.entity.account.SystemAccount;
import br.com.analistarural.domain.entity.field.Farm;
import br.com.analistarural.domain.entity.field.Field;
import br.com.analistarural.domain.entity.field.FieldGroup;

public class FieldDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private Long systemAccount;

	private String farmName;

	private Double size;

	private String groupName;

	private Boolean owner;

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

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Boolean getOwner() {
		return owner;
	}

	public void setOwner(Boolean owner) {
		this.owner = owner;
	}

	public FieldDTO() {
	}

	public FieldDTO(Field field) {
		setFarmName(field.getFarm().getName());

		if (field.getFieldGroup() != null) {
			setGroupName(field.getFieldGroup().getName());
		}
		setId(field.getId());
		setName(field.getName());
		setOwner(field.getOwner());
		setSize(field.getSize());
		setSystemAccount(field.getFarm().getSystemAccount().getId());
	}

	public Field toField(FieldDTO fieldDTO) {

		Field field = new Field();
		FieldGroup fieldGroup = new FieldGroup();
		fieldGroup.setName(fieldDTO.getGroupName());

		Farm farm = new Farm();
		farm.setName(fieldDTO.getFarmName());

		farm.setSystemAccount(new SystemAccount());
		farm.getSystemAccount().setId(fieldDTO.getSystemAccount());

		field.setId(fieldDTO.getId());
		field.setName(fieldDTO.getName());
		field.setOwner(fieldDTO.getOwner());
		field.setSize(fieldDTO.getSize());
		field.setFieldGroup(fieldGroup);

		return field;

	}

}
