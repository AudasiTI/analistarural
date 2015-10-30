package br.com.analistarural.domain.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "chemical_type")
public @Entity class ChemicalType implements Serializable {

		/**
		 * Adelino
		 */
		private static final long serialVersionUID = 1L;
		

		@Column(name = "\"idChemicalType\"")
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"chemical_type_idChemicalType_seq\"")
		@SequenceGenerator(name = "\"chemical_type_idChemicalType_seq\"", sequenceName = "\"chemical_type_idChemicalType_seq\"", allocationSize = 1)
		private @Id Long id;
		
		@Column(name = "name", length = 120, nullable = false, unique = true)
		private String name;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id){
			this.id = id;
			
		}
}
