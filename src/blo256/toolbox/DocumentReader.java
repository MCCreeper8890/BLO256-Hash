package blo256.toolbox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DocumentReader {
	
	private BufferedReader reader;
	private boolean ready;
	
	private String dir;
	
	public DocumentReader(String dir) {
		this.dir = dir;
		try {
			this.reader = new BufferedReader(new FileReader(dir));
			ready = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ready = false;
		}
	}
	
	public String getDir() {
		return dir;
	}
	
	public boolean isReady() {
		return ready;
	}
	
	public boolean dataReady() {
		try {
			return reader.ready();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public String readLine() {
		if (!ready) {
			return "NOT_READY";
		}
		String out = "IO_ERROR";
		try {
			out = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

}
