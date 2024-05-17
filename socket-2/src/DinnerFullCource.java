class DinnerFullCource{
    private Dish[] list = new Dish[5];
    public static void main(String[] args) {
        DinnerFullCource fullcource = new DinnerFullCource();
        fullcource.eatAll();
    }
    DinnerFullCource(){
        for(int i=0; i<list.length;i++){
            list[i] = new Dish();
        }
        list[0].setName("にくい肉");
        list[0].setValune(200);
        list[1].setName("未確認角煮");
        list[1].setValune(680);
        list[2].setName("朝あさり");
        list[2].setValune(10101);
        list[3].setName("がつがつとんかつ");
        list[3].setValune(30000);
        list[4].setName("油そば");
        list[4].setValune(200);
    }
    public void eatAll(){
        for(Dish menu: list){
            System.out.println("メニュー名: "+menu.getName()+" 価格:"+ String.valueOf(menu.getValune())+"円");
        }
    }
}
