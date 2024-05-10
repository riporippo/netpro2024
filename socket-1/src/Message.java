import java.io.Serializable;
public class Message implements Serializable{
    String message;
    String username;
    
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getUserName(){
        return username;
    }
    public void setUserName(String username){
        this.username = username;
    }
}
