package de.anevis.assignment;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.DefaultPieDataset;

import de.anevis.assignment.chart.ChartGenerator;
import de.anevis.assignment.chart.PdfDocumentGenerator;
import de.anevis.assignment.chart.PieChartGenerator;
import de.anevis.assignment.chart.RingChartGenerator;
import de.anevis.assignment.domain.PieChart;
import de.anevis.assignment.domain.RingChart;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PdfGenerator {
	
	public static void generatePdf(List<PieChart> pieEntities, List<RingChart> ringEntities, String outputPath) throws Exception {

        List<ChartGenerator> chartGenerators = List.of(
            new PieChartGenerator(pieEntities),
            new RingChartGenerator(ringEntities)
        );

        PdfDocumentGenerator pdfDocumentGenerator = new PdfDocumentGenerator(chartGenerators, outputPath);
        pdfDocumentGenerator.generatePdf();
    }
}
