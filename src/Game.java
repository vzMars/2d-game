import java.awt.Graphics;

public class Game extends GameBase {
	
	Player player = new Player(350, 600, 64);
//	Ghost player = new Ghost(350, 600, 64);
//	Skeleton player = new Skeleton(350, 600, 64);
//	Slime player = new Slime(350, 600, 64);
	WorldMap worldMap = new WorldMap(64);

	public void inGameLoop() {
		if(pressing[SPACE]) player.attack();
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
