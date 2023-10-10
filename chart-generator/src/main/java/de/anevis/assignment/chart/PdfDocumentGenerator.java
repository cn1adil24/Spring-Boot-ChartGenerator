package de.anevis.assignment.chart;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.PageSize;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.FileOutputStream;
import java.util.List;

import org.jfree.chart.JFreeChart;

public class PdfDocumentGenerator {

	private final List<ChartGenerator> chartGenerators;
    private final String outputPath;

    public PdfDocumentGenerator(List<ChartGenerator> chartGenerators, String outputPath) {
        this.chartGenerators = chartGenerators;
        this.outputPath = outputPath;
    }

    public void generatePdf() throws Exception {
    	Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPath));
        document.open();
        
        PdfContentByte contentByte = writer.getDirectContent();

        for (ChartGenerator chartGenerator : chartGenerators) {
        	
            JFreeChart chart = chartGenerator.generateChart();
            
        	addChartToPdf(contentByte, chart);
            
            document.newPage();
        }
        
        document.close();
    }

	private void addChartToPdf(PdfContentByte contentByte, JFreeChart chart) {
		int width = 400, height = 300;
		PdfTemplate template = contentByte.createTemplate(width, height);
		Graphics2D g2d = template.createGraphics(width, height);            

		chart.draw(g2d, new Rectangle(width, height));
		
		g2d.dispose();

		contentByte.addTemplate(template, 0, 0);
	}
}
