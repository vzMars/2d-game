
public class Ghost extends Sprite {
	
	static String[] direction = { "up", "dn", "lt", "rt", "d" };

	public Ghost(int x, int y, int scale) {
		super("g", x, y, scale, scale, direction, 3, 10);
	}
}
