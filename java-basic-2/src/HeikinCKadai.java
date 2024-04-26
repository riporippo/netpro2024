import java.util.Random;
public class HeikinCKadai {
    static Kamoku[] students;
    static Random aiueo;
    public static void main(String[] args) {
        aiueo = new Random();
        students = new Kamoku[100];
        for (int i=0; i<100; i++){
            students[i]= new Kamoku(aiueo.nextInt(0,100));
        }
        average();
        passExamMember();
    }
    public static void average(){
        int sum = 0;
        for(Kamoku a : students){
            sum+=a.getScore();
        }
        System.out.print("平均点は");
        System.out.print(sum/students.length);
        System.out.println();
    }
    public static void passExamMember(){
        int[] pass = new int[100];
        int i=0;
        for (Kamoku a : students){
            if(a.getScore()>=80){
                pass[i] = a.getScore();
                i++;
            } 
        }
        int[] passMember = new int[i];
        for (int j=0;j<i;j++ ){
            passMember[j] = pass[j];
        }
        for (int j=0; j<passMember.length; j++){
            for(int f=j; f<passMember.length; f++){
                if(passMember[f]<passMember[j]){
                    int temp = passMember[j];
                    passMember[j] = passMember[f];
                    passMember[f] = temp;
                }
            }
        }
        System.out.println("合格者一覧を表示");
        for(int point: passMember){
            System.out.println(point);
            System.out.println();
        }
    }
}
