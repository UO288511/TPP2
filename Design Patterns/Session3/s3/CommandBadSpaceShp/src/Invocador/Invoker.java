package Invocador;

import Comando.Command;

public class Invoker {
	private Command command;

	public Invoker(Command command) {
		super();
		this.command = command;
	}
	
	public Invoker() {
		// TODO Auto-generated constructor stub
	}

	public void activate() {
		command.execute();
	}
	
	
}
