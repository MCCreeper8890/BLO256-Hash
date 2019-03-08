package blo256.toolbox;

public class Maths {
	
	public static float constrainFloat(float x, float min, float max) {
		return Math.min(Math.max(x, min), max);
	}
	
	public static int constrainInt(int x, int min, int max) {
		return Math.min(Math.max(x, min), max);
	}
	
	public static String decimalGrid(boolean[][] grid, int width, int height) {
		String output = "";
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x+=4) {
				int val = 0;
				if (grid[x][y]) val += 8;
				if (grid[x+1][y]) val += 4;
				if (grid[x+2][y]) val += 2;
				if (grid[x+3][y]) val += 1;
				output = output + Integer.toHexString(val);
			}
		}
		return output;
	}

}
