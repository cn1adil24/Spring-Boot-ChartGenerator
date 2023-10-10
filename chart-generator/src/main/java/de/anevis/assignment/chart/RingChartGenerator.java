package de.anevis.assignment.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.DefaultPieDataset;

import de.anevis.assignment.domain.RingChart;

import java.awt.*;
import java.util.List;

public class RingChartGenerator implements ChartGenerator {

	private final List<RingChart> dataEntities;

    public RingChartGenerator(List<RingChart> dataEntities) {
        this.dataEntities = dataEntities;
    }

    @Override
    public JFreeChart generateChart() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        for (RingChart entity : dataEntities) {
            dataset.setValue(entity.getSecurity(), entity.getWeighting() * 100);
        }

        JFreeChart chart = ChartFactory.createRingChart(
                "Ring Chart",
                dataset,
                true,
                false,
                false
        );

        chart.setBackgroundPaint(Color.white);
        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{1}%"));
        plot.setNoDataMessage("No data available");
        plot.setSectionDepth(0.33);
        plot.setInsets(new RectangleInsets(0.02, 0.02, 0.02, 0.02));

        return chart;
    }

}
