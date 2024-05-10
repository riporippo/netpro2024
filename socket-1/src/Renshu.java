class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }
    //1~xまでの自然数集合の和を返す関数
    public int sumUpToN(int n){
        if (n < 1){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return n + sumUpToN(n-1);
        }
    }
    //pからqまでの整数の合計値
    public int sumFromPtoQ(int p, int q){
        int sum = 0;
        if(q < p){
            return -1;
        }
        for (int i=p; i<=q; i++){
            sum += i;
        }
        return sum;
    }
    //配列の指定されたindex以降の要素の合計値
    public int sumFromArrayIndex(int[] a, int index){
        if (index < 0 || index > a.length - 1 ){
            return -1;
        }
        int sum = 0;
        for (int i=index; i<=a.length-1; i++){
            sum+=a[i];
        }
        return sum;
    }
    //配列の最大の値を返す
    public int selectMaxValue(int[] a){
        int maxValue = a[0];
        for(int num : a){
            if(maxValue < num){
                maxValue = num;
            }
        }
        return maxValue;
    }
    //配列の最大値が入っているindexを返す
    public int selectMaxIndex(int[] a){
        int maxIndex = 0;
        for(int i=0; i<a.length; i++){
            if(a[maxIndex]<a[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    //配列のi番目とj番目の要素を入れ替える
    public void swapArrayElements(int[] p, int i, int j){
        int tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }
    //同じ長さの二つの配列の内容を入れ替える
    public boolean swapTwoArrays(int[] a, int[] b){
        if(a.length == b.length){
            int[] temp = new int[a.length];
            int j=0;
            for(int i:a){
                temp[j] = i;
                j++;
            }
            j=0;
            for(int i:b){
                a[j] = i;
                j++;
            }
            j=0;
            for(int i:temp){
                b[j] = i;
                j++;
            }
            return true;
        }
        else{
            return false;
        }
    }
}