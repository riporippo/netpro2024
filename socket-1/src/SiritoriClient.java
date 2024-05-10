import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class SiritoriClient {
    public static void main(String args[]) throws UnknownHostException, IOException, ClassNotFoundException{
        try{
        Socket socket = new Socket("localhost",5050);
        System.out.println("ポート5050で接続されました。");

        System.out.println("しりとりをしましょう！\n日本語かつひらがなで文字列を送信してね！");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.flush();
        //Message型オブジェクトの設定
        System.out.println("ひらがなの文字列を入力してください(例:おせち)");
        Scanner scanner = new Scanner(System.in);
        //しりとり本文
        String message = scanner.next();
        System.out.println("ユーザーネームを入力してください: ");
        String username = scanner.next();
        scanner.close();

        Message message2 = new Message();
        message2.setMessage(message);
        message2.setUserName(username);

        oos.writeObject(message2);
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message response = (Message) ois.readObject();

        String message3 = response.getMessage();
        String username2 = response.getUserName();
        System.out.println(username2 +": "+message3);

        ois.close();
        oos.close();
        socket.close();
        }catch(Exception e){
            System.err.println("エラーが発生。プログラムを終了。");
            e.printStackTrace();
        }
    }
}
