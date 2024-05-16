import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SiritoriServer {
    public static void main(String args[]) throws ClassNotFoundException {
        try {
            ServerSocket server = new ServerSocket(5050);
            System.out.println("クライアントからの入力を待っています");

            while (true) { // ループを追加
                Socket socket = server.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message getMessage = (Message) ois.readObject();
                String getSiritori = getMessage.getMessage();
                String username = getMessage.getUserName();
                System.out.println(username + "からのしりとりメール: " + getSiritori);

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Siritori response = new Siritori();
                Message responseMessage = new Message();
                responseMessage.setMessage(response.returnString(getSiritori));
                responseMessage.setUserName("サーバー");

                oos.writeObject(responseMessage);
                oos.flush();

                // クライアントからの入力を待つために、ループを継続
                String isContinue = ois.readUTF();
                if(isContinue.equals("n")){
                    oos.writeUTF("じゃあね");
                    oos.flush();
                    ois.close();
                    oos.close();
                    socket.close();
                    server.close();

                }else{
                    oos.writeUTF("もう一戦いきましょ～！");
                    oos.flush();
                    ois.close();
                    oos.close();
                    socket.close();
                }
            }
        } catch (Exception e) {
            System.err.println("エラー発生。プログラム終了。");
            e.printStackTrace();
        }
    }
}
