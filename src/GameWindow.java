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
	
	private JFrame window;
	private boolean gameIsRunning = true;
	
	Vector<Color> colors =new Vector<Color>() ;
	
	private Color randomColor;
	
	private int xDirection = 1;
	private int yDirection = 1;
	
	private long framesRendered = 0;
	private long logicTicks = 0;
	
	private Point p;
	private double x = 100.0;
	private double y = 100.0;
	
	Rectangle r;
	
	private Graphics g;
	
	public GameWindow(){
	
		initializeWindow();
		
		r = new Rectangle(10,10,50,50);
		
		
		while(gameIsRunning) {
			
			updateLogic();
			
		
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
	
	public void updateLogic() {
		
		
		
				
		
		colors.add(Color.red);
		colors.add(Color.green);
		colors.add(Color.yellow);
		colors.add(Color.cyan);
		colors.add(Color.white);
		colors.add(Color.BLUE);
		colors.add(Color.PINK);
		
		
		Random r = new Random();
		
		
		
		//TODO make function to generate random colo
		//     setRandomColor();
		//     with rgb;
		
		
		
		
		if(x > this.getWidth()-100) {
			xDirection = -1;
			randomColor = colors.get(r.nextInt(colors.size()));
		}
		
		if(x<0) {
			randomColor = colors.get(r.nextInt(colors.size()));
			xDirection = 1;
		}
		
		if(y > this.getHeight()-100) {
			randomColor = colors.get(r.nextInt(colors.size()));
			yDirection = -1;
		}
		
		if(y<0) {
			randomColor = colors.get(r.nextInt(colors.size()));
			yDirection = 1;
		}
		
		
		
		x = x+(xDirection*0.4);
		y= y+(yDirection* 0.5);
		
		
		
		
		
		
		logicTicks++;
		System.out.println("Tick Nr.: " + logicTicks);
		
		
		
		
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
		g.setColor(randomColor);
		g.fillRect((int)x,(int)y, 100, 100);
		
		
		r.renderGraphics(g);
		
		
		//============================================
		
		
		bs.show();
		g.dispose();
		
		framesRendered++;
		System.out.println("Frame Nr.: " + framesRendered);
		
	}
	
}
