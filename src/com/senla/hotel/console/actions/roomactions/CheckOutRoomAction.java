package com.senla.hotel.console.actions.roomactions;

import com.senla.hotel.console.actions.IAction;
import com.senla.hotel.manager.Administrator;

import java.util.Scanner;

public class CheckOutRoomAction implements IAction {
    private final Administrator administrator;

    public CheckOutRoomAction(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Enter the room number: ");
        int roomNumber = new Scanner(System.in).nextInt();

        administrator.checkOutRoom(roomNumber);
    }
}
