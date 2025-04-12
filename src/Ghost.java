
public class Ghost extends Sprite {
	
	static String[] pose = { "up", "dn", "lt", "rt" };

	public Ghost(int x, int y) {
		super("g", x, y, 64, 64, pose, 3, 10);
	}
}
