package src;

import java.net.*;

import network.ServerRequestHandler;
import network.ServerUdpSocket;

public class ServerMain {

	public static void main(String[] args) {
        
        try {
        	//port and server configuration
        	ServerUdpSocket socket = null;
            final int port = 3333;
            InetSocketAddress address = new InetSocketAddress(port);
            socket = new ServerUdpSocket(address);
            
            if (socket.getSocket().isBound()) {
            	System.out.print("Socket Successfully opened on " + address);
            } else {
            	System.out.print("Strange behaviour trying to bind the server");
                System.exit(-1);
            }
            
	        while (socket.getSocket().isBound()) {}
	        
	        final ServerRequestHandler requestManager = new ServerRequestHandler(socket);
	        
	        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	            requestManager.disconnect();
	        }));

	        requestManager.receiveFromWherever();
	        
        } catch (Exception e) {
        	System.out.print("Error: " + e.getMessage());
        }
	}
}
