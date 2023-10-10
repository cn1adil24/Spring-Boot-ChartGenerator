package de.anevis.assignment.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.anevis.assignment.PdfGenerator;
import de.anevis.assignment.domain.PieChart;
import de.anevis.assignment.domain.RingChart;
import de.anevis.assignment.service.PieChartService;
import de.anevis.assignment.service.RingChartService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/report")
public class ReportController {
	
	private final PieChartService pieChartService;
	private final RingChartService ringChartService;

    public ReportController(PieChartService pieChartService, RingChartService ringChartService) {
        this.pieChartService = pieChartService;
        this.ringChartService = ringChartService;
    }
    
    @GetMapping("/generate")
    public void generatePdf(HttpServletResponse response) throws IOException {
    	List<PieChart> pieDataEntities = pieChartService.getAll();
    	List<RingChart> ringDataEntities = ringChartService.getAll();
    	String outputPath = "report.pdf";
    	
    	try {
    		PdfGenerator.generatePdf(pieDataEntities, ringDataEntities, outputPath);
            returnResponse(response, outputPath);
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
            java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(outputPath));
        }
    }

	private void returnResponse(HttpServletResponse response, String outputPath) throws IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + outputPath);
		
		java.nio.file.Path path = java.nio.file.Paths.get(outputPath);
		byte[] data = java.nio.file.Files.readAllBytes(path);
		response.getOutputStream().write(data);
		response.getOutputStream().flush();
	}
    
    @GetMapping("/pie")
    public List<PieChart> getPieChartData() {
    	return pieChartService.getAll();
    }
    
    @GetMapping("/ring")
    public List<RingChart> getRingChartData() {
    	return ringChartService.getAll();
    }
}
