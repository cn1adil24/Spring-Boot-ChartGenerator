package de.anevis.assignment.service;

import java.util.List;

public interface DataService<T> {
	
	List<T> saveAll(List<T> records);

    List<T> getAll();
}
