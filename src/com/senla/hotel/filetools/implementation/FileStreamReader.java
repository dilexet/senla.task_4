package com.senla.hotel.filetools.implementation;

import com.senla.hotel.tools.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStreamReader {
    public String[] fileRead(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            StringBuilder fileData = new StringBuilder();
            while ((s = br.readLine()) != null) {
                fileData.append(s).append("\n");
            }
            return  fileData.toString().split("\n");
        } catch (IOException ex) {
            Logger.Error(ex.toString());
            return null;
        }
    }
}
