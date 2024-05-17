import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class PrimeCheckClient {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost",5050);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        //送る
            PrimeChecker a = new PrimeChecker();
            Scanner scan = new Scanner(System.in);
            System.out.println("任意の自然数を入力してください");
            a.setExecNumber(scan.nextInt());
            out.writeObject(a);
            out.flush();
        //結果を読み込み表示する
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            PrimeChecker result = (PrimeChecker)in.readObject();
            System.out.println("最大素数:");
            System.out.print(result.getResult());
            //通信終了処理
            System.out.println("通信を終了します");
            out.close();
            in.close();
            scan.close();
            socket.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
