package com.senla.hotel.console.actions.serviceactions;

import com.senla.hotel.console.actions.IAction;
import com.senla.hotel.entity.Service;
import com.senla.hotel.manager.Administrator;

import java.util.Scanner;

public class AddServiceAction implements IAction {
    private final Administrator administrator;

    public AddServiceAction(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the service name: ");
        String serviceName = scanner.nextLine();
        System.out.println("Enter the service price: ");
        double servicePrice = scanner.nextDouble();

        Service service = new Service(serviceName, servicePrice);

        System.out.println(administrator.addService(service));
    }
}
