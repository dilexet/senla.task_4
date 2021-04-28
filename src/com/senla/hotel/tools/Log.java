package com.senla.hotel.tools;

import java.util.Date;

public class Log {
    public static Log logger;

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
