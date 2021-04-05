package com.senla.filetools.implementation;

import com.senla.dataaccessobject.RoomDTO;
import com.senla.dataaccessobject.ServiceDTO;
import com.senla.filetools.IFileStreamWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamWriter implements IFileStreamWriter {
    @Override
    public void fileWrite(String path, RoomDTO roomDTO) {
        var flag = checkFile(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            if (!flag) {
                bw.write("id,number,price,clientName");
            }
            bw.write(roomDTO.toString());
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void fileWrite(String path, ServiceDTO serviceDTO) {
        var flag = checkFile(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            if (!flag) {
                bw.write("id,serviceName,price");
            }
            bw.write(serviceDTO.toString());
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    private boolean checkFile(final String path) {
        final File file = new File(path);
        return file.exists(); // true - файл существует
    }
}
