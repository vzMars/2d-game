import java.awt.Graphics;

public class WorldMap {
	
//	String[] fileName = {
//			"world-map.txt", 
//			"world-map-border-top.txt",
//			"world-map-border-right.txt",
//			"world-map-border-bottom.txt",
//			"world-map-border-left.txt",
//			"world-map-objects.txt"};
	
//	String[] fileName = {
//			"town-map.txt", 
//			"town-map-border-top.txt",
//			"town-map-border-right.txt",
//			"town-map-border-bottom.txt",
//			"town-map-border-left.txt",
//			"town-map-objects.txt",
//			"town-map-invisible-walls.txt"};
	
//	String[] fileName = {
//			"cave1.txt", 
//			"cave1-border-top.txt",
//			"cave1-border-right.txt",
//			"cave1-border-bottom.txt",
//			"cave1-border-left.txt",
//			"cave1-objects.txt"};
	
//	String[] fileName = {
//			"cave2.txt", 
//			"cave2-border-top.txt",
//			"cave2-border-right.txt",
//			"cave2-border-bottom.txt",
//			"cave2-border-left.txt",
//			"cave2-objects.txt"};
	
	String[] fileName = {
			"cave3.txt", 
			"cave3-border-top.txt",
			"cave3-border-right.txt",
			"cave3-border-bottom.txt",
			"cave3-border-left.txt",
			"cave3-objects.txt"};
	
	TileMap tileMap[] = new TileMap[fileName.length];
	Rect[] wall;
	static int index = 0;
	int scale;
	
	public WorldMap(int scale) {
		this.scale = scale;
		for(int i = 0; i < tileMap.length; i++) {
			tileMap[i] = new TileMap(fileName[i], scale);
		}
		loadWalls();
	}
	
	public void draw(Graphics pen) {
		for(int i = 0; i < tileMap.length; i++) {
			tileMap[i].draw(pen);
		}
	}
	
	public void loadWalls() {
		int count = 0;
		
		for(int i = 0; i < tileMap.length; i++) {
			count += getWallCount(tileMap[i].map);
		}

		wall = new Rect[count];
		
		for(int i = 0; i < tileMap.length; i++) {
			createWalls(tileMap[i].map);
		}
	}
	
	public int getWallCount(String[] map) {
		int count = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length(); j++) {
				char c = map[i].charAt(j);
				
				if(c == 'B' ||
				   c == 'G' || 
				   c == 'H' || 
				   c == 'L' ||
				   c == 'N' ||
				   c == 'O' ||
				   c == 'P' ||
				   c == 'S' ||
				   c == 'U' ||
				   c == 'V' ||
				   c == 'W' ||
				   c == 'X' ||
				   c == 'Y' ||
				   c == 'Z' ||
				   c == '[' ||
				   c == ']' ||
				   c == '^' ||
				   c == '_' ||
				   c == 'c' ||
				   c == 'd' ||
				   c == '@') {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public void createWalls(String[] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length(); j++) {
				char c = map[i].charAt(j);
				
				if(c == 'B' ||
				   c == 'G' || 
				   c == 'H' || 
				   c == 'L' ||
				   c == 'N' ||
				   c == 'O' ||
				   c == 'P' ||
				   c == 'S' ||
				   c == 'U' ||
				   c == 'V' ||
				   c == 'W' ||
				   c == 'X' ||
				   c == 'Y' ||
				   c == 'Z' ||
				   c == '[' ||
				   c == ']' ||
				   c == '^' ||
				   c == '_' ||
				   c == 'c' ||
				   c == 'd' ||
				   c == '@') {
					wall[index] = new Rect(j * scale, i * scale, scale / 2, scale / 2);
					index++;
				}
			}
		}
	}
	
}
