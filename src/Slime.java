
public class Slime extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt", "d" };

	public Slime(int x, int y, int scale) {
		super("sl", x, y, scale, scale, direction, 3, 10);
	}
}
