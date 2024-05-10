import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SiritoriServer {
    public static void main(String args[]) throws ClassNotFoundException{
        try{
            //ポート5050固定で通信
            ServerSocket server = new ServerSocket(5050);
            //クライアントからの接続要求を待つ
            System.out.println("クライアントからの入力を待っています");
            Socket socket = server.accept();
            
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message getMessage = (Message) ois.readObject();
            System.out.println(System.getProperty("file.encoding"));
            String getSiritori = getMessage.getMessage();
            String username = getMessage.getUserName();
            String utfSiritori = new String(getSiritori.getBytes("UTF-8"),"UTF-8");
            String utfUsername = new String(username.getBytes("UTF-8"),"UTF-8");
            System.out.println(utfUsername +  "からのしりとりメール: " + utfSiritori);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.flush();
            Siritori response = new Siritori();
            Message responseMessage = new Message();
            responseMessage.setMessage(response.returnString(utfSiritori));
            responseMessage.setUserName("サーバー");

            oos.writeObject(responseMessage);
            oos.flush();

            //close処理
            ois.close();
            oos.close();
            //socket終了
            socket.close();
            server.close();
        }catch(Exception e){
            System.err.println("エラー発生。プログラム終了。");
            e.printStackTrace();
        }
    }
}
