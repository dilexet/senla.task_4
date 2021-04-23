package com.senla.hotel.console.menu;

import com.senla.hotel.console.Builder;
import com.senla.hotel.console.Navigator;

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuController {

    private final Builder builder;
    private final Navigator navigator;

    public MenuController(Builder builder, Navigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() {
        builder.buildMenu();
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int choice = scanner.nextInt();
                navigator.navigate(choice);
            }
            catch (InputMismatchException | IOException ex){
                System.out.println(ex.getMessage());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
