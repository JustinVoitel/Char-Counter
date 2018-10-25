package system;

public class CharCounterSystem {
	private static Reader reader = new Reader();
	private static Histogram histogram = new Histogram();
	//change directory of file in order to use this feature
	private static String url = "C:/Users/justi/WorkspaceEclipse/CharCounter/bin/file.txt";
	private static String url2 = "C:\\Users\\justi\\git\\Char-Counter\\CharCounter\\bin\\file.txt";
	
	public static void main(String[] args) {
		System.out.println("Reading...");
		histogram.convertLines(url2);
		//reader.readString("Test Text");
		System.out.println("...finished!");
	}

}
