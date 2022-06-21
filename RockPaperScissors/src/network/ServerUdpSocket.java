package network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ServerUdpSocket {

    public static final int SOCKET_TIMEOUT = 3000;

    protected DatagramSocket socket;
    protected List<SocketAddress> clientList;

    public ServerUdpSocket(InetSocketAddress a) throws SocketException {
        socket = new DatagramSocket(a);
        socket.setSoTimeout(SOCKET_TIMEOUT);
        clientList = new ArrayList<>();
    }
    
    //@Override
    public void sendDatagram(byte[] content, SocketAddress client) throws IOException {
        DatagramPacket packet = new DatagramPacket(content, content.length, client);
        socket.send(packet);

        System.out.print("Sent datagram from SERVER to " + client);
    }
    
    //@Override
    public SocketAddress receiveDatagram(ByteBuffer buffer) throws IOException {
        byte[] buf = new byte[buffer.remaining()];

        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        System.out.print("Received datagram in SERVER from " + packet.getSocketAddress());
        buffer.put(buf, 0, packet.getLength());
        return packet.getSocketAddress();
    }
    
    public void sendResponse(Object response, SocketAddress client) {
        try(ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteArrayStream)) {

            objectStream.writeObject(response);
            System.out.print("send object " + response.toString());
            sendDatagram(byteArrayStream.toByteArray(), client);

        } catch (IOException e) {
        	System.out.print("Problem sending the response\n" + e.getMessage());
        }
    }

    public DatagramSocket getSocket() {
        return socket;
    }

    public void disconnect() {
        socket.disconnect();
    }
}
