package kadai;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;

public class MulticastServerSide {
    @SuppressWarnings("deprecation")
    public static void main(String[] args){
        try (MulticastSocket receiveSocket = new MulticastSocket(5050)) {
            InetAddress group = InetAddress.getByName("230.0.0.0");  // マルチキャストアドレスの例
            receiveSocket.joinGroup(group);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {  // 無限ループで継続的に受信
                receiveSocket.receive(packet);
                SocketAddress socketAddress = packet.getSocketAddress();
                int length = packet.getLength();
                String message = new String(buffer, 0, length);
                System.out.println(message + " received by " + socketAddress.toString());
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
