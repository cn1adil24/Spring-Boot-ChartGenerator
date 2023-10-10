package de.anevis.assignment.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.DefaultPieDataset;

import de.anevis.assignment.domain.PieChart;

import java.awt.*;
import java.util.List;

public class PieChartGenerator implements ChartGenerator {

    private final List<PieChart> dataEntities;

    public PieChartGenerator(List<PieChart> dataEntities) {
        this.dataEntities = dataEntities;
    }

    @Override
    public JFreeChart generateChart() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        for (PieChart entity : dataEntities) {
            dataset.setValue(entity.getCountry(), entity.getWeight());
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Pie Chart",
                dataset,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(Color.white);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{1}%"));
        plot.setNoDataMessage("No data available");
        plot.setInsets(new RectangleInsets(0.02, 0.02, 0.02, 0.02));

        return chart;
    }
}
