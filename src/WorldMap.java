import java.awt.Color;
import java.awt.Graphics;

public class WorldMap extends Room {

	static String[] filename = {
			"world-map.txt", 
			"world-map-border-top.txt",
			"world-map-border-right.txt",
			"world-map-border-bottom.txt",
			"world-map-border-left.txt",
			"world-map-objects.txt"};
	
	public WorldMap() {
		super(filename);
	}

	public void inGameLoopRoomSpecific() {
//		System.out.println("Player current x: " + player.x);
//		System.out.println("Player current y: " + player.y);
		enterTown();
	}
	
	public void enterTown() {
		if ((player.x >= 993 && player.x <= 1045) && 
				(player.y >= 225 && player.y < 275)) {
				Room.current = Room.room[1];
		}
	}
	
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
//		pen.setColor(Color.RED);
//		pen.fillRect(0, 1280, SCALE * 30, SCALE);
	}

}
