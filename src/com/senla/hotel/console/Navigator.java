package com.senla.hotel.console;

import com.senla.hotel.console.menu.Menu;
import com.senla.hotel.console.menu.items.MenuItem;

public class Navigator {

    private Menu currentMenu;

    public void printMenu() {
        System.out.println(System.lineSeparator() + getCurrentMenu().getName());
        int itemOrdinalNumber = 0;
        for (MenuItem item : getCurrentMenu().getMenuItems()) {
            itemOrdinalNumber++;
            System.out.println(itemOrdinalNumber + " " + item.getTitle());
        }
    }

    public void navigate(Integer index) throws Exception {
        // TODO: проверка ввода пользователем
        MenuItem menuItem = currentMenu.getMenuItems()[index - 1];
        if (menuItem.getAction() != null) {
            menuItem.doAction();
            System.out.println("Press enter to continue");
            System.in.read();
        }
        setCurrentMenu(menuItem.getNextMenu());
        printMenu();
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

}
