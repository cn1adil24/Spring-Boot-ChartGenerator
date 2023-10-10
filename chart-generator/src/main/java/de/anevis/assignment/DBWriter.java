package de.anevis.assignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import de.anevis.assignment.reader.FileReaderBase;
import de.anevis.assignment.service.DataService;

public class DBWriter<T> {
	
	private DataService<T> dataService;
	
	public DBWriter(DataService<T> dataService) {
		this.dataService = dataService;
	}
	
	public void write(FileReaderBase<T> fileReader) throws FileNotFoundException, IOException {
        List<T> dataEntities = fileReader.readAll();
        dataService.saveAll(dataEntities);
    }
}