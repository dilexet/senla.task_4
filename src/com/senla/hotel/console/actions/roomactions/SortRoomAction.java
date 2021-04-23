package com.senla.hotel.console.actions.roomactions;

import com.senla.hotel.console.actions.IAction;
import com.senla.hotel.entity.Room;
import com.senla.hotel.manager.Administrator;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SortRoomAction implements IAction {
    private final Administrator administrator;

    public SortRoomAction(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Enter the sorting type: ");
        System.out.println("1 - Number\n2 - Price");
        int command = new Scanner(System.in).nextInt();

        switch (command) {
            case 1 -> System.out.println(administrator.sortRoom(Comparator.comparingInt(Room::getNumber)));
            case 2 -> System.out.println(administrator.sortRoom(Comparator.comparingDouble(Room::getPrice)));
            default -> throw new InputMismatchException("Invalid input");
        }
    }
}