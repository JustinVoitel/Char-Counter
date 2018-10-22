package system;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Histogram {
	private int[] frequencyUpper;
	private int[] frequencyLower;
	private int diffOfCharLower = 97;
	private int diffOfCharUpper = 65;
	
	public Histogram() {
		super();
		this.frequencyUpper = new int[26];
		this.frequencyLower = new int[26];
	}
	
	public void convertValue(String value) {
		char text [] = value.toCharArray();
		for(int i =0;i<text.length;i++) {
			int index = this.charToIndex(text[i]);
			if(index >=97 && index<=122) {
				this.frequencyLower[index-this.diffOfCharLower]++;
			} else if(index >=65 && index<=90){
				this.frequencyUpper[index-this.diffOfCharUpper]++;
			}
		}
		printFrequency();
		writeFrequency();
	}
	
	public void printFrequency() {
		System.out.println("-----UPPER-----");
		for(int i = 0;i<this.frequencyUpper.length;i++) {
			System.out.println(indexToChar(i+this.diffOfCharUpper)+" -> "+this.frequencyUpper[i]);
		}
		System.out.println("-----LOWER-----");
		for(int i = 0;i<this.frequencyLower.length;i++) {
			System.out.println(indexToChar(i+this.diffOfCharLower)+" -> "+this.frequencyLower[i]);
		}
	}
	
	public void writeFrequency() {
		String url = "C:/Users/justi/WorkspaceEclipse/CharCounter/bin/frequency.txt";
		List<String> linesUpper = new ArrayList<>();
		for(int i=0;i<this.frequencyUpper.length;i++) {
			linesUpper.add(
				indexToChar(i+this.diffOfCharUpper)+" -> "+this.frequencyUpper[i]+"\t\t\t"+
				indexToChar(i+this.diffOfCharLower)+" -> "+this.frequencyLower[i]
						
			);
		}
		Path file = Paths.get(url);
		try {
			Files.write(file, linesUpper, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int charToIndex(char character) {
		return (int)character;
	}
	
	public char indexToChar(int index) {
		return (char)index;
	}
	
	public void clearFrequency() {
		
	}
}
