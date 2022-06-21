package src;

public class Main {

	public static void main(String[] args) {
		String mode = args[1].toLowerCase();
        if (mode.equals("client"))
            ClientMain.main(args);
        else if (mode.equals("server"))
            ServerMain.main(args);
        else
            System.err.println("Write 'client' or 'server'.");
		
	}
}
