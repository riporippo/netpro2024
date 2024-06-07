package guichat;

import java.awt.Color;
import java.awt.Graphics;

class GUIAnimatinFaceLook {// 顔のオブジェクト

	int h = 100;
	int w = 100;

	int xStart = 0;
	int yStart = 0;

	public void setXY(int x, int y) {
		this.xStart = x;
		this.yStart = y;
	}

	public void setSize(int h, int w) {
		this.h = h;
		this.w = h;
	}

	public GUIAnimatinFaceLook() {

	}

	void makeFace(Graphics g) {
		// makeRim(g);
		makeEyes(g, w / 5,1);
		makeNose(g, h / 5,1);
		makeMouth(g, w / 2,1);
	}

	public void makeFace(Graphics g, String emotion) {
		// **ここにemotion毎の顔を用意する。*///
		if (emotion.equals("normal")) {
			int emotionLevel = 1;
			makeEyes(g, w / 5,emotionLevel);
			makeNose(g, h / 5,emotionLevel);
			makeMouth(g, w / 2,emotionLevel);
		}else if(emotion.equals("angry")){
			int emotionLevel = 2;
			makeEyes(g,w/5,emotionLevel);
			makeNose(g,h/3,emotionLevel);
			makeMouth(g,w/2,emotionLevel);
			makeOko(g, 20);
		}else if(emotion.equals("smile")){
			int emotionLevel = 3;
			makeEyes(g,w/5,emotionLevel);
			makeNose(g,h/4,emotionLevel);
			makeMouth(g,w/2,emotionLevel);
		}

	}

	/*
	 * public void makeRim(Graphics g) { g.drawLine(xStart, yStart, xStart + h,
	 * yStart); g.drawLine(xStart, yStart, xStart, yStart + w);
	 * g.drawLine(xStart, yStart + w, xStart + h, yStart + w); g.drawLine(xStart
	 * + h, yStart, xStart + h, yStart + w); }
	 */

	void makeEyes(Graphics g, int eyeSize, int emotionLevel) {
		// setColor(Color.red);
		// g.fillRect(xStart + (h * 1 / 3) - 20, yStart + (w * 1 / 3) - 10,
		// 10, 10);
		if(emotionLevel == 1){
			g.setColor(Color.blue);
		}else if(emotionLevel == 2){
			g.setColor(Color.red);
		}else if(emotionLevel == 3){
			g.setColor(Color.ORANGE);
		}

		// g.fillRoundRect()
		// g.fillOval()
		g.fillArc(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize,
				0, 300);
		g.setColor(Color.black);

		// g.drawLine(xStart + (h * 1 / 3) - 20, yStart + (w * 1 / 3) - 10,
		// xStart + (h * 1 / 3) + 20, yStart + (w * 1 / 3) - 10);
		// g.drawLine(xStart + (h * 2 / 3) - 20, yStart + (w * 1 / 3) - 10,
		// xStart + (h * 2 / 3) + 20, yStart + (w * 1 / 3) - 10);

		g.drawOval(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
		g.drawOval(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
	}// makeEyes()

	public void makeNose(Graphics g, int noseSize, int emotionLevel) {
		g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart
				+ (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
	}// makeNose() end

	public void makeMouth(Graphics g, int mouseSize, int emotionLevel) {
		if(emotionLevel != 3){
			int xMiddle = xStart + h / 2;
			int yMiddle = yStart + (3 * w / 4);
			g.drawLine(xMiddle - mouseSize / 2, yMiddle, xMiddle + mouseSize / 2,
						yMiddle);
		}else{
			int xMiddle = xStart + h/2;
			int yMiddle = yStart + (3 * w /4);
			g.drawLine(xMiddle - mouseSize / 2, yMiddle, xMiddle, yMiddle - mouseSize/5);
			g.drawLine(xMiddle,yMiddle - mouseSize/5,xMiddle + mouseSize/2,  yMiddle);
		}
	}
	public void makeOko(Graphics g, int size){
		int xmiddle = xStart + h;
		int ymiddle = yStart;
		//左側の「く」
		g.drawLine(xmiddle - size/2,ymiddle,xmiddle-size*2,ymiddle - size*2);
		g.drawLine(xmiddle - size/2,ymiddle,xmiddle-size*2,ymiddle + size*2);
		//右側の「く」
		g.drawLine(xmiddle + size/2,ymiddle,xmiddle+size*2,ymiddle - size*2);
		g.drawLine(xmiddle + size/2,ymiddle,xmiddle+size*2,ymiddle + size*2);
		//上側の「く」
		g.drawLine(xmiddle,ymiddle - size / 2,xmiddle-size*2,ymiddle - size*2);
		g.drawLine(xmiddle,ymiddle - size/2,xmiddle+size*2,ymiddle - size*2);
		//下側の「く」
		g.drawLine(xmiddle,ymiddle + size/2,xmiddle-size*2,ymiddle + size*2);
		g.drawLine(xmiddle,ymiddle + size/2,xmiddle+size*2,ymiddle + size*2);
	}
}// FaceObj End