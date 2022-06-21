package network;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;

public abstract class AbsUdpSocket {

    public static final int DATA_SIZE = 16000;
    public static final int SOCKET_TIMEOUT = 3000;

    /*protected DatagramSocket socket = null;
    protected SocketAddress addressTo = null;
    protected boolean connected = false;
    protected Thread receiverThread = null;*/

    public AbsUdpSocket() throws SocketException {

    }

    public abstract void sendDatagram(ByteBuffer content) throws IOException;
    public abstract SocketAddress receiveDatagram(ByteBuffer content) throws IOException;


}