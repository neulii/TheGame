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

	
	final boolean DEBUG = false;
	//final boolean DEBUG = true;
	
	final int UPS = 60;
	
	
	private static final long serialVersionUID = 3400434845763850354L;
	
	private JFrame window;
	private boolean gameIsRunning = true;
	

	private long framesRendered = 0;
	private long logicTicks = 0;
	
	BouncingRectangle r;
	BouncingRectangle rr;
	
	private Graphics g;
	
	public GameWindow(){
	
		initializeWindow();
		
		r = new BouncingRectangle(100,100,50,50,this);
		rr = new BouncingRectangle(10,80,50,50,this);
		

		
		
		long currentTime = System.nanoTime();
		long loopDuration = 0;
		long lastTime = 0;
		
		long actualTimeDuration = 0;
		
		
		while(gameIsRunning) {
		
			loopDuration = System.nanoTime()-lastTime;
			
			lastTime =System.nanoTime();
			
			actualTimeDuration = actualTimeDuration + loopDuration;
			
			if(actualTimeDuration>1000000/UPS) {
				//System.out.println("super");
				actualTimeDuration = 0;
				
				
				updateLogic(loopDuration);
				
			}
				
			
			//currentTime = System.nanoTime();
			
			
			//System.out.println(loopDuration/1000);
			
			
			
			
			//update logic with 60 fps!!
			
			
			
		
			
			
			//render graphics as fast as can
			renderGraphics(g);
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

		/**
		for(long i = 0; i<1000000000000000L;i++)
		{
			;
		}
		**/
		
		logicTicks++;
		if(DEBUG)
			System.out.println("Tick Nr.: " + logicTicks);
		
		
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
		
		framesRendered++;
		if(DEBUG)
			System.out.println("Frame Nr.: " + framesRendered);
		
	}
	
}
