import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PrimeCheckServerWhile {
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(5050);
            System.out.println("接続待機中");
            Socket clientSocket = serverSocket.accept();
            System.out.println("クライアントと接続しました。");
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            while(true){
                PrimeChecker auau = (PrimeChecker) in.readObject();
                if(auau.getExecNumber()<=1){
                    break;
                }
                auau.exec();
                out.writeObject(auau);
                out.flush();
            }
            //通信終了処理
            out.close();
            clientSocket.close();
            serverSocket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

