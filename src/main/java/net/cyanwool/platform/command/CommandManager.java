package net.cyanwool.platform.command;

import java.util.Arrays;
import java.util.HashMap;

import net.cyanwool.platform.Server;
import net.cyanwool.platform.command.cyanwool.InfoCommand;
import net.cyanwool.platform.command.cyanwool.ShutdownCommand;

public class CommandManager {

	private HashMap<String, Command> commands = new HashMap<String, Command>();
	private Server server;

	public CommandManager(Server server) {
		this.server = server;
		register(new ShutdownCommand());
		register(new InfoCommand());
	}

	public void register(Command command) {
		commands.put(command.getName(), command);
	}

	public void unregister(String name) {
		commands.remove(name);
	}

	public void dispatchCommand(ICommandSender sender, String rawMessage) {
		String[] args = rawMessage.split(" ");
		String label = args[0];
		Command command = commands.get(label);
		if (command == null) {
			// String text = "Unknown command. Type /help for help.";
			String text = getServer().getLanguageManager().getLanguageFile(sender.getLangCode()).getValue("cw.unknownCommand");
			sender.sendMessage(text);
			return;
		}
		if (sender instanceof ConsoleCommandSender && !command.isConsoleAccess()) {
			// String text = "This command is not accesible from console.";
			String text = getServer().getLanguageManager().getLanguageFile(sender.getLangCode()).getValue("cw.notAccesibleFromConsole");
			sender.sendMessage(text);
			return;
		}
		String[] rangedArgs = Arrays.copyOfRange(args, 1, args.length);
		command.execute(sender, rangedArgs);
	}

	public Command getCommand(String cmd) {
		return commands.get(cmd);
	}

	public Server getServer() {
		return server;
	}
}
