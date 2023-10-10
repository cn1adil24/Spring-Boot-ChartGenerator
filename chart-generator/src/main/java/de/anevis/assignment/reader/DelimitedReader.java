package de.anevis.assignment.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.anevis.assignment.parser.RecordParser;

public class DelimitedReader<T> implements FileReaderBase<T> {
	
	private String csvFilePath;
    private RecordParser<T> recordParser;
	
    public DelimitedReader(String csvFilePath, RecordParser<T> recordParser) {
        this.csvFilePath = csvFilePath;
        this.recordParser = recordParser;
    }
	
	public List<T> readAll() throws FileNotFoundException, IOException {
        List<T> dataEntities = new ArrayList<>();
        Boolean isHeader = true;
        
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
            	if (isHeader) {
            		isHeader = false;
            		continue;
            	}
                String[] data = line.split(",");
                T record = recordParser.parse(data);
                if (record != null) {
                    dataEntities.add(record);
                }
            }
        }
        return dataEntities;
    }
}
