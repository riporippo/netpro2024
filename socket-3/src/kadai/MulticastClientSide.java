package kadai;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClientSide {
    public static void main(String[] args){
        try (MulticastSocket sendSocket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName("230.0.0.0");
            String message = "I LOVE YOU";
            byte[] buffer = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, group, 5050);
            sendSocket.send(sendPacket);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
