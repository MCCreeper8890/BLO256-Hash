package blo256;

import blo256.toolbox.Maths;

public class LightsOut {
	
	private boolean[][] lightStates;
	
	private int width;
	private int height;
	
	public LightsOut(int width, int height) {
		this.width = width;
		this.height = height;
		lightStates = new boolean[width][height];
	}
	
	public void pressLight(int x, int y) {
		updateLight(x, y);
		updateLight(x - 1, y);
		updateLight(x + 1, y);
		updateLight(x, y - 1);
		updateLight(x, y + 1);
	}
	
	private void updateLight(int x, int y) {
		x = Maths.constrainInt(x, 0, width - 1);
		y = Maths.constrainInt(y, 0, height - 1);
		lightStates[x][y] = !lightStates[x][y];
	}
	
	public boolean[][] gameState() {
		return lightStates;
	}
	
	public int width() {
		return width;
	}
	
	public int height() {
		return height;
	}
	
	public void drawState() {
		for (int y = 0; y < height; y++) {
			String line = "";
			for (int x = 0; x < width; x++) {
				if (lightStates[x][y]) {
					line = line + "# ";
				} else {
					line = line + "  ";
				}
			}
			System.out.println(line);
		}
	}

}
