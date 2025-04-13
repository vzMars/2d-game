import java.awt.Graphics;

public class Game extends GameBase {
	
	Player player = new Player(100, 100, 32);
	Rect[] wall = new Rect[4];
	WorldMap worldMap = new WorldMap(32);

	public void inGameLoop() {
		if(pressing[UP])	player.moveUp(2);
		if(pressing[DN])	player.moveDown(2);
		if(pressing[LT])	player.moveLeft(2);
		if(pressing[RT])	player.moveRight(2);
		
//		for(int i = 0; i < wall.length; i++) {
//			if(player.overlaps(wall[i])) {
//				player.pushAwayFrom(wall[i]);
//			}
//		}
	}

	public void paint(Graphics pen) {
//		for(int i = 0; i < wall.length; i++) {
//			wall[i].draw(pen);
//		}
		worldMap.draw(pen);
		player.draw(pen);
	}
	
	public void initialize() {
//		wall[0] = new Rect(0, 0, 640, 64);
//		wall[1] = new Rect(576, 0, 64, 640);
//		wall[2] = new Rect(0, 576, 640, 64);
//		wall[3] = new Rect(0, 0, 64, 640);
	}
	
}
