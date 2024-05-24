package kadai;
import java.io.PrintWriter;
public class CountAZTenRunnable implements Runnable {//インタフェース
    private char key;
    public static PrintWriter out;
    public static void main(String[] args){
        Thread[] threads = new Thread[26];//Thread配列
        out = new PrintWriter("6_C_Result.txt");
        for(int i=0; i<threads.length; i++){
            char alfabet = (char)(i+97);//charを対応する作る
            threads[i] = new Thread(new CountAZTenRunnable(alfabet));//コンストラクタ内でsetChar()を呼び出し保存
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

    // run メソッドは、新しいスレッドが実行するコードを含みます。
    public void run() {
        // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println(this.getChar()+ i);//getChar()でStringに変換したcharを呼び出し

                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(1000);  // ミリ秒単位のスリープ時間
            }
        }
        catch(InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
    public void setChar(char key){
        this.key = key; 
    }
    public String getChar(){
        String keyword = String.valueOf(key);
        return keyword;
    }
    CountAZTenRunnable(char alfabet){
        setChar(alfabet);
    }
}
