package com.senla.hotel.tools;

import com.senla.hotel.filetools.implementation.FileStreamWriter;

import java.io.IOException;
import java.util.Date;

public class Logger {
    private static final FileStreamWriter fileStreamWriter = new FileStreamWriter();

    public static void Error(String message) {
        Date date = new Date();
        String str = date +
                " " +
                "[Error]" +
                " " +
                message +
                "\n";
        try {
            fileStreamWriter.fileWrite(Properties.getInstance().getProperty("logFilePath"), str, true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(str);
    }

    public static void Info(String message) {
        Date date = new Date();
        String str = date +
                " " +
                "[Info]" +
                " " +
                message +
                "\n";
        try {
            fileStreamWriter.fileWrite(Properties.getInstance().getProperty("logFilePath"), str, true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(str);
    }
}
