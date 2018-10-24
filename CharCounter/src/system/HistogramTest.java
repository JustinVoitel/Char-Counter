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
	
	
}
