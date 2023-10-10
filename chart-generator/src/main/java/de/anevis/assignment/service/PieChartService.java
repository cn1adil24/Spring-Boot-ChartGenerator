package de.anevis.assignment.service;

import java.util.List;
import org.springframework.stereotype.Service;
import de.anevis.assignment.domain.PieChart;
import de.anevis.assignment.repository.PieChartRepository;

@Service
public class PieChartService implements DataService<PieChart> {
	
	private final PieChartRepository pieChartRepository;
	
	public PieChartService(PieChartRepository pieChartRepository) {
		this.pieChartRepository = pieChartRepository;
	}
	
	public List<PieChart> saveAll(List<PieChart> records) {
		return this.pieChartRepository.saveAll(records);
	}

    public List<PieChart> getAll() {
    	return this.pieChartRepository.findAll();
    }
}
