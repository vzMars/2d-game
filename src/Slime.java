
public class Slime extends Sprite {
	static String[] pose = { "up", "dn", "lt", "rt" };

	public Slime(int x, int y) {
		super("sl", x, y, 64, 64, pose, 3, 10);
	}
}
