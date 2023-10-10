package de.anevis.assignment.reader;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import de.anevis.assignment.parser.RecordParser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader<T> implements FileReaderBase<T> {
	
    private String xlsFilePath;
    private RecordParser<T> recordParser;

    public ExcelReader(String xlsFilePath, RecordParser<T> recordParser) {
        this.xlsFilePath = xlsFilePath;
        this.recordParser = recordParser;
    }

    public List<T> readAll() throws FileNotFoundException, IOException {
        List<T> dataEntities = new ArrayList<>();
        Boolean isHeader = true;
        
        try (Workbook workbook = new HSSFWorkbook(new FileInputStream(xlsFilePath))) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
            	if (isHeader) {
            		isHeader = false;
            		continue;
            	}
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            rowData.add(String.valueOf(cell.getNumericCellValue()));
                            break;
                        default:
                            rowData.add("");
                            break;
                    }
                }
                String[] data = rowData.toArray(new String[0]);
                T record = recordParser.parse(data);
                if (record != null) {
                    dataEntities.add(record);
                }
            }
        }
        
        return dataEntities;
    }
}