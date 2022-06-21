package src;

import java.io.IOException;
import java.net.*;

import network.ClientUdpChannel;

public class ClientMain {

	public static void main(String[] args) {
		
		InetSocketAddress address = null;
        ClientUdpChannel channel = null;
        final int port = 3333;
        
        try {
			address = new InetSocketAddress(InetAddress.getByName("localhost"), port);
			channel = new ClientUdpChannel();
        } catch (UnknownHostException e) {
			System.out.print("Unkown host: " + e.getMessage());
		} catch (IOException e) {
            System.out.print("Unable to connect to the server\n" + e.getMessage());
            System.exit(-1);
        }
        
        channel.tryToConnect(address);
        channel.sendCommand("Piedra");
	}
}
