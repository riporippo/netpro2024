package kadai;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPServer {
    public static void main(String[] args){
        DatagramSocket socket = null;
        try{
            socket = new DatagramSocket(8080);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while(true){
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                System.out.println("クライアントからの入力待機");

                socket.receive(receivePacket);
                String receiveMessage = new String(receivePacket.getData(),0,receivePacket.getLength());
                System.out.println(receiveMessage);
                //大文字変換
                sendData = receiveMessage.toUpperCase().getBytes();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,clientAddress,clientPort);
                socket.send(sendPacket);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(socket != null && !socket.isClosed()){
                socket.close();
            }
        }
    }
}
