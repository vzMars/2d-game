import java.awt.Color;
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
				// 1  = A = Grass
				// 2  = B = Water
				// 3  = C = Top-Border
				// 4  = D = Right-Border
				// 5  = E = Bottom-Border
				// 6  = F = Left-Border
				// 7  = G = Mountain
				// 8  = H = Tree
				// 9  = I = Town
				// 10 = J = Road
				// 11 = K = Castle
				// 12 = L = Rock Wall 1
				// 13 = M = Bridge
				// 14 = N = Stone Wall 1
				// 15 = O = Stone Wall 2
				// 16 = P = Door 1
				// 17 = Q = Door 2
				// 18 = R = Floor
				// 19 = S = Pot
				// 20 = T = Flowers
				// 21 = U = Well
				// 22 = V = Chest
				// 23 = W = Statue
				// 24 = X = Table
				// 25 = Y = Fence 1
				// 26 = Z = Fence 2
				// 27 = [ = Bush
				// 28 = \ = Stone Floor
				// 29 = ] = Black Floor
				// 30 = ^ = Rock Wall 2
				// 31 = _ = Door 3
				// 32 = ` = Bed
				// 33 = a = Stairs Down
				// 34 = b = Stairs Up
				// 35 = c = Pillar
				// 36 = d = Torch
				
				if(c != '0' && c != '@') {
					pen.drawImage(tile[c - 'A'], j * scale, i * scale, scale, scale, null);
				}
			}
		}
	}

	
	public Image getImage(String filename) {
		return Toolkit.getDefaultToolkit().getImage(filename);
	}
}
