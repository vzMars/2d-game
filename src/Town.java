import java.awt.Graphics;

public class Town extends Room {
	
	static String[] filename = {
			"town-map.txt", 
			"town-map-border-top.txt",
			"town-map-border-right.txt",
			"town-map-border-bottom.txt",
			"town-map-border-left.txt",
			"town-map-objects.txt",
			"town-map-invisible-walls.txt"};
	
	Girl girl1;
	Girl girl2;
	
	public Town() {
		super(filename);
		girl1 = new Girl(253, 387, SCALE);
		girl2 = new Girl(1335, 367, SCALE);
		girl1.setVelocityY(1);
		girl2.setVelocityX(-1);
	}

	public void inGameLoopRoomSpecific() {
		npcMovement();
		enterCave1();
	}
	
	public void npcMovement() {
		girl1.moveY();
		girl2.moveX();
		
		checkWalls(girl1);
		checkOffScreen(girl1);
		
		checkWalls(girl2);
		checkOffScreen(girl2);
		
		if(player.overlaps(girl1)) {
			girl1.bounceOffVerticalSurface();
		}
		
		if(player.overlaps(girl2)) {
			girl2.bounceOffHorizontalSurface();
		}
	}
	
	public void enterCave1() {
		if ((player.x >= 1505 && player.x <= 1535) && 
			(player.y >= 133 && player.y <= 145)) {
				Room.current = Room.room[2];
				player.x = 131;
				player.y = 367;
		}
	}
	
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
		girl1.draw(pen);
		girl2.draw(pen);
	}

}
