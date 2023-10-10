package de.anevis.assignment.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ring_chart")
public class RingChart {
	
	public RingChart() {
		
	}

	public RingChart(String date, String security, Double weighting) {
		super();
		this.date = date;
		this.security = security;
		this.weighting = weighting;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	private String date;

	@Column(nullable = false)
	private String security;
	
	@Column(nullable = false)
	private Double weighting;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String country) {
		this.security = country;
	}

	public Double getWeighting() {
		return weighting;
	}

	public void setWeighting(Double weight) {
		this.weighting = weight;
	}
}
