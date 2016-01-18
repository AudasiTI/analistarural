package br.com.analistarural.domain.entity.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "soil_sample_result")
public @Entity class SoilSampleResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "soil_sample_result_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "soil_sample_result_soil_sample_result_id_seq")
	@SequenceGenerator(name = "soil_sample_result_soil_sample_result_id_seq", sequenceName = "soil_sample_result_soil_sample_result_id_seq", allocationSize = 1)
	private @Id Long id;

	@Column(name = "ident")
	private String ident;

	@Column(name = "crop")
	private String crop;

	@Column(name = "field")
	private String Field;

	@Column(name = "tipo_analise")
	private String tipoAnalise;

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "report_id", referencedColumnName = "report_id", nullable = false)
	private Report report;

	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	// "soil_sample_result")
	// private List<ElementValue> elements = new ArrayList<ElementValue>(0);

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sample")
	private List<ElementValue> elementValues = new ArrayList<ElementValue>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public String getField() {
		return Field;
	}

	public void setField(String field) {
		Field = field;
	}

	public String getTipoAnalise() {
		return tipoAnalise;
	}

	public void setTipoAnalise(String tipoAnalise) {
		this.tipoAnalise = tipoAnalise;
	}

	public List<ElementValue> getElementValues() {
		return elementValues;
	}

	public void setElementValues(List<ElementValue> elementValues) {
		this.elementValues = elementValues;
	}

	public SoilSampleResult(Long reportID) {
		report = new Report();
		report.setId(reportID);
	}

	public SoilSampleResult() {
		// TODO Auto-generated constructor stub
	}

}
