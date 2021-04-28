package com.senla.hotel.tools;

import java.util.Date;

public class Log {
    public static Log logger;
    
    private final FileStreamWriter fileStreamWriter;

    public Log(FileStreamWriter fileStreamWriter){

        this.fileStreamWriter = fileStreamWriter;

    }

    public FileStreamWriter getFileStreamWriter() {

        return fileStreamWriter;

    }

    public static void Error(String message){
        Date date = new Date();
        String str = date +
                " " +
                "[Error]" +
                " " +
                message;
        Logger.getFileStreamWriter().fileWrite(str, true);
        System.out.println(str);
    }

    public static void Info(String message){
        Date date = new Date();
        String str = date +
                " " +
                "[Info]" +
                " " +
                message;
        Logger.getFileStreamWriter().fileWrite(str, true);
        System.out.println(str);
    }
}
