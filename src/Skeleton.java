
public class Skeleton extends Sprite {
	
	static String[] pose = { "up", "dn", "lt", "rt" };

	public Skeleton(int x, int y, int scale) {
		super("s", x, y, scale, scale, pose, 3, 10);
	}
}
