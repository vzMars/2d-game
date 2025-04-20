import java.awt.Image;
import java.awt.Toolkit;

public class Sword extends Rect {
	Image[] image;
	int current = 0;
	
	public Sword(int x, int y, int scale, String name, String[] direction) {
		super(x, y, scale, scale);
		image = new Image[direction.length - 1];
		
		for (int i = 0; i < direction.length - 1; i++) {
			image[i] = Toolkit.getDefaultToolkit().getImage(name + direction[i] + ".png");
		}
	}
	
	public void changeSwordDirection(int direction, int x, int y) {
		current = direction;
		updateSwordLocation(x, y);
	}
	
	public Image currentImage() {
		return image[current];
	}
	
	public void updateSwordLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
