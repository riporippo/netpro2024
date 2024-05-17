import java.io.Serializable;
import java.util.ArrayList;

public class PrimeChecker implements Serializable,ITask{
    private int checkNum;
    private int resultNum;
    @Override
    public void setExecNumber(int x) {
        checkNum = x;
        resultNum = x;
    }

    @Override
    public void exec() {
        ArrayList<Integer> PrimeList = new ArrayList<Integer>();
        boolean isPrime = true;
        PrimeList.add(2);
        for(int i=3; i<=checkNum; i++){
            for(int num : PrimeList){
                if(i%num==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                PrimeList.add(i);
            }else{
                isPrime = true;
            }
        }
        resultNum = PrimeList.get(PrimeList.size()-1);
    }

    @Override
    public int getResult() {
        return resultNum;
    }
}
