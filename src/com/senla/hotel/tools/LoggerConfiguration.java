package com.senla.hotel.tools;

import com.senla.hotel.filetools.implementation.FileStreamWriter;

public class LoggerConfiguration {
    private final FileStreamWriter fileStreamWriter;

    public LoggerConfiguration(FileStreamWriter fileStreamWriter){
        this.fileStreamWriter = fileStreamWriter;
    }

    public FileStreamWriter getFileStreamWriter() {
        return fileStreamWriter;
    }
}
