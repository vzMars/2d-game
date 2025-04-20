import java.awt.Graphics;

public class Cave1 extends Room {

	static String[] filename = {
			"cave1.txt", 
			"cave1-border-top.txt",
			"cave1-border-right.txt",
			"cave1-border-bottom.txt",
			"cave1-border-left.txt",
			"cave1-objects.txt"};
	
	Skeleton s1;
	Sprite[] monster = {
			new Ghost(895, 244, SCALE),
			new Skeleton(563, 569, SCALE),
			new Skeleton(959, 633, SCALE),
			new Skeleton(1671, 561, SCALE)};
	
	public Cave1() {
		super(filename);
		s1 = new Skeleton(387, 377, SCALE);
		s1.die();
	}
	
	public void inGameLoopRoomSpecific() {
		monsterMovement(monster);
		
		playerAttackMonster(monster);
		
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
	
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
		s1.draw(pen);
		
		for(int i = 0;i < monster.length; i++) {
			monster[i].draw(pen);
		}
	}

}
