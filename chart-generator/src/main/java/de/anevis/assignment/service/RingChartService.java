package de.anevis.assignment.service;

import java.util.List;
import org.springframework.stereotype.Service;
import de.anevis.assignment.domain.RingChart;
import de.anevis.assignment.repository.RingChartRepository;

@Service
public class RingChartService implements DataService<RingChart> {
	
	private final RingChartRepository ringChartRepository;
	
	public RingChartService(RingChartRepository ringChartRepository) {
		this.ringChartRepository = ringChartRepository;
	}
	
	public List<RingChart> saveAll(List<RingChart> records) {
		return this.ringChartRepository.saveAll(records);
	}

    public List<RingChart> getAll() {
    	return this.ringChartRepository.findAll();
    }
}
