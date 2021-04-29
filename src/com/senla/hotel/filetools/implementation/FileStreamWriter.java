package com.senla.hotel.filetools.implementation;

import com.senla.hotel.tools.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamWriter {

    public void fileWrite(String path, String data, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            bw.write(data);
        } catch (IOException ex) {
            Logger.Error(ex.getMessage());
        }
    }
}
