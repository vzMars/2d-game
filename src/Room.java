import java.awt.Color;
import java.awt.Graphics;

public abstract class Room extends RoomBase {
	final static int SCALE = 64;
	
	Map map;
	
	static Player player = new Player(510, 490, SCALE);
	
	static int count = 0;
	
	static Room[] room = new Room[5];
	
	static Room current;
	
	public Room(String[] filename) {
		map = new Map(filename, SCALE);
		room[count++] = this;
	}
	
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
	}
	
	public abstract void inGameLoopRoomSpecific();
	
	public void inGameLoop() {
		if(pressing[SPACE]) player.attack();
		if(pressing[UP])	player.moveUp(4);
		if(pressing[DN])	player.moveDown(4);
		if(pressing[LT])	player.moveLeft(4);
		if(pressing[RT])	player.moveRight(4);
		
		checkWalls();
		checkOffScreen();
		inGameLoopRoomSpecific();
		
	}
	
	public void checkWalls() {
		for(int i = 0; i < map.wall.length; i++) {
			if(player.overlaps(map.wall[i])) {
				player.pushAwayFrom(map.wall[i]);
			}
		}
	}
	
	public void checkOffScreen() {
//		Rect offscreen = new Rect(-1, player.y, SCALE, SCALE);
//		Rect rightOffscreen = new Rect(1920, player.y, SCALE, SCALE);
//		Rect topOffscreen = new Rect(player.x, -1, SCALE, SCALE);
//		Rect bottomOffscreen = new Rect(player.x, 1280, SCALE, SCALE);
		Rect top = new Rect(0, -70, SCALE * 30, SCALE);
		Rect left = new Rect(-80, 0, SCALE, SCALE * 30);
		Rect bottom = new Rect(0, 1280, SCALE * 30, SCALE);
		

		if(player.overlaps(top) ) {
			player.pushAwayFrom(top);
		}
		
		if(player.overlaps(bottom) ) {
			player.pushAwayFrom(bottom);
		}
		
		if(player.overlaps(left) ) {
			player.pushAwayFrom(left);
		}
//		System.out.println("current x: " + player.x);
//		System.out.println("current y: " + player.y);
//		if(player.x < 0) player.pushAwayFrom(new Rect(-1, player.y, SCALE, SCALE));
	}
}
