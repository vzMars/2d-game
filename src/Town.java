
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
		// TODO Auto-generated method stub
		
	}

}
