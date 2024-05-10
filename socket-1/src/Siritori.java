import java.io.Serializable;
import java.util.HashMap;
public class Siritori implements Serializable{
    final String[] list ={//設定用定数しりとり返答リスト
        "あんぱん","インド人","ウコン","エドワン","オカリン",
        "簡単","帰還","区間","結婚","股間",
        "サイパン","審判","駿河湾","折半","ソフラン",
        "対バン","ちえん","つんつるてん","テトちゃん","凸版",
        "南蛮","肉眼","ぬふーん","念","ノルマン",
        "廃藩置県","ヒアルロン酸","不倫","変換","砲丸",
        "マンガン","民間","無菌","滅菌","猛禽",
        "夜勤","ユーミン","要件",
        "ランタン","リンカーン","ルンダン","連弾","論壇",
        "猥談","を！？ををををを～んん～ん",
        "元旦","銀杏","軍艦","玄関","剛腕",
        "斬新","ジン","ズグリーン","禅","臓器が変",
        "団らん","ヂヂミ゛ン゛","づん","ディングドン","ドローン",
        "バッタンバン","びろーん","ブレード交換","ベギラゴン","凡",
        "パン","ピン","プリン","ペン","ポン"
    };
    final String[] hiragana = {//key設定用ひらがなリスト
        "あ","い","う","え","お",
        "か","き","く","け","こ",
        "さ","し","す","せ","そ",
        "た","ち","つ","て","と",
        "な","に","ぬ","ね","の",
        "は","ひ","ふ","へ","ほ",
        "ま","み","む","め","も",
        "や","ゆ","よ",
        "ら","り","る","れ","ろ",
        "わ","を",
        "が","ぎ","ぐ","げ","ご",
        "ざ","じ","ず","ぜ","ぞ",
        "だ","ぢ","づ","で","ど",
        "ば","び","ぶ","べ","ぼ",
        "ぱ","ぴ","ぷ","ぺ","ぽ",
    };
    HashMap<String,String> hashmap;//返答用語句辞書
    Siritori(){//コンストラクタ
        hashmap = new HashMap<String,String>();
        for(int i=0; i<list.length; i++){
            hashmap.put(hiragana[i],list[i]);
        }
    }

    public String returnString(String mondai){//しりとり返答メソッド
        String lastLetter = mondai.substring(mondai.length() - 1);
        if(lastLetter.equals("ん")){
            return "んが付いたので、貴方の負けです！";
        }else{
            return hashmap.get(lastLetter)+"......ってあ、んがついちゃった...貴方の勝ちです！";
        }
    }
    public static void main(String args[]){
        Siritori siritori = new Siritori();
        for (String a: siritori.hashmap.values()){
            System.out.println(a);
        }
    }
}
