package guibasic;


import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWT9 {

	public static void main(String[] args){
		new FacesAWT9();
	}

    FacesAWT9(){
		FaceFrame f = new FaceFrame();
		f.setSize(800,800);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);}});
		f.setVisible(true);
	}

	// インナークラスを定義
	class FaceFrame extends Frame{
    private FaceObj[] fobj;
	
	FaceFrame(){
		fobj = new FaceObj[9];
		for(int j=0;j<3;j++) {
			for (int i = 0; i < 3; i++) {
				fobj[i+3*j]= new FaceObj();
				fobj[i+3*j].setPosition(200*i+50+10*i,200*j+50+10*j);
		        fobj[i+3*j].setEmotionLevel(i,j);
			}
		}
   }


	public void paint(Graphics g) {
	// この中には、g.drawLine というのは入ってこない
	// Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
	for(int i=0; i<3; i++){
		for(int j=0; j<3; j++){
			fobj[i+3*j].drawFace(g);
		}
	}
	}
 }//FaceFrame end

	//Faceクラスを作ってみよう。
	private class FaceObj{
		private int w;
	    private int h;
	    private int xStart;
	    private int yStart;
		private int emotionLevel;
		FaceObj(){
			this.w = 200;
			this.h = 200;
		}
		public void setPosition(int x, int y){
			this.xStart = x;
			this.yStart = y;
		}
		public void drawFace(Graphics g){
			drawRim(g);
			drawBrow(g, 30); 
			drawEye(g, 35);
			drawNose(g, 40);
			drawMouth(g, 100);		
		}
		public void drawRim(Graphics g) {  // wが横幅、hが縦幅
			Color originColor = g.getColor();
			Color fillColor = new Color(102,34,0,100);
			g.setColor(fillColor);
			g.fillRect(xStart,yStart,w,h);
			g.setColor(originColor);
			g.drawLine(xStart,yStart, xStart+w, yStart);
			g.drawLine(xStart, yStart, xStart, yStart+h);
			g.drawLine(xStart, yStart+h, xStart+w, yStart+h);
			g.drawLine(xStart+w, yStart, xStart+w, yStart+h);	
		}
	
		public void drawBrow(Graphics g,int bx) { // xは目の幅 呼ばれる方(=定義する方)
		    g.drawLine(xStart+30,yStart+40+emotionLevel*2,xStart+60,yStart+40-emotionLevel*5);
			g.drawLine(xStart+30+60,yStart+40-emotionLevel*2,xStart+60+60,yStart+40+emotionLevel*5);
		}
	
		public void drawNose(Graphics g, int nx) { // xは鼻の長さ
			Color originColor = g.getColor();
			Color color = new Color(255,0,0);
			g.setColor(color);
			g.fillOval(xStart + w/2,yStart+h/2-emotionLevel/2,nx,nx);
			Color color2 = new Color(255,255,255);
			g.setColor(color2);
			g.fillOval(xStart + w/2+10,yStart+h/2-emotionLevel/2+5,nx/4,nx/4);
			g.setColor(originColor);
		}
	
		public void drawEye(Graphics g, int r) { // rは目の半径
			g.drawOval(xStart+45,yStart+65,r,r);
			g.drawOval(xStart+45+60,yStart+65,r,r);
			
		}
	
		public void drawMouth(Graphics g, int mx) { // xは口の幅

			int xMiddle = xStart + w/2;
			int yMiddle = yStart + h - 30;
			g.drawLine(xMiddle - mx/2, yMiddle+emotionLevel*5, xMiddle , yMiddle-emotionLevel*2);
			g.drawLine(xMiddle, yMiddle-emotionLevel*2, xMiddle + mx/2, yMiddle+emotionLevel*5);
		}
		public void setEmotionLevel(int i, int j){
			this.emotionLevel = i*j - 4 + j*j-1;
		}
	}

}//Faces class end