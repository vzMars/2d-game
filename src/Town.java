
public class Town extends Room {
	
	static String[] filename = {
			"town-map.txt", 
			"town-map-border-top.txt",
			"town-map-border-right.txt",
			"town-map-border-bottom.txt",
			"town-map-border-left.txt",
			"town-map-objects.txt",
			"town-map-invisible-walls.txt"};
	
	public Town() {
		super(filename);
	}

	public void inGameLoopRoomSpecific() {
		enterCave1();
	}
	
	public void enterCave1() {
		if ((player.x >= 1505 && player.x <= 1535) && 
			(player.y >= 133 && player.y <= 145)) {
				Room.current = Room.room[2];
				player.x = 131;
				player.y = 367;
		}
	}

}
