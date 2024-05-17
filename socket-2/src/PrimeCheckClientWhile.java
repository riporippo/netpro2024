import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class PrimeCheckClientWhile {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost",5050);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Scanner scan = new Scanner(System.in);
            while(true){
                //送る
                PrimeChecker a = new PrimeChecker();
                System.out.println("任意の自然数を入力してください");
                int num = scan.nextInt();
                if(num<=1){
                    break;
                }
                a.setExecNumber(num);
                out.writeObject(a);
                out.flush();
                //結果を読み込み表示する
                PrimeChecker result = (PrimeChecker)in.readObject();
                System.out.println("最大素数:");
                System.out.print(result.getResult());
            }
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
