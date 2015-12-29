package br.com.analistarural.domain.entity.product;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "fertilizer")
public class Fertilizer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idFertilizer\"")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "\"fertilizer_idFertilizer_seq\"")
    @SequenceGenerator(name = "\"fertilizer_idFertilizer_seq\"", sequenceName = "\"fertilizer_idFertilizer_seq\"", allocationSize = 1, initialValue = 1)
	@Id
	private Long idFertilizer;
	
	
	public enum Type{ORGANIC, MINERAL}
	
	
	@Column(name="type_fertilizer")
	private Type typeFertilizer;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idChemicalElement\"", nullable = false)
	private ChemicalElement chemicalElement;	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idSource\"", nullable = false)
	private Source source;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idFeedstock\"", nullable = false)
	private Feedstock feedstock;

	public Long getIdFertilizer() {
		return idFertilizer;
	}

	public void setIdFertilizer(Long idFertilizer) {
		this.idFertilizer = idFertilizer;
	}

	

	public ChemicalElement getChemicalElement() {
		return chemicalElement;
	}

	public void setChemicalElement(ChemicalElement chemicalElement) {
		this.chemicalElement = chemicalElement;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Feedstock getFeedstock() {
		return feedstock;
	}

	public void setFeedstock(Feedstock feedstock) {
		this.feedstock = feedstock;
	}

	public Type getTypeFertilizer() {
		return typeFertilizer;
	}

	public void setTypeFertilizer(Type type) {
		this.typeFertilizer = type;
	}
}



