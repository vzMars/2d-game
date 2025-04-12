
public class Player extends Sprite {
	
	static String[] pose = { "up", "dn", "lt", "rt" };

	public Player(int x, int y) {
		super("p", x, y, 64, 64, pose, 3, 10);
	}

}
