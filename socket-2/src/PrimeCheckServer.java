import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PrimeCheckServer {
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(5050);
            System.out.println("接続待機中");
            Socket clientSocket = serverSocket.accept();
            System.out.println("クライアントと接続しました。");

            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            PrimeChecker auau = (PrimeChecker) in.readObject();
            auau.exec();

            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(auau);
            out.flush();
            //通信終了処理
            out.close();
            clientSocket.close();
            serverSocket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
