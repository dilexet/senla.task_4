package com.senla.filetools.implementation;

import com.senla.filetools.IFileStreamReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStreamReader implements IFileStreamReader {
    private final String path;

    public FileStreamReader(String path) {
        this.path = path;
    }

    @Override
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