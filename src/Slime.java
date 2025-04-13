
public class Slime extends Sprite {
	static String[] pose = { "up", "dn", "lt", "rt" };

	public Slime(int x, int y, int scale) {
		super("sl", x, y, scale, scale, pose, 3, 10);
	}
}
