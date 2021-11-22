import java.awt.Color;
import java.awt.Graphics;

public class Rectangle implements GameObject {

	private double x;
	private double y;
	
	private int width;
	private int height;
	
	
	public Rectangle(double x, double y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		
	}
	
	public void updateLogic() {
		
		
		

	}

	public void renderGraphics(Graphics g) {
		
		Color colorBefor = g.getColor();
		
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, width, height);
		
		g.setColor(colorBefor);
		

	}

}
