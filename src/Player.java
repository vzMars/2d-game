
public class Player extends Sprite {
	
	static String[] pose = { "up", "dn", "lt", "rt" };

	public Player(int x, int y, int scale) {
		super("p", x, y, scale, scale, pose, 3, 10);
	}

}
