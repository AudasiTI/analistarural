package br.com.analistarural.domain.entity.report;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

	@Column(name = "primary_email", length = 120, nullable = false, unique = false)
	private String email;

	@Column(name = "report_soil", length = 120, nullable = false, unique = false)
	private Boolean reportSoil;

	@Column(name = "secondary_email", length = 120, nullable = true, unique = false)
	private String secondaryEmail;

	@Column(name = "entry_date", nullable = false, unique = false)
	private Date entryDate;

	@Column(name = "generation_date", nullable = false, unique = false)
	private Date generationDate;

	@Column(name = "customer_cpf", length = 120, nullable = false, unique = false)
	private String customerCpf;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "report")
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getReportSoil() {
		return reportSoil;
	}

	public void setReportSoil(Boolean reportSoil) {
		this.reportSoil = reportSoil;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

	public String getCustomerCpf() {
		return customerCpf;
	}

	public void setCustomerCpf(String customerCpf) {
		this.customerCpf = customerCpf;
	}

	// public Set<ElementValue> getElementValues() {
	// return elementValues;
	// }
	//
	// public void setElementValues(Set<ElementValue> elementValues) {
	// this.elementValues = elementValues;
	// }

}