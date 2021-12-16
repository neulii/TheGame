import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;

public class GameWindow extends Canvas implements GameObject{

	private static final long serialVersionUID = 3400434845763850354L;
	
	final int UPS = 60;
	int frames = 0;
	int ticks = 0;
	
	JFrame window;
	boolean gameIsRunning = true;
	

	BouncingRectangle r;
	BouncingRectangle rr;
	
	private Graphics graphics;

	
	private int actualFrames;
	private int actualTicks;
	
	public GameWindow(){
	
		initializeWindow();
		
		r = new BouncingRectangle(100,100,50,50,this);
		rr = new BouncingRectangle(10,80,50,50,this);
		

		while(true) {
			//Game Loop
			

			long startTime = System.nanoTime();
			long deltaTime = 0;
			long frameCounterTime;
			long renderCounterTime;
			double timePerFrame = 1000000000.0 / UPS;

			
			
			frameCounterTime = System.currentTimeMillis();
			renderCounterTime = System.currentTimeMillis();

			while (gameIsRunning) {
				deltaTime = System.nanoTime() - startTime;

				if (deltaTime >= timePerFrame) {

					//update Methode
					updateLogic(deltaTime);

					frames++;
					deltaTime = 0;
					startTime = System.nanoTime();
				}

				//Rendermethode
				renderGraphics(graphics);
				ticks++;

				//RenderCounter
				if(System.currentTimeMillis() - renderCounterTime>=1000)
				{
					//System.out.println(actualTicks);
					actualTicks = ticks;
					ticks = 0;
					renderCounterTime = System.currentTimeMillis();
				}
				
				
				
				
				//Frame Counter
				if (System.currentTimeMillis() - frameCounterTime >= 1000) {
				//System.out.println(frames);
					actualFrames = frames;
					frames = 0;
					frameCounterTime = System.currentTimeMillis();
				}
			}
		}
		
	}
	
	private void initializeWindow() {
		window = new JFrame("The Game");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		window.setLocationRelativeTo(null);
		
		window.add(this);
		window.setVisible(true);

	}
	
	public void updateLogic(long dT) {

		window.setTitle("Game =======     FPS: " + actualFrames + "    UPS: " + actualTicks);
		for(long i = 0; i<10000L;i++)
		{
			;
		}
	
		
	
		
		//System.out.println("Tick Nr.: " + logicTicks);
		
		r.updateLogic(dT);
		rr.updateLogic(dT);
		
	}

	public void renderGraphics(Graphics g) {
		
		
		
		BufferStrategy bs;
		bs = this.getBufferStrategy();
		
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		//============ drawing stuff   ============
		
		
		
		
		r.renderGraphics(g);
		rr.renderGraphics(g);
		
		
		//============================================
		
		
		bs.show();
		g.dispose();
		
		
		
		
		
	}
	
}
