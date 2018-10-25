package system;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Histogram {
	private int[] frequencyUpper;
	private int[] frequencyLower;
	private int diffOfCharLower = 97;
	private int diffOfCharUpper = 65;
	private int lowestKey = 0;
	
	public Histogram() {
		super();
		this.frequencyUpper = new int[26];
		this.frequencyLower = new int[26];
	}
	
	public int[] getFreqLower() {
		return this.frequencyLower;
	}
	
	public int getDiffOfLower() {
		return this.diffOfCharLower;
	}
	
	public void convertLines(ArrayList<String> lines) { 
		String s = lines.stream().map(e-> e.toString()).reduce("", String::concat);
		char text [] = s.toCharArray();
		for(int i =0;i<text.length;i++) {
			int index = this.charToIndex(text[i]);
			if(index >=this.diffOfCharLower && index<=this.diffOfCharLower+this.frequencyLower.length-1) {
				this.frequencyLower[index-this.diffOfCharLower]++;
			} else if(index >=this.diffOfCharUpper && index<=this.diffOfCharUpper+this.frequencyUpper.length-1){
				this.frequencyUpper[index-this.diffOfCharUpper]++;
			}
		}
		printFrequency();
		writeFrequency();
	}
	
	public int count(String object) {
		int countLower=0;
		int countUpper=0;
		for(int i = 0;i<this.frequencyUpper.length;i++) {
			countUpper+=this.frequencyUpper[i];
		}
		for(int i = 0;i<this.frequencyLower.length;i++) {
			countLower+=this.frequencyLower[i];
		}
		if(object=="lower") {
			return countLower;
		}else if(object=="upper") {
			return countUpper;
		}
		return countUpper+countLower;
	}
	
	public ArrayList<ArrayList<Integer>> calcMostFrequent(int freqArr[],int diffOfChar) {
		Map<Integer,Integer> frequent = new HashMap<>();
		for(int i=0;i<freqArr.length;i++) {
			int count = freqArr[i];
			int character = i+diffOfChar;
			if(count!=0) {
				if(frequent.size()<=4) {
					frequent.put(character, count);
				}else {
					for (Integer key : frequent.keySet()) {
						int value = frequent.get(key);
						if(value<count) {
							if(this.lowestKey==0) {
								this.lowestKey=key;
							}else if(value<freqArr[this.lowestKey-diffOfChar]){
								this.lowestKey=key;
							}						
						}
					}
					if(this.lowestKey!=0) {
						frequent.remove(this.lowestKey);
						frequent.put(character, count);
						this.lowestKey=0;
					}
				}
			}
		}

		return sortMostFrequent(frequent);
	}
	
	public ArrayList<ArrayList<Integer>> sortMostFrequent(Map<Integer, Integer> frequent){
		ArrayList<ArrayList<Integer>> sortedList = new ArrayList<>();
		for (Integer key : frequent.keySet()) {
			int value = frequent.get(key);
			sortedList.add(new ArrayList<Integer>(Arrays.asList(key,value)));
		}
		Collections.sort(sortedList,(a,b)->b.get(1).compareTo(a.get(1)));
		return sortedList;
	}
	
	public String printMostFrequent() {
		ArrayList<ArrayList<Integer>> list = this.calcMostFrequent(this.frequencyLower,this.diffOfCharLower);
		String mostFrequent="";
		int count = this.count("lower");
		double partPercentage=0;
		for(ArrayList<Integer> item: list) {
			partPercentage += ((double) item.get(1)/count)*100;
		}
		
		for(ArrayList<Integer> item: list) {
			String stars="";
			int part = (int) ((item.get(1)/((partPercentage*count)/100))/0.05);
			for(int i =0;i<=part;i++) {
				stars+="*";
			}
			mostFrequent+=this.indexToChar(item.get(0))+" -> "+stars+"("+(float)item.get(1)/count*100+"%)"+"\n";
		}
		return mostFrequent;
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
		List<String> lines = new ArrayList<>();
		for(int i=0;i<this.frequencyUpper.length;i++) {
			lines.add(
				indexToChar(i+this.diffOfCharUpper)+" -> "+this.frequencyUpper[i]+"\t\t\t\t"+
				indexToChar(i+this.diffOfCharLower)+" -> "+this.frequencyLower[i]		
			);
		}
		lines.add("count: "+this.count("all"));
		lines.add("most frequent:\n"+this.printMostFrequent());
		Path file = Paths.get(url);
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
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
}
