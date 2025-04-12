
public class Skeleton extends Sprite {
	
	static String[] pose = { "up", "dn", "lt", "rt" };

	public Skeleton(int x, int y) {
		super("s", x, y, 64, 64, pose, 3, 10);
	}
}
