import java.awt.Graphics;

public abstract class Room extends RoomBase {
	final static int SCALE = 64;
	
	Map map;
	
	static Player player = new Player(510, 490, SCALE);
	
	static int count = 0;
	
	static Room[] room = new Room[5];

	static Rect[] offscreen = {
			new Rect(0, -70, SCALE * 30, SCALE), 
			new Rect(1920, 0, SCALE, SCALE * 30),
			new Rect(0, 1280, SCALE * 30, SCALE),
			new Rect(-80, 0, SCALE, SCALE * 30)};
	
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
		for(int i = 0; i < offscreen.length; i++) {
			if(player.overlaps(offscreen[i])) {
				player.pushAwayFrom(offscreen[i]);
			}
		}
	}
}
