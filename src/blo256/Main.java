package blo256;

import blo256.toolbox.DocumentReader;
import blo256.toolbox.Maths;

public class Main {
	
	// Configuration
	public static final int dataLength = 8;
	public static final String file = "test.txt";
	
	// Derived settings
	public static final int gridSize = (int) Math.pow(2, dataLength / 2); //Doubles as midpoint for MSB-LSB
	public static final int dataSize = (int) Math.pow(2, dataLength);
	
	// Modules
	public static LightsOut lightsOut;
	public static DocumentReader reader;
	
	// Variables
	public static String result;
	
	public static void main(String[] args) {
		
		System.out.println("Reading data from file: " + file);
		System.out.println("Data length is " + dataLength + " bits");
		System.out.println("Lights Out grid is " + gridSize + "x" + gridSize);
		System.out.println("Output length will be " + dataSize + " bits");
		//System.out.println("Maximum output: " + Long.MAX_VALUE);
		
		// Create modules
		lightsOut = new LightsOut(gridSize, gridSize);
		reader = new DocumentReader(file);
		
		// For each line, run on each character
		String line = null;
		while (reader.dataReady() && (line = reader.readLine()) != null) {
			byte[] chars = line.getBytes();
			// Then, for each byte, get LSB and MSB
			for (byte chr : chars) {
				int msb = Math.floorDiv(chr, gridSize);
				int lsb = Math.floorMod(chr, gridSize);
				lightsOut.pressLight(lsb, msb);
			}
		}
		
		// When it's done, get a number representing its game state
		lightsOut.drawState();
		result = Maths.decimalGrid(lightsOut.gameState(), gridSize, gridSize);
		System.out.println("Resulting BLO-256 hash is: " + result);
		
	}

}
