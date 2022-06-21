package network;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.concurrent.*;

public class ServerRequestHandler {

    private class RequestReceiver extends Thread {

        @Override
        public void run() {
            while (true) {
                receiveData();
            }
        }
        
        public void receiveData() {
            SocketAddress addressFromClient = null;
            try {
                final ByteBuffer buf = ByteBuffer.allocate(AbsUdpSocket.DATA_SIZE);
                addressFromClient = socket.receiveDatagram(buf);
                buf.flip();
                final byte[] petitionBytes = new byte[buf.remaining()];
                buf.get(petitionBytes);

                if (petitionBytes.length > 0)
                    processRequest(petitionBytes, addressFromClient);

            } catch (SocketTimeoutException ignored) {
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Weird errors processing the received data" + e.getMessage());
            }
        }
        
        private void processRequest(byte[] petitionBytes, SocketAddress addressFromClient) throws IOException, ClassNotFoundException {
            try (ObjectInputStream stream = new ObjectInputStream(new ByteArrayInputStream(petitionBytes))) {
                final Object obj = stream.readObject();
                System.out.print("received object: " + obj);
            }
        }
    }
    
    private final ServerUdpSocket socket;
    private final RequestReceiver requestReceiver;
    private final ExecutorService executor;

    public ServerRequestHandler(ServerUdpSocket socket) {
        this.socket = socket;
        requestReceiver = new RequestReceiver();
        requestReceiver.setName("ServerReceiverThread");
        executor = Executors.newCachedThreadPool();
    }

    public void receiveFromWherever() {
        requestReceiver.start();
    }
    
    public void disconnect() {
        System.out.println("Disconnecting the server...");
        try {
            executor.shutdown();
            executor.awaitTermination(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during finishing the queued tasks");
        }
        socket.disconnect();
        requestReceiver.interrupt();
    }
}
