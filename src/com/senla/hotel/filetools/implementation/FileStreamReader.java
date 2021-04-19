package com.senla.hotel.filetools.implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStreamReader {
    private final String path;

    public FileStreamReader(String path) {
        this.path = path;
    }

    public String fileRead() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            StringBuilder fileData = new StringBuilder();
            while ((s = br.readLine()) != null) {
                fileData.append(s).append("\n");
            }
            return fileData.toString();
        } catch (IOException ex) {
            throw new IOException(ex.toString());
        }
    }
}
