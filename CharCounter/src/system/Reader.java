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
	
	public String readLine() {
		this.text = this.scanner.nextLine();
		return this.text;
	}
	
	public ArrayList<Integer> stringReader(String text) {
		ArrayList<Integer> charList = new ArrayList<>();
		StringReader reader= new StringReader(text);
		int data;
		try {
			data = reader.read();
			while(data != -1) {
				  charList.add(data);
				  data = reader.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return charList;
	}
	
	public String readFile(String filePath){
	    StringBuilder contentBuilder = new StringBuilder();
	    try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)){
	        stream.forEach(s -> contentBuilder.append(s).append(""));
	    }
	    catch (IOException e){
	        e.printStackTrace();
	    }
	    return contentBuilder.toString();
	}
}
