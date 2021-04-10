package com.senla.filetools.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamWriter {
    private final String path;

    public FileStreamWriter(String path) {
        this.path = path;
    }

    public void fileWrite(String data, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            bw.write(data);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
