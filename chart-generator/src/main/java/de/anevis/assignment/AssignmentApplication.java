package de.anevis.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.anevis.assignment.domain.PieChart;
import de.anevis.assignment.domain.RingChart;
import de.anevis.assignment.parser.PieChartParser;
import de.anevis.assignment.parser.RingChartParser;
import de.anevis.assignment.reader.DelimitedReader;
import de.anevis.assignment.reader.ExcelReader;
import de.anevis.assignment.reader.FileReaderBase;
import de.anevis.assignment.service.PieChartService;
import de.anevis.assignment.service.RingChartService;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner  {

	private static final Logger logger = LoggerFactory.getLogger(AssignmentApplication.class);

	@Autowired
	private PieChartService pieChartService;
	
	@Autowired
	private RingChartService ringChartService;
	
	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) {
		
		try {
			
			DBWriter<PieChart> pieChartWriter = new DBWriter<PieChart>(pieChartService);
			FileReaderBase<PieChart> pieChartFileReader = new ExcelReader<>("piechart-data.xls", new PieChartParser());
			pieChartWriter.write(pieChartFileReader);
			
			DBWriter<RingChart> ringChartWriter = new DBWriter<RingChart>(ringChartService);
			FileReaderBase<RingChart> ringChartFileReader = new DelimitedReader<>("Ring Chart Data.csv", new RingChartParser());
			ringChartWriter.write(ringChartFileReader);
			
		} catch (Exception e) {
			logger.error("An error occurred: " + e.getMessage());
		}
	}

}
