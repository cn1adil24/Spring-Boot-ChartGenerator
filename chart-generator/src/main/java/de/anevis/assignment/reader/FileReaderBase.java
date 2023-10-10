package de.anevis.assignment.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileReaderBase<T> {
    List<T> readAll() throws FileNotFoundException, IOException;
}
