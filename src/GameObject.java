import java.awt.Graphics;

public interface GameObject {
	
	public void updateLogic(long dT);
	public void renderGraphics(Graphics g);
}
