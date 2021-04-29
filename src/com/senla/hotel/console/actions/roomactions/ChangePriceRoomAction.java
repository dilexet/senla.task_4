package com.senla.hotel.console.actions.roomactions;

import com.senla.hotel.console.actions.IAction;
import com.senla.hotel.entity.Room;
import com.senla.hotel.manager.Administrator;

import java.util.Scanner;

public class ChangePriceRoomAction implements IAction {
    private final Administrator administrator;

    public ChangePriceRoomAction(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the room number: ");
        int roomNumber = scanner.nextInt();
        System.out.println("Enter the room new price: ");
        double roomPrice = scanner.nextDouble();

        Room room = new Room(roomNumber, roomPrice);

        administrator.changePriceRoom(room);
    }
}
