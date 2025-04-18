import java.awt.Graphics;

public class Game extends GameBase {
	
	public void inGameLoop() {
		Room.current.inGameLoop();
	}

	public void paint(Graphics pen) {
		Room.current.draw(pen);
	}
	
	public void initialize() {
		Room.setUpInput(pressing);
		
		new WorldMap();
		new Town();
		new Cave1();
		new Cave2();
		new Cave3();
		
		Room.current = Room.room[0];
	}
	
}
