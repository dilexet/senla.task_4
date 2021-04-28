package com.senla.hotel.app;

import com.senla.hotel.builder.Initializer;
import com.senla.hotel.console.Builder;
import com.senla.hotel.console.Navigator;
import com.senla.hotel.console.menu.MenuController;
import com.senla.hotel.manager.Administrator;
import com.senla.hotel.tools.Log;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Administrator administrator = new Initializer().initialize();
            MenuController menu = new MenuController(new Builder(administrator), new Navigator());
            menu.run();
        } catch (IOException e) {
            Log.Error(e.getMessage());
        }
    }
}
