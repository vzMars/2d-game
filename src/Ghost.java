
public class Ghost extends Sprite {
	
	static String[] pose = { "up", "dn", "lt", "rt" };

	public Ghost(int x, int y, int scale) {
		super("g", x, y, scale, scale, pose, 3, 10);
	}
}
