
public class Girl extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt" };

	public Girl(int x, int y, int scale) {
		super("girl", x, y, scale, scale, direction, 3, 10);
	}
	
}