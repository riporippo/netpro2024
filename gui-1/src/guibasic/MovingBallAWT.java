package guibasic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//配列で5つのボールを動かしてみよう
public class MovingBallAWT {
	public static void main(String[] args) {
		FFrame f = new FFrame();
		f.setSize(500, 500);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.show();
	}


	static class FFrame extends Frame implements Runnable {

		Thread th;
		Ball[] myBalls;

		private boolean enable = true;
		private int counter = 0;

		FFrame() {
			th = new Thread(this);
			th.start();
		}

		public void run() {
            myBalls = new Ball[5];
            for(int i=0; i<myBalls.length; i++){
                myBalls[i] = new Ball();
                myBalls[i].setPosition(10+50*i,60+40*i);
                myBalls[i].setR(20+5*i);
                Color r = new Color((int)128+i*10,(int)128+i*20,(int)128+20*i);
                myBalls[i].setColor(r);
            }
			while (enable) {

				try {
					th.sleep(100);
					counter++;
					if (counter >= 200) enable = false;
				} catch (InterruptedException e) {
				}
				for(Ball ball : myBalls){
                    ball.move();
                }

				repaint();  // paint()メソッドが呼び出される
			}
		}


		public void paint(Graphics g) {
            for(Ball ball: myBalls){
                ball.draw(g);
            }
		}

		// Ball というインナークラスを作る
		class Ball {
			int x;
			int y;
			int r; // 半径
			Color c = Color.RED;

			int xDir = 1;  // 1:+方向  -1: -方向
			int yDir = 1;

			void setColor(Color c) {
				this.c = c;
			}


			void move() {

				if ((xDir == 1) && (x >= 300)) {
					xDir = -1;
				}
				if ((xDir == -1) && (x <= 100)) {
					xDir = 1;
				}

				if (xDir == 1) {
					x = x + 10;
				} else {
					x = x - 10;
				}


				if ((yDir == 1) && (y >= 300)) {
					yDir = -1;
				}
				if ((yDir == -1) && (y <= 100)) {
					yDir = 1;
				}

				if (yDir == 1) {
					y = y + 10;
				} else {
					y = y - 10;
				}


			}


			void setPosition(int x, int y) {
				this.x = x;
				this.y = y;
			}

			void setR(int r) {
				this.r = r;
			}

			void draw(Graphics g) {
				g.setColor(c);
				g.fillOval(x, y, 2 * r, 2 * r);  // rは半径なので2倍にする
			}

		}//innner class Ball end

	}

}
