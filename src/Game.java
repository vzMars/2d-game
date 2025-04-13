import java.awt.Graphics;

public class Game extends GameBase {
	
	Player player = new Player(300, 500, 64);
	WorldMap worldMap = new WorldMap(64);

	public void inGameLoop() {
		if(pressing[UP])	player.moveUp(4);
		if(pressing[DN])	player.moveDown(4);
		if(pressing[LT])	player.moveLeft(4);
		if(pressing[RT])	player.moveRight(4);
		
		for(int i = 0; i < worldMap.wall.length; i++) {
			if(player.overlaps(worldMap.wall[i])) {
				player.pushAwayFrom(worldMap.wall[i]);
			}
		}
	}

	public void paint(Graphics pen) {
		worldMap.draw(pen);
		player.draw(pen);
	}
	
	public void initialize() {
	}
	
}
