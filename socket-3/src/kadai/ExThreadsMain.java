package kadai;
import java.util.Random;
public class ExThreadsMain implements Runnable{
    private int num;
    static private Random random = new Random();
    public static void main(String[] args){
        Thread[] threads = new Thread[30];
        for(int i=0; i<threads.length; i++){
            threads[i] = new Thread(new ExThreadsMain());
        }
        for(Thread thread : threads){
            thread.start();
        }
        for(Thread thread : threads){
            try{
                thread.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void run(){
        try{
            for(int i=0; i<5; i++){
                num = random.nextInt(1,1000);
                System.out.println(Thread.currentThread()+":"+String.valueOf(num));
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
