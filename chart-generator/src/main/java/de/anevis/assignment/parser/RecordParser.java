package de.anevis.assignment.parser;

public interface RecordParser<T> {
	
    T parse(String[] data);
    
    String format(String input);
}
