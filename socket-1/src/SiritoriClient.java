import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class SiritoriClient {
    public static void main(String args[]) throws UnknownHostException, IOException, ClassNotFoundException{
        try{
        Socket socket = new Socket("localhost",5050);
        System.out.println("ポート5050で接続されました。");
        while (true){
        System.out.println("しりとりをしましょう！\n日本語かつひらがなで文字列を送信してね！");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        //Message型オブジェクトの設定
        System.out.println("ひらがなの文字列を入力してください(例:おせち)");
        Scanner scanner = new Scanner(System.in);
        //しりとり本文
        String message = scanner.next();
        //String message1 = new String(message.getBytes("UTF-8"),"UTF-8");
        System.out.println("ユーザーネームを入力してください: ");
        String username = scanner.next();
        //String username1 = new String(username.getBytes("UTF-8"),"UTF-8");

        Message message2 = new Message();
        message2.setMessage(message);
        message2.setUserName(username);

        oos.writeObject(message2);
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message response = (Message) ois.readObject();

        String message3 = response.getMessage();
        String username2 = response.getUserName();
        //String utfMessage = new String(message3.getBytes("UTF-8"),"UTF-8");
        //String utfUserName = new String(username2.getBytes("UTF-8"),"UTF-8");
        System.out.println(username2 +": "+message3);
        System.out.println("また、しりとりを続けたいですか？(y/n)");
        String isContinue;
        while(true){
            isContinue = scanner.next();
            if(isContinue.equals("y")||isContinue.equals("n")){
                break;
            }
        }
        if(isContinue.equals("n")){
            PrintWriter writer = new PrintWriter(oos,true);
            writer.println(isContinue);
            BufferedReader reader = new BufferedReader(new InputStreamReader(ois));
            String response2 = reader.readLine();
            System.out.println("server: " + response2);
            scanner.close();
            ois.close();
            oos.close();
            socket.close();
            break;
        }else{
            PrintWriter writer = new PrintWriter(oos,true);
            writer.println(isContinue);
            BufferedReader reader = new BufferedReader(new InputStreamReader(ois));
            String response2 = reader.readLine();
            System.out.println("server: " + response2);
            scanner.close();
            ois.close();
            oos.close();
        }
        }
        }catch(Exception e){
            System.err.println("エラーが発生。プログラムを終了。");
            e.printStackTrace();
        }
    }
}
