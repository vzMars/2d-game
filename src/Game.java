import java.awt.Graphics;

public class Game extends GameBase {
	
	Rect r = new Rect(100,100,50,50);
	Rect[] wall = new Rect[4];

	public void inGameLoop() {
		if(pressing[UP])   r.go_UP(2);
		if(pressing[DN])   r.go_DN(2);
		if(pressing[LT])   r.go_LT(2);
		if(pressing[RT])   r.go_RT(2);
		
		for(int i = 0; i < wall.length; i++) {
			if(r.overlaps(wall[i])) {
				r.pushAwayFrom(wall[i]);
			}
		}
	}

	public void paint(Graphics pen) {
		r.draw(pen);
		
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
