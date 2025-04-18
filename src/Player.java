import java.awt.Graphics;

public class Player extends Sprite {
	
	static String[] direction = { "up", "dn", "lt", "rt"};
	
	boolean attacking = false;
	
	Sword sword;

	public Player(int x, int y, int scale) {
		super("p", x, y, scale, scale, direction, 3, 10);
		sword = new Sword("sword_", direction);
	}
	
	public void draw(Graphics pen) {
		if(moving) {
			pen.drawImage(animation[pose].nextImage(), x, y, w, h, null);
		} else if (attacking) {
			pen.drawImage(animation[pose].stillImage(), x, y, w, h, null);
			attackDirection(pen);
		} else {
			pen.drawImage(animation[pose].stillImage(), x, y, w, h, null);
		}
		
		attacking = false;
		moving = false;
	}
	
	public void attack() {
		attacking = true;
	}
	
	public void attackDirection(Graphics pen) {
		sword.changeSwordDirection(pose);
		switch(pose) {
		  case UP:
			pen.drawImage(sword.currentImage(), x, y - h, w, h, null);
		    break;
		  case DN:
			  pen.drawImage(sword.currentImage(), x, y + h, w, h, null);
		    break;
		  case LT:
			  pen.drawImage(sword.currentImage(), x - w, y, w, h, null);
			break;
		  default:
			  pen.drawImage(sword.currentImage(), x + w, y, w, h, null);
		}

	}

}
