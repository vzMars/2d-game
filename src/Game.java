import java.awt.Graphics;

public class Game extends GameBase {
	
//	Player player = new Player(100, 100);
//	Skeleton player = new Skeleton(100, 100);
//	Ghost player = new Ghost(100, 100);
	Slime player = new Slime(100, 100);
	Rect[] wall = new Rect[4];

	public void inGameLoop() {
		if(pressing[UP])	player.moveUp(2);
		if(pressing[DN])	player.moveDown(2);
		if(pressing[LT])	player.moveLeft(2);
		if(pressing[RT])	player.moveRight(2);
		
		for(int i = 0; i < wall.length; i++) {
			if(player.overlaps(wall[i])) {
				player.pushAwayFrom(wall[i]);
			}
		}
	}

	public void paint(Graphics pen) {
		player.draw(pen);
		
		for(int i = 0; i < wall.length; i++ ) {
			wall[i].draw(pen);
		}
	}
	
	public void initialize() {
		wall[0] = new Rect (0,0,800,50);
		wall[1] = new Rect (750,0,50,600);
		wall[2] = new Rect (0,550,800,50);
		wall[3] = new Rect (0,0,50,600);
	}
	
}
