package br.com.analistarural.domain.entity.report;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "report")
public @Entity class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "report_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "report_report_id_seq")
	@SequenceGenerator(name = "report_report_id_seq", sequenceName = "report_report_id_seq", allocationSize = 1, initialValue = 1)
	private @Id Long id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "report")
	private Set<ElementValue> elementValues = new HashSet<ElementValue>(0);

	public Report() {
	}

	public Report(Report report) {
		super();
		this.id = report.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ElementValue> getElementValues() {
		return elementValues;
	}

	public void setElementValues(Set<ElementValue> elementValues) {
		this.elementValues = elementValues;
	}

}