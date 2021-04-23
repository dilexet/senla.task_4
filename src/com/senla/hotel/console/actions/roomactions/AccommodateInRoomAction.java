package com.senla.hotel.console.actions.roomactions;

import com.senla.hotel.console.actions.IAction;
import com.senla.hotel.entity.Client;
import com.senla.hotel.manager.Administrator;

import java.util.Scanner;

public class AccommodateInRoomAction implements IAction {
    private final Administrator administrator;

    public AccommodateInRoomAction(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Enter client name: ");
        String clientName = new Scanner(System.in).nextLine();

        Client client = new Client(clientName);

        System.out.println(administrator.accommodateInRoom(client));
    }
}
