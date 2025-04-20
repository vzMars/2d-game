import java.awt.Graphics;

public class Cave2 extends Room {

	static String[] filename = {
			"cave2.txt", 
			"cave2-border-top.txt",
			"cave2-border-right.txt",
			"cave2-border-bottom.txt",
			"cave2-border-left.txt",
			"cave2-objects.txt"};
	
	Sprite[] monster = {
			new Slime(283, 561, SCALE),
			new Slime(567, 489, SCALE),
			new Slime(555, 633, SCALE),
			new Slime(807, 569, SCALE),
			new Slime(1059, 501, SCALE),
			new Slime(1279, 565, SCALE),
			new Slime(1483, 639, SCALE),
			new Slime(1679, 489, SCALE)};
	
	public Cave2() {
		super(filename);
	}

	public void inGameLoopRoomSpecific() {
		monsterMovement(monster);
		
		playerAttackMonster(monster);
		
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
	
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
		
		for(int i = 0;i < monster.length; i++) {
			monster[i].draw(pen);
		}
	}

}
