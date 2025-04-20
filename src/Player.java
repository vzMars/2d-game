import java.awt.Graphics;

public class Player extends Sprite {
	
	static String[] direction = { "up", "dn", "lt", "rt", "d"};
	
	boolean attacking = false;
	
	Sword sword;

	public Player(int x, int y, int scale) {
		super("p", x, y, scale, scale, direction, 3, 10);
		sword = new Sword(x, y, scale, "sword_", direction);
	}
	
	public void draw(Graphics pen) {
		if(moving) {
			pen.drawImage(animation[pose].nextImage(), x, y, w, h, null);
		} else if(attacking) {
			pen.drawImage(animation[pose].stillImage(), x, y, w, h, null);
			pen.drawImage(sword.currentImage(), sword.x, sword.y, w, h, null);
		} else {
			pen.drawImage(animation[pose].stillImage(), x, y, w, h, null);
		}
		
		attacking = false;
		moving = false;
	}
	
	public void attack() {
		attacking = true;
		if(pose == UP) {
			sword.changeSwordDirection(pose, x, y - h);
		} else if(pose == DN) {
			sword.changeSwordDirection(pose, x, y + h);
		} else if(pose == LT) {
			sword.changeSwordDirection(pose, x - w, y);
		} else if(pose == RT) {
			sword.changeSwordDirection(pose, x + w, y);
		}
	}

}
