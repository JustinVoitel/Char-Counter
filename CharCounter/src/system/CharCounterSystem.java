package system;

public class CharCounterSystem {
	private static Reader reader = new Reader();
	private static Histogram histogram = new Histogram();
	private static Boolean active = true;
	private static String url = "C:/Users/justi/WorkspaceEclipse/CharCounter/bin/file.txt";
	
	public static void main(String[] args) {
		System.out.println("Reading...");
		//histogram.convertValue(reader.readFile(url));
		reader.stringReader("Test Text");
		System.out.println("...finished");
	}

}
