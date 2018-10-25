package system;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Reader {
	String text;
	
	public Reader() {
		super();
	}
	
	public ArrayList<String> readString(String text) {
		ArrayList<String> line = new ArrayList<>();
		line.add(text);
		return line;
	}
	
	public ArrayList<String> readFile(String filePath){
		ArrayList<String> lines = new ArrayList<>();
		try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)){
	        stream.forEach(s -> lines.add(s));
	    }
	    catch (IOException e){
	        e.printStackTrace();
	    }
	    return lines;
	}
}
