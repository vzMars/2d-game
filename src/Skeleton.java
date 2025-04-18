
public class Skeleton extends Sprite {
	
	static String[] direction = { "up", "dn", "lt", "rt" };

	public Skeleton(int x, int y, int scale) {
		super("s", x, y, scale, scale, direction, 3, 10);
	}
}
