import java.util.Arrays;
import java.util.Random;
public class NetproLabMember {
static Random Random;
final static int gakusei = 110;
final static int BasefemaleProbability = 20;
final static int baseIwaiMem  =10;
static int[][] infoStudents;
    public static void main(String args[]){
        int studentNum = gakusei;
        int femalePro = BasefemaleProbability;
        int iwaiNum = baseIwaiMem;
        NetproLabMember aiueo = new NetproLabMember();
        infoStudents = new int[15][3];
        for(int i=0; i<15; i++){
            Random = new Random();
            studentNum = gakusei + Random.nextInt(20) - 10;
            femalePro = 20 + i;
            iwaiNum = baseIwaiMem + Random.nextInt(6) - 3;
            infoStudents[i][0] = studentNum;
            infoStudents[i][1] = femalePro;
            infoStudents[i][2] = iwaiNum;
        }
        System.out.println(Arrays.deepToString(infoStudents));
        System.out.println(aiueo.getProbability(infoStudents));
    }

    public float getProbability(int[][] infoStudents){
        float allMenMen = 1;
        for(int i=0; i<15; i++){
            int student = infoStudents[i][0];
            int femalePro = infoStudents[i][1];
            int limitIwai = infoStudents[i][2];
            //その年度の女子の数
            int femaleNum = student * femalePro/100;
            //研究室配属された人が全員男性である確率 
            float allMen = 1;
            for (int j = 0; j<limitIwai; j++){
                float men = (float)(student - j - femaleNum)/student-j;
                System.out.println(allMen);
                allMen = allMen * men;
            }
            allMenMen = allMenMen * allMen;
        }
        return allMenMen*100;
    }
}
