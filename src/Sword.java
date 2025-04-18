import java.awt.Image;
import java.awt.Toolkit;

public class Sword {
	Image[] image;
	int current = 0;
	
	public Sword(String name, String[] direction) {
		image = new Image[direction.length];
		
		for (int i = 0; i < direction.length; i++) {
			image[i] = Toolkit.getDefaultToolkit().getImage(name + direction[i] + ".png");
		}
	}
	
	public void changeSwordDirection(int direction) {
		current = direction;
	}
	
	public Image currentImage() {
		return image[current];
	}
	
}
