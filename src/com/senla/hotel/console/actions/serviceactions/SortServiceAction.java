package com.senla.hotel.console.actions.serviceactions;

import com.senla.hotel.console.actions.IAction;
import com.senla.hotel.entity.Service;
import com.senla.hotel.manager.Administrator;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SortServiceAction implements IAction {
    private final Administrator administrator;

    public SortServiceAction(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Enter the sorting type: ");
        System.out.println("1 - Name\n2 - Price");
        int command = new Scanner(System.in).nextInt();

        // TODO: поработать над выводом списков
        switch (command) {
            case 1 -> System.out.println(administrator.sortService(Comparator.comparing(Service::getServiceName)));
            case 2 -> System.out.println(administrator.sortService(Comparator.comparingDouble(Service::getPrice)));
            default -> throw new InputMismatchException("Invalid input");
        }
    }
}
