// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

	public static void main(String[] args) { 

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader というのは、データ読み込みのクラス(型)
			// クラスの変数を作るには、new を使う。

			// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
			//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		try {
            int age = 0;
            while(true){
                System.out.println("あなたは今何歳ですか?");
                String line = reader.readLine();
                if(line.equals("q")||line.equals("e")) System.exit(0);
                age = Integer.parseInt(line);
                if(age>0&&age<=120){
                    break;
                }
            }
			System.out.println("あなたは" + age + "歳ですね。");
			System.out.println("あなたは2030年、" + (age + 6) + "歳ですね。");
            System.out.println("あなたは、"+checkEpi(age)+"生まれですね。");
		}
		catch(IOException e) {
			System.out.println(e);
		}


	}
    public static String checkEpi(int age){
        String epi = "";
        int year = 0;
        if(age<6&&age>=0){
            epi="令和";
            year = (2024 - age) - 2019; 
            if(year==1) return "令和元年";
        }
        else if (age<36&&age>=6){
            epi="平成";
            year = (2024 - age) - 1989;
            if(year==1) return "平成元年";
        }
        else if (age<97&&age>=36){
            epi="昭和";
            year = (2024 - age) - 1928;
            if(year==1) return "昭和元年";
        }
        else if (age<112&&age>=97){
            epi="大正";
            year = (2024 - age) - 1912;
            if(year==1) return "大正元年";
        }
        else{
            epi="明治";
            year = (2024 - age) - 1890;
            if(year==1) return "明治元年";
        }
        return epi+String.valueOf(year)+"年";
    }
}

//  課題    キーボードから数字を打ち込む
//  その結果、 あなたは、???歳ですね、と画面に表示させる。
//  その後、あなたは10年後、????歳ですね、と画面に表示させる。

