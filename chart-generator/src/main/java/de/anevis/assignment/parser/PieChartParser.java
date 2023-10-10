package de.anevis.assignment.parser;

import de.anevis.assignment.domain.PieChart;

public class PieChartParser implements RecordParser<PieChart> {
	
    @Override
    public PieChart parse(String[] data) {
        if (data.length == 2) {
            String country = data[0];
            double weight = Double.parseDouble(data[1]);
            return new PieChart(country, weight);
        }
        return null;
    }
    
    @Override
    public String format(String input) {
    	return input;
    }
}
