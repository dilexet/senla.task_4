package com.senla.menu;

import com.senla.entity.Hotel;
import com.senla.manager.Administrator;
import com.senla.service.implementation.HotelService;

import java.util.Scanner;

public class Menu {
    public void showOptions() {
        System.out.println(
                """
                        0. Exit;\s
                        1. Поселить в номер;
                        2. Выселить из номера;
                        3. Изменить статус номера на ремонтируемые/обслуживаемый;
                        4. Изменить цену номера;
                        5. Изменить цену услуги;
                        6. Добавить номер;
                        7. Добавить услугу;
                        """);
        try {
            int option;
            var hotel = Hotel.getHotel();
            Administrator administrator = new Administrator(hotel, new HotelService());
            do {
                option = readOption();
                System.out.println(administrator.processCommand(option));
            } while (option != 0);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private int readOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
