package com.senla.hotel.console.actions.roomactions;

import com.senla.hotel.console.actions.IAction;
import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomSortingType;
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
        System.out.println("0 - Do not sort\n1 - Number\n2 - Price\n3 - Status");
        int command = new Scanner(System.in).nextInt();

        switch (command) {
            case 0 -> {
                var rooms = administrator.getRooms(RoomSortingType.NON);
                for (var room : rooms) {
                    System.out.println(administrator.getRoomDetails(room.getId()).toString());
                }
            }
            case 1 -> {
                var rooms = administrator.getRooms(RoomSortingType.NUMBER);
                for (var room : rooms) {
                    System.out.println(administrator.getRoomDetails(room.getId()).toString());
                }
            }
            case 2 -> {
                var rooms = administrator.getRooms(RoomSortingType.PRICE);
                for (var room : rooms) {
                    System.out.println(administrator.getRoomDetails(room.getId()).toString());
                }
            }
            case 3 -> {
                var rooms = administrator.getRooms(RoomSortingType.STATUS);
                for (var room : rooms) {
                    System.out.println(administrator.getRoomDetails(room.getId()).toString());
                }
            }
            default -> throw new InputMismatchException("Invalid input");
        }
    }
}
