import java.awt.Graphics;

public class WorldMap {
	
	String[] fileName = {
			"world-map.txt", 
			"world-map-border-top.txt",
			"world-map-border-right.txt",
			"world-map-border-bottom.txt",
			"world-map-border-left.txt",
			"world-map-objects.txt"};
	
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
				
				if(c == 'W' || c == 'M' || c == 'T') {
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
				
				if(c == 'W' || c == 'M' || c == 'T') {
					wall[index] = new Rect(j * scale, i * scale, scale / 2, scale / 2);
					index++;
				}
			}
		}
	}
	
}
