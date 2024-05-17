import java.net.InetAddress;
import java.net.UnknownHostException;

public class checkJavaAddress {
    public static void main(String args[]) throws UnknownHostException{
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostName());
        System.out.println(addr.getHostAddress());
        
    }
}
