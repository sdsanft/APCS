public class head {
	public static void main(String args[]) {
		int i[] = {-7, 15, 21, 22, 43, 49, 51, 67, 78, 81, 84, 89, 95, 97};
		Integer iw[] = new Integer[14];
		for(int k = 0; k < 14; k++) {
			iw[k] = i[k];
		}
		
		System.out.println(binarySearch(iw, 22)); //3
		System.out.println(binarySearch(iw, 89)); //11
		System.out.println(binarySearch(iw, -100)); //-1
		System.out.println(binarySearch(iw, 72)); //-1
		System.out.println(binarySearch(iw, 102)); //-1
	}
	
	private static int binarySearch(Comparable a[], Comparable srchVal) {
		int lb = 0;
		int ub = a.length - 1;
		while(lb <= ub) {
			int mid = (lb + ub)/2;
			
			if (a[mid] == srchVal) {
				return mid;
			} else if (srchVal.compareTo(a[mid]) == 1) {
				lb = mid + 1;
			} else {
				ub = mid -1;
			}
		}
		return -1;
	}
	
	private static int revBinarySearch(int a[], int srchVal) {
		int lb = 0;
		int ub = a.length - 1;
		while(lb <= ub) {
			int mid = (lb + ub)/2;
			
			if (a[mid] == srchVal) {
				return mid;
			} else if (srchVal < a[mid]) {
				lb = mid + 1;
			} else {
				ub = mid -1;
			}
		}
		return -1;
	}
}
