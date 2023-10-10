package de.anevis.assignment.parser;

import de.anevis.assignment.domain.RingChart;

public class RingChartParser implements RecordParser<RingChart> {
	
    @Override
    public RingChart parse(String[] data) {
        if (data.length == 3) {
            String date = format(data[0]);
            String security = format(data[1]);
            double weight = Double.parseDouble(format(data[2]));
            return new RingChart(date, security, weight);
        }
        return null;
    }
    
    @Override
    public String format(String input) {
    	String formattedString = input.replace("'", "''").trim();
        return formattedString;
    }
}