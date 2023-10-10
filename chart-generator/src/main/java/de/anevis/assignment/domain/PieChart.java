package de.anevis.assignment.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "pie_chart")
public class PieChart {
	
	public PieChart() {
		
	}
	
	public PieChart(String country, Double weight) {
		super();
		this.country = country;
		this.weight = weight;
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
	private String country;
	
	@Column(nullable = false)
	private Double weight;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
