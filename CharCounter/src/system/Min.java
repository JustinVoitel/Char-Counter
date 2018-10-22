package system;

public class Min {
	public int findMin(int[] a) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i=0;i<a.length;i++) {
			if(a[i] <= min) {
				minIndex=i;
				min = a[i];
			}
		}
		return minIndex;
	}
}
