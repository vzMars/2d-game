import java.awt.Graphics;

public class Cave3 extends Room {

	static String[] filename = {
			"cave3.txt", 
			"cave3-border-top.txt",
			"cave3-border-right.txt",
			"cave3-border-bottom.txt",
			"cave3-border-left.txt",
			"cave3-objects.txt"};
	
	Sprite[] monster = {
			new Slime(859, 457, SCALE * 4)};
	
	public Cave3() {
		super(filename);
	}

	public void inGameLoopRoomSpecific() {
		monsterMovement(monster);
		
		playerAttackMonster(monster);
	}
	
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
		
		for(int i = 0;i < monster.length; i++) {
			monster[i].draw(pen);
		}
	}

}
