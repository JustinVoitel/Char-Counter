package system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HistogramTest {
	Reader reader;
	Histogram histogram;
	public HistogramTest() {
		reader = new Reader();
		histogram = new Histogram();
	}
	
	@Test
	void testLines() {
		ArrayList<String> text = reader.readString("test");
		this.histogram.convertLines(text);
		assertEquals(4,histogram.count("all"));
	}
	
//	@Test
//	void testFrequency() {
//		int diff = histogram.getDiffOfLower();
//		ArrayList<String> text = reader.readString("test");
//		int[] freqLower = histogram.getFreqLower();
//		this.histogram.convertLines(text);
//		this.histogram.writeFrequency();
//		
//	}
	
}
