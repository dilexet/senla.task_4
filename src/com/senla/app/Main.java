package com.senla.app;

import com.senla.builder.ApplicationBuilder;
import com.senla.menu.Menu;

public class Main {

    public static void main(String[] args) {
	    new ApplicationBuilder().run(new Menu());
    }
}
