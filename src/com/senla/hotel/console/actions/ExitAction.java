package com.senla.hotel.console.actions;

import com.senla.hotel.tools.Logger;

public class ExitAction implements IAction {

	@Override
	public void execute() {
		Logger.Info("Process terminated");
		System.exit(0);
	}
}
