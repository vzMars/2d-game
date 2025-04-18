
public class Cave2 extends Room {

	static String[] filename = {
			"cave2.txt", 
			"cave2-border-top.txt",
			"cave2-border-right.txt",
			"cave2-border-bottom.txt",
			"cave2-border-left.txt",
			"cave2-objects.txt"};
	
	public Cave2() {
		super(filename);
	}

	public void inGameLoopRoomSpecific() {
		enterCave3();
	}
	
	public void enterCave3() {
		if ((player.x >= 1839 && player.x <= 1855) && 
			(player.y >= 545 && player.y <= 575)) {
				Room.current = Room.room[4];
				player.x = 51;
				player.y = 549;
		}
	}

}
