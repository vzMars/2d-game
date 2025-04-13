import java.awt.Graphics;

public class WorldMap {
	
	static String[] fileName = {
			"world-map.txt", 
			"world-map-border-top.txt",
			"world-map-border-right.txt",
			"world-map-border-bottom.txt",
			"world-map-border-left.txt",
			"world-map-objects.txt"};
	
	TileMap worldMap;
	TileMap worldMapTop;
	TileMap worldMapRight;
	TileMap worldMapBottom;
	TileMap worldMapLeft;
	TileMap worldMapObjects;

	public WorldMap(int scale) {
		worldMap = new TileMap(fileName[0], scale);
		worldMapTop = new TileMap(fileName[1], scale);
		worldMapRight = new TileMap(fileName[2], scale);
		worldMapBottom = new TileMap(fileName[3], scale);
		worldMapLeft = new TileMap(fileName[4], scale);
		worldMapObjects = new TileMap(fileName[5], scale);
	}
	
	public void draw(Graphics pen) {
		worldMap.draw(pen);
		worldMapTop.draw(pen);
		worldMapRight.draw(pen);
		worldMapBottom.draw(pen);
		worldMapLeft.draw(pen);
		worldMapObjects.draw(pen);
	}
	
}
