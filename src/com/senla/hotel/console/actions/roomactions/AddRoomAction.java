package com.senla.hotel.console.actions.roomactions;

import com.senla.hotel.console.actions.IAction;
import com.senla.hotel.dto.RoomDTO;
import com.senla.hotel.manager.Administrator;

import java.util.Scanner;

public class AddRoomAction implements IAction {
    private final Administrator administrator;

    public AddRoomAction(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the room number: ");
        int roomNumber = scanner.nextInt();
        System.out.println("Enter the room price: ");
        double roomPrice = scanner.nextDouble();

        RoomDTO roomDTO = new RoomDTO(roomNumber, roomPrice);

        System.out.println(administrator.addRoom(roomDTO));
    }
}
