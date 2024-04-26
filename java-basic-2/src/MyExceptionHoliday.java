import java.util.Scanner;
public class MyExceptionHoliday {
    static Scanner scan;
    public static void main(String[] args) {
        MyExceptionHoliday aiueo = new MyExceptionHoliday();
        scan = new Scanner(System.in);
        System.out.println("日付を入力してください");
        try{
            int i = scan.nextInt();
            aiueo.test(i);
        }catch(NoHolidayException e){
            e.printStackTrace();
        }
    }
    void test(int num)throws NoHolidayException{
        if(num==3||num==4||num==5||num==6||
        num==11||num==12||num==18||num==19||
        num==25||num==26){
            throw new NoHolidayException();
        }else{
            int i = scan.nextInt();
            test(i);
        }
    }

}
