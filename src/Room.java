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
		
		checkWalls(player);
		checkOffScreen(player);
		inGameLoopRoomSpecific();
	}
	
	public void checkDistanceFromPlayer(Sprite s) {
		int distance = Math.abs(player.x - s.x);
		
		if (distance < 200) {
			s.chase(player);
		}
	}
	
	public void checkWalls(Sprite s) {
		for(int i = 0; i < map.wall.length; i++) {
			if(s.overlaps(map.wall[i])) {
				pushAway(s, map.wall[i]);
			}
		}
	}
	
	public void checkOffScreen(Sprite s) {
		for(int i = 0; i < offscreen.length; i++) {
			if(s.overlaps(offscreen[i])) {
				pushAway(s, offscreen[i]);
			}
		}
	}
	
	public void pushAway(Sprite s, Rect r) {
		if(!(s instanceof Girl)) {
			s.pushAwayFrom(r);
		} else {
			if(s.vx > 0 || s.vx < 0) {
				s.bounceOffHorizontalSurface();
			} else {
				s.bounceOffVerticalSurface();
			}
		}
	}
}
