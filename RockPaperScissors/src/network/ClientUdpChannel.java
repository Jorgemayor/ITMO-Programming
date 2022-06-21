package network;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ClientUdpChannel extends AbsUdpSocket {
	
    protected DatagramChannel channel;
    protected SocketAddress addressServer;
    protected boolean connected;
    protected boolean requestSent;

    public ClientUdpChannel() throws IOException {
        channel = DatagramChannel.open();
        channel.configureBlocking(false);
        channel.bind(null);
        addressServer = null;
    }
    
    public void tryToConnect(InetSocketAddress addressServer) {
        this.addressServer = addressServer;
        sendCommand("connect");
        System.out.println("Trying to reach the server...");
    }
    
    public void sendDatagram(ByteBuffer content) throws IOException {
        channel.send(content, addressServer);
        this.requestSent = true;
        System.out.println("sent datagram to " + addressServer);
    }
    
    public SocketAddress receiveDatagram(ByteBuffer buffer) throws IOException {
        SocketAddress ret;
        ret = channel.receive(buffer);
        return ret;
    }
    
    public void sendCommand(Object action) {
        try(ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteArrayStream)) {

            objectStream.writeObject(action);
            System.out.println("send action " + action);
            final ByteBuffer objectBuffer = ByteBuffer.wrap(byteArrayStream.toByteArray());

            sendDatagram(objectBuffer);
            Thread.sleep(500);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void disconnect() {
        try {
            channel.close();
        } catch (IOException e) {
        	System.out.print("Error trying to disconnect, doing a forced out\n" + e.getMessage());
            System.exit(-1);
        }
    }
    
    public boolean isConnected() {
        return addressServer != null && connected;
    }
    
    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    
    public void setConnectionToFalse() {
        this.addressServer = null;
        this.connected = false;
    }
    
    public boolean requestWasSent() {
        return requestSent;
    }
    
    public Object receiveData() throws IOException, ClassNotFoundException {
        final ByteBuffer buf = ByteBuffer.allocate(AbsUdpSocket.DATA_SIZE);
        final SocketAddress addressFromServer = receiveDatagram(buf);
        buf.flip();

        byte[] bytes = new byte[buf.remaining()];
        buf.get(bytes);

        if (bytes.length < 1)
            return null;

        requestSent = false;
        if (bytes.length < AbsUdpSocket.DATA_SIZE)
            return processResponse(bytes);
        else
            throw new EOFException();
    }
    
    private Object processResponse(byte[] petitionBytes) throws IOException, ClassNotFoundException {
        try (ObjectInputStream stream = new ObjectInputStream(new ByteArrayInputStream(petitionBytes))) {
            final Object obj = stream.readObject();
            System.out.print("received object: " + obj);
            if (obj == null)
                throw new ClassNotFoundException();
            return obj;
        }
    }
}
