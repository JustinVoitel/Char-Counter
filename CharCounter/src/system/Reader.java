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
	Scanner scanner;
	String text;
	
	public Reader() {
		super();
		scanner = new Scanner(System.in);
	}
	
	public ArrayList<String> readString(String text) {
//		ArrayList<Integer> charList = new ArrayList<>();
//		StringReader reader= new StringReader(text);
//		int data;
//		try {
//			data = reader.read();
//			while(data != -1) {
//				  charList.add(data);
//				  data = reader.read();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return charList;
		ArrayList<String> line = new ArrayList<>();
		line.add(text);
		return line;
	}
	
	public ArrayList<String> readFile(String filePath){
		ArrayList<String> lines = new ArrayList<>();
		
//	    StringBuilder contentBuilder = new StringBuilder();
//	    try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)){
//	        stream.forEach(s -> contentBuilder.append(s).append(""));
//	    }
//	    catch (IOException e){
//	        e.printStackTrace();
//	    }
//	    return contentBuilder.toString();
	    
		try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)){
	        stream.forEach(s -> lines.add(s));
	    }
	    catch (IOException e){
	        e.printStackTrace();
	    }
	    return lines;
	}
	
	
}
