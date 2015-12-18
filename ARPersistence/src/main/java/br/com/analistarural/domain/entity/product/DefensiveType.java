package br.com.analistarural.domain.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "defensive_type")
public class DefensiveType implements Serializable {

		/**
		 * Adelino
		 */
		private static final long serialVersionUID = 1L;
		

		@Column(name = "\"idDefensiveType\"")
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"defensive_type_idDefensiveType_seq\"")
		@SequenceGenerator(name = "\"defensive_type_idDefensiveType_seq\"", sequenceName = "\"defensive_type_idDefensiveType_seq\"", allocationSize = 1)
		private @Id Long idDefensiveType;
		
		@Column(name = "name", length = 120, nullable = false, unique = true)
		private String name;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getIdDefensiveType() {
			return idDefensiveType;
		}
		public void setIdDefensiveType(Long id){
			this.idDefensiveType = id;
			
		}
}
