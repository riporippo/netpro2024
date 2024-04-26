import java.util.Scanner;

public class Calc2Scanner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i=0;
        Scanner scan;
		while(i<10) {
			scan = new Scanner(System.in);

			String str1 = scan.next();
			System.out.println("最初のトークンは: " + str1);

			String str2 = scan.next();
			System.out.println("次のトークンは  : " + str2);
            System.out.println(Integer.parseInt(str1)+Integer.parseInt(str2));
			i++;
		}
	}
}

//  課題    キーボードから2つの数字を打ち込む
//     その足し算結果を、出力する。