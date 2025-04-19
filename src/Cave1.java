
public class Cave1 extends Room {

	static String[] filename = {
			"cave1.txt", 
			"cave1-border-top.txt",
			"cave1-border-right.txt",
			"cave1-border-bottom.txt",
			"cave1-border-left.txt",
			"cave1-objects.txt"};
	
	public Cave1() {
		super(filename);
	}

	public void inGameLoopRoomSpecific() {
		System.out.println("Player current x: " + player.x);
		System.out.println("Player current y: " + player.y);
		enterCave2();
	}
	
	public void enterCave2() {
		if ((player.x >= 1839 && player.x <= 1855) && 
			(player.y >= 545 && player.y <= 575)) {
				Room.current = Room.room[3];
				player.x = 51;
				player.y = 549;
		}
	}

}
