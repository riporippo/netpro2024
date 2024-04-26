public class XmasTreeKadai {
    public static void main(String[] args) {
        //int X=Integer.parseInt(args[0]);
        //int Y=Integer.parseInt(args[1]);
        System.out.println("Draw your own xmas tree with multi-loop!");
        for(int height=0; height<25; height++){//縦ループ
            if(height<=14){
            for(int width=0; width<(30/2)-height; width++){//横ループ
                if(width%3==(height%3)&&width!=(30/2)-height-1) System.out.print("+");
                else if(width==(30/2)-height-1){
                    for(int i=0; i<height*2; i++){
                        System.out.print("*");
                    }
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }else{
            for(int i=0; i<30/2; i++){
                if(i!=13) System.out.print(" ");
                else{
                    for(int j=0; j<2; j++){
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
        }
    }
}