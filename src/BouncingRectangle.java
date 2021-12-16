import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Vector;

public class BouncingRectangle extends Entity implements GameObject {

	private int width;
	private int height;
	
	private double xDirection = 1;
	private double yDirection = 1;
	
	private int windowHeight;
	private int windowWidth;
	
	GameWindow window;
	
	Vector<Color> colors =new Vector<Color>() ;
	Random r = new Random();
	
	private Color randomColor;
	
	public BouncingRectangle(double x, double y, int width, int height, GameWindow window)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.width = width;
		this.height = height;
			
		
		windowHeight = window.getHeight();
		windowWidth = window.getWidth();
		
		
		colors.add(Color.red);
		colors.add(Color.green);
		colors.add(Color.yellow);
		colors.add(Color.cyan);
		colors.add(Color.white);
		colors.add(Color.BLUE);
		colors.add(Color.PINK);
		
		randomColor = colors.get(r.nextInt(colors.size()));
	}
	
	public void updateLogic(long dT) {
	
		//TODO make function to generate random colo
		//     setRandomColor();
		//     with rgb;
		
	
		if(xPosition > windowWidth-width) {
			xDirection = -1;
			randomColor = colors.get(r.nextInt(colors.size()));
		}
		
		if(xPosition<0) {
			randomColor = colors.get(r.nextInt(colors.size()));
			xDirection = 1;
		}
		
		if(yPosition > windowHeight-height) {
			randomColor = colors.get(r.nextInt(colors.size()));
			yDirection = -1;
		}
		
		if(yPosition<0) {
			randomColor = colors.get(r.nextInt(colors.size()));
			yDirection = 1;
		}
		
		
		xPosition=xPosition+(xDirection*0.4);
		
		yPosition= yPosition+(yDirection* 0.4);

		
		
			//System.out.println("x: " + x + "     y: " + y);
		
	}
	public void renderGraphics(Graphics g) {
		
		Color colorBefor = g.getColor();
		g.setColor(randomColor);
	
		
		//g.setColor(Color.blue);
		g.fillRect((int)xPosition, (int)yPosition, width, height);
		
		g.setColor(colorBefor);
	}

	@Override
	public void printToConsole() {
		System.out.println("bouncing rectangle");
		
	}

}
