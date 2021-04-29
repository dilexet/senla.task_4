package com.senla.hotel.app;

import com.senla.hotel.builder.Initializer;
import com.senla.hotel.console.Builder;
import com.senla.hotel.console.Navigator;
import com.senla.hotel.console.menu.MenuController;
import com.senla.hotel.manager.Administrator;
import com.senla.hotel.tools.Logger;

public class Main {

    public static void main(String[] args) {
        try {
            Administrator administrator = new Initializer().initialize();
            MenuController menu = new MenuController(new Builder(administrator), new Navigator());
            menu.run();
        } catch (Exception e) {
            Logger.Error(e.getMessage());
        }
    }
}
