package kadai;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class UDPClient {
    public static void main(String[] args){
        DatagramSocket socket = null;
        try{
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            Scanner scanner = new Scanner(System.in);

            while(true){
                System.out.println("メッセージを送信しましょう(ローマ字で)");
                String sendMessage = scanner.nextLine();
                sendData = sendMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,serverAddress,8080);
                socket.send(sendPacket);

                DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
                socket.receive(receivePacket);
                String serverResponse = new String(receivePacket.getData(),0,receivePacket.getLength());
                System.out.println(serverResponse);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(socket!=null && !socket.isClosed()){
                socket.close();
            }
        }
    }
}
