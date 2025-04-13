import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TileMap {
	String[] map;
	
	Image[] tile;
	String[] tileName;
	
	int scale;
	
	public TileMap(String filename, int scale) {
		loadMap(filename);
		loadAssets();
		this.scale = scale;
	}
	
	public void loadMap(String filename) {
		File file = new File(filename);
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			
			int n = Integer.parseInt(input.readLine()); // How many rows in the map?
			
			map = new String[n];
			
			for(int row = 0; row < n; row++) {
				map[row] = input.readLine();
			}
			
			n = Integer.parseInt(input.readLine()); // How many tiles?
			
			tile = new Image[n];
			tileName = new String[n];
			
			for(int i = 0; i < n; i++) {
				tileName[i] = input.readLine();
			}
			
			input.close();
		} catch (IOException e) {}
	}
	
	public void loadAssets() {
		for(int i = 0; i < tile.length; i++) {
			tile[i] = getImage(tileName[i]);
		}
	}
	
	public void draw(Graphics pen) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length(); j++) {
				char c = map[i].charAt(j);
				
				// Water and Grass
				if(c == 'G')  pen.drawImage(tile[0], j * scale, i * scale, scale, scale, null);
				if(c == 'W')  pen.drawImage(tile[1], j * scale, i * scale, scale, scale, null);
				
				// Borders (top, right, bottom, left)
				if(c == '1')  pen.drawImage(tile[0], j * scale, i * scale, scale, scale, null);
				if(c == '2')  pen.drawImage(tile[0], j * scale, i * scale, scale, scale, null);
				if(c == '3')  pen.drawImage(tile[0], j * scale, i * scale, scale, scale, null);
				if(c == '4')  pen.drawImage(tile[0], j * scale, i * scale, scale, scale, null);
				
				// Objects
				if(c == 'M')  pen.drawImage(tile[0], j * scale, i * scale, scale, scale, null);
				if(c == 'T')  pen.drawImage(tile[1], j * scale, i * scale, scale, scale, null);
				if(c == 'R')  pen.drawImage(tile[2], j * scale, i * scale, scale, scale, null);
				if(c == 'C')  pen.drawImage(tile[3], j * scale, i * scale, scale, scale, null);
				if(c == 'V')  pen.drawImage(tile[4], j * scale, i * scale, scale, scale, null);
			}
		}
	}

	
	public Image getImage(String filename) {
		return Toolkit.getDefaultToolkit().getImage(filename);
	}
}
