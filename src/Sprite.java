import java.awt.Graphics;

public class Sprite extends Rect {
	Animation[] animation;

	boolean moving = false;
	boolean dead = false;
	

	final int UP = 0;
	final int DN = 1;
	final int LT = 2;
	final int RT = 3;
	final int DEAD = 4; 

	int pose = DN;
	
	int vx;
	int vy;
	
	int startingX;
	int startingY;

	public Sprite(String name, int x, int y, int w, int h, String[] pose, int count, int duration) {
		super(x, y, w, h);
		
		startingX = x;
		startingY = y;
		
		animation = new Animation[pose.length];
		
		for (int i = 0; i < pose.length; i++) {
			animation[i] = new Animation(name + "_" + pose[i], count, duration);
		}
	}
	
	public void draw(Graphics pen) {
		if (moving) {
			pen.drawImage(animation[pose].nextImage(), x, y, w, h, null);
		} else {
			pen.drawImage(animation[pose].stillImage(), x, y, w, h, null);
		}
		
		moving = false;
	}
	
	public void moveUp(int dy) {
		y -= dy;
		moving = true;
		pose = UP;
	}
	
	public void moveDown(int dy) {
		y += dy;		
		moving = true;
		pose = DN;
	}
	
	public void moveLeft(int dx) {
		x -= dx;		
		moving = true;
		pose = LT;
	}
	
	public void moveRight(int dx) {
		x += dx;		
		moving = true;
		pose = RT;
	}
	
	public void setVelocityX(int vx) {
		this.vx = vx;
	}
	
	public void setVelocityY(int vy) {
		this.vy = vy;
	}
	
	public void moveX() {
		x += vx;
		moving = true;
		if (vx < 0) {
			pose = LT;
		} else {
			pose = RT;
		}
	}
	
	public void moveY() {
		y += vy;
		moving = true;
		if (vy < 0) {
			pose = UP;
		} else {
			pose = DN;
		}
	}
	
	public void chase(Sprite s) {
		if(x > s.x)  moveLeft(2);
		if(x < s.x)  moveRight(2);
		if(y > s.y)  moveUp(2);
		if(y < s.y)  moveDown(2);
	}
	
	public void die() {
		dead = true;
		pose = DEAD;
	}
	
	public void bounceOffVerticalSurface() {
		vy = -vy;
	}
	
	public void bounceOffHorizontalSurface() {
		vx = -vx;
	}
	
}